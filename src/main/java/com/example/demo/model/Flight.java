package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String airline;
	private String fromAirport;
	private String toAirport;

	private Date scheduledDateTime;
	private Date estimatedDateTime;
	private Date actualDateTime;

	public Flight() {
	}

	public Flight(Long id, String airline, String fromAirport, String toAirport, Date scheduledDateTime,
			Date estimatedDateTime, Date actualDateTime) {
		this.id = id;
		this.airline = airline;
		this.fromAirport = fromAirport;
		this.toAirport = toAirport;
		this.scheduledDateTime = scheduledDateTime;
		this.estimatedDateTime = estimatedDateTime;
		this.actualDateTime = actualDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFromAirport() {
		return fromAirport;
	}

	public void setFromAirport(String fromAirport) {
		this.fromAirport = fromAirport;
	}

	public String getToAirport() {
		return toAirport;
	}

	public void setToAirport(String toAirport) {
		this.toAirport = toAirport;
	}

	public Date getScheduledDateTime() {
		return scheduledDateTime;
	}

	public void setScheduledDateTime(Date scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}

	public Date getEstimatedDateTime() {
		return estimatedDateTime;
	}

	public void setEstimatedDateTime(Date estimatedDateTime) {
		this.estimatedDateTime = estimatedDateTime;
	}

	public Date getActualDateTime() {
		return actualDateTime;
	}

	public void setActualDateTime(Date actualDateTime) {
		this.actualDateTime = actualDateTime;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", fromAirport=" + fromAirport + ", toAirport=" + toAirport
				+ ", scheduledDateTime=" + scheduledDateTime + ", estimatedDateTime=" + estimatedDateTime
				+ ", actualDateTime=" + actualDateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}