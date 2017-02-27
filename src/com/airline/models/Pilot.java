package com.airline.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pilot
 *
 */
@NamedQuery(name = "Pilot.findById", query="SELECT p FROM Pilot p WHERE p.id = :id")
@Entity
public class Pilot implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pilot() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String firstName;

	private String lastName;

	private Integer pilotLicense;

	@Enumerated(EnumType.STRING)
	private PilotRank pilotRank;

	@ManyToOne
	@JoinColumn(name = "flight_fk")
	private Flight flightForpilot;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPilotLicense() {
		return pilotLicense;
	}

	public void setPilotLicense(Integer pilotLicense) {
		this.pilotLicense = pilotLicense;
	}

	public PilotRank getPilotRank() {
		return pilotRank;
	}

	public void setPilotRank(PilotRank pilotRank) {
		this.pilotRank = pilotRank;
	}

	public Flight getFlightForpilot() {
		return flightForpilot;
	}

	public void setFlightForpilot(Flight flightForpilot) {
		this.flightForpilot = flightForpilot;
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", pilotLicense=" + pilotLicense + ", pilotRank="
				+ pilotRank + ", flightForpilot=" + flightForpilot + "]";
	}

}
