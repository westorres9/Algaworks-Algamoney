package com.algaworks.algamoney.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.algaworks.algamoney.entities.Category;
import com.algaworks.algamoney.entities.Person;
import com.algaworks.algamoney.entities.Releases;
import com.algaworks.algamoney.entities.enums.TypeOfReleases;

public class ReleasesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Category category;
    private String description;
    private LocalDate dueDate;
    private Long id;
    private String note;
    private LocalDate paymentDate;
    private Person person;
    private TypeOfReleases type;
    private BigDecimal value;

    public ReleasesDTO() {
    }

    public ReleasesDTO(Long id, String description, LocalDate dueDate, LocalDate paymentDate, BigDecimal value, String note, TypeOfReleases type, Category category, Person person) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.value = value;
        this.note = note;
        this.type = type;
        this.category = category;
        this.person= person;
    }

    public ReleasesDTO(Releases entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
        this.dueDate = entity.getDueDate();
        this.paymentDate = entity.getPaymentDate();
        this.value = entity.getValue();
        this.note = entity.getNote();
        this.type = entity.getType();
        this.category = entity.getCategory();
        this.person = entity.getPerson();
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
