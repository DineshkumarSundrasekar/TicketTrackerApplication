package com.gl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.model.ListOfTicket;

public interface TicketRepository extends JpaRepository<ListOfTicket, Integer>{
	List<ListOfTicket> findByTicketTittle(String ticketTittle);
}
