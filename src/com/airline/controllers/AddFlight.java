package com.airline.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.FlightDestinations;
import com.airline.service.FlightService;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	FlightService fs;

	public AddFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Flight f = new Flight();
		
		String from_destination = request.getParameter("from_destination");
		f.setFlightOrigin(FlightDestinations.valueOf(from_destination));
		
		String to_destination = request.getParameter("to_destination");
		f.setFlightDestination(FlightDestinations.valueOf(to_destination));
		
		String price = request.getParameter("price");
		f.setPrice(Integer.parseInt(price));
		
		Integer year = Integer.parseInt(request.getParameter("year"));
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer day = Integer.parseInt(request.getParameter("day"));
		Integer hour = Integer.parseInt(request.getParameter("hour"));
		Integer minute = Integer.parseInt(request.getParameter("minute"));

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);

		Date flightTime = cal.getTime();

		System.out.println(flightTime);
		f.setFlightTime(flightTime);

		Airplane a = new Airplane();
		
		String planMake = request.getParameter("airplane_make");
		String planeModelName = request.getParameter("airplane_model");
		Integer Seating = Integer.parseInt(request.getParameter("airplane_seating"));
		
		a.setModelName(planeModelName);
		a.setPlaneMake(planMake);
		a.setSeatingCapacity(Seating);

		f.setAirplaneDetail(a);

		System.out.println(f);
		System.out.println(a);

		fs.addFlight(f, a);
		response.sendRedirect("Flights");

	}

}
