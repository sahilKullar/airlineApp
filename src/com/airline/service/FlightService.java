package com.airline.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.Passenger;
import com.airline.models.Pilot;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean
public class FlightService {

	/**
	 * Default constructor.
	 */
	public FlightService() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "airline")
	EntityManager em;

	public void addFlight(Flight f, Airplane a) {

		em.persist(f);
		// em.persist(a); --propogated and cascaded from flight saved
		// automatically.

	}

	public void addPilotToFlight(String pilotId, String flightId) {

		TypedQuery<Flight> fQuery = em.createNamedQuery("Flight.findById",
				Flight.class);
		fQuery.setParameter("id", Integer.parseInt(flightId));
		Flight f = fQuery.getSingleResult();

		TypedQuery<Pilot> pQuery = em.createNamedQuery("Pilot.findById",
				Pilot.class);
		pQuery.setParameter("id", Integer.parseInt(pilotId));
		Pilot p = pQuery.getSingleResult();

		List<Pilot> pList = f.getPilots();
		pList.add(p);
		f.setPilots(pList);
		p.setFlightForpilot(f);

	}

	public void addPassengerToFlight(String passengerId, String flightId) {

		// Getting the passenger by ID

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Passenger> cqPassenger = builder.createQuery(Passenger.class);
		Root<Passenger> pRoot = cqPassenger.from(Passenger.class);
		cqPassenger.select(pRoot).where(builder.equal(pRoot.get("id").as(Integer.class), passengerId));
		TypedQuery<Passenger> pQuery = em.createQuery(cqPassenger);
		Passenger p = pQuery.getSingleResult();

		// Getting the flight by ID

		builder = em.getCriteriaBuilder();
		CriteriaQuery<Flight> cqFlight = builder.createQuery(Flight.class);
		Root<Flight> fRoot = cqFlight.from(Flight.class);
		cqFlight.select(fRoot).where(builder.equal(fRoot.get("id").as(Integer.class), flightId));
		TypedQuery<Flight> fQuery = em.createQuery(cqFlight);
		Flight f = fQuery.getSingleResult();

		//Associate the passenger with the flight
		
		List<Passenger> pList = f.getPassengers();
		pList.add(p);
		f.setPassengers(pList);
		p.getFlights().add(f);
				
	}

	public List<Flight> getFlights() {

		TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f",
				Flight.class);
		List<Flight> results = query.getResultList();
		return results;

	}
	
	public Flight getFlight(Integer flightId){
		
		TypedQuery<Flight> fQuery = em.createNamedQuery("Flight.findById",
				Flight.class);
		
		fQuery.setParameter("id", flightId);
		
		Flight f = null;
		try {
			f = fQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return f;		
		
	}
}
