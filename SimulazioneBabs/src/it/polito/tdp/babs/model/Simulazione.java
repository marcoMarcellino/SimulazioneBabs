package it.polito.tdp.babs.model;

import java.time.LocalDate;
import java.util.PriorityQueue;

import javax.print.attribute.standard.MediaSize.Other;

import javafx.event.EventType;


public class Simulazione {
	 LocalDate date ;
	private double k;
	private PriorityQueue pq;
	private Model model;
	
	private enum EventType {
		PICK,DROP;
	}
	
	public Simulazione(LocalDate date, double k,Model model) {
		this.date = date;
		this.k = k;
		this.model=model;
		pq= new PriorityQueue<>();
	}
	
	public void run() {
		model.getTripsByDate(date);
	}
	
	private class Event {
		EventType type;
		LocalDate date;
		Trip trip;
	}

	public Simulazione(LocalDate date, double k, PriorityQueue pq) {
		super();
		this.date = date;
		this.k = k;
		this.pq = pq;
	}

	

}
