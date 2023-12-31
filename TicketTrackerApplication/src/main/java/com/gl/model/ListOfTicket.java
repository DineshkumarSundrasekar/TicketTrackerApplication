package com.gl.model;

import java.time.LocalDate;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ListOfTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String ticketTittle;
	String ticketShortDescription;
	LocalDate ticketCreatedOn;
	
}
