package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airline.service.PilotService;

/**
 * Servlet implementation class CreatePilotAndAddToFlight
 */
@WebServlet("/CreatePilotAndAddToFlight")
public class CreatePilotAndAddToFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	PilotService ps;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePilotAndAddToFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		Integer license = Integer.parseInt(request.getParameter("license"));
		String rank = request.getParameter("pilot_rank");
		String flightId = request.getParameter("fid");
		
		
		Pilot p = new Pilot();
		p.setFirstName(fName);
		p.setLastName(lName);
		p.setPilotLicense(license);
		p.setPilotRank(PilotRank.valueOf(rank));

		ps.addNewPilotToFlight(p, flightId);
		
		response.sendRedirect("Flights");
		
	}

}
