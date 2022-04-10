package com.algaworks.algamoney.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {
	
	@NotNull(message = "please enter a valid city")
    private String city;
    private String complement;
    private String district;
    private String number;
    
    @NotNull(message = "please enter a valid state")
    private String state;
    
    @NotNull(message = "please enter a valid address")
    private String street;
    
    @NotNull(message = "please enter a valid zip_code")
    private String zipCode;

    public Address() {
    }

    public Address(String street, String number, String complement, String district, String zipCode, String city, String state) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public String getComplement() {
        return complement;
    }

    public String getDistrict() {
        return district;
    }

    public String getNumber() {
        return number;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                ", district='" + district + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
