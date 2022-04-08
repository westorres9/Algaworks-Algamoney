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

    private Long id;
    private String description;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private BigDecimal value;
    private String note;
    private TypeOfReleases type;
    private Category category;
    private Person person;

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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public TypeOfReleases getType() {
        return type;
    }

    public void setType(TypeOfReleases type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
