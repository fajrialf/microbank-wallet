package com.enigma.walletkurs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer")
public class CustomerEntity {

	@Id
	@Column(name = "customer_number")
	String customerNumber;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "last_name")
	String lastName;

	@Column(name = "birth_date")
	Date birthDate;

	@Column(name = "nik")
	String nik;

	@Column(name = "mother_name")
	String motherName;

	@Column(name = "email")
	String email;

	@Column(name = "password")
	String password;

	
}
