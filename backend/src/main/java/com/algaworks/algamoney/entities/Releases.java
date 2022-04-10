package com.algaworks.algamoney.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import com.algaworks.algamoney.entities.enums.TypeOfReleases;

@Entity
@Table(name = "tb_releases")
public class Releases implements Serializable {
    private static final long serialVersionUID= 1L;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @NotNull(message = "please enter a description")
    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String note;
    @Column(name = "payment_date")
    @PastOrPresent(message = "The date given cannot be in the future")
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Enumerated(EnumType.STRING)
    private TypeOfReleases type;


    @Positive(message = "value must be positive")
    private BigDecimal value;

    public Releases() {
    }

    public Releases(Long id, String description, LocalDate dueDate, LocalDate paymentDate, BigDecimal value, String note, TypeOfReleases type, Category category, Person person) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.value = value;
        this.note = note;
        this.type = type;
        this.category = category;
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Releases releases = (Releases) o;
        return Objects.equals(id, releases.id);
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Long getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Person getPerson() {
        return person;
    }

    public TypeOfReleases getType() {
        return type;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setType(TypeOfReleases type) {
        this.type = type;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
