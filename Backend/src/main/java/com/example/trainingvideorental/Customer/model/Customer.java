package com.example.trainingvideorental.Customer.model;


import com.example.trainingvideorental.rental.Auditable;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
//import Lombok;

@Entity
@Getter
@Setter
@Table(name = "customer")


public class Customer  extends Auditable<String>  {

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)

    private  Long customer_id;

    @Column(name = "first_name" )
    private  String firstName;
    @Column(name = "last_name")
    private  String lastName;
    @Column(name = "user_name")
    private  String userName;
    @Column(name = "phone_number")
    private  String phoneNumber;
    @Column(name = "address")
    private  String address;
    @Column(name = "email")
    private  String email;




    public Customer() {

    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public Customer(String firstName, String lastName, String userName, String phoneNumber, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber( String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
