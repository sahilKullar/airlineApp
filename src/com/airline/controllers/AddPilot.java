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
 * Servlet implementation class AddPilot
 */
@WebServlet("/AddPilot")
public class AddPilot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	PilotService ps;
	
    public AddPilot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Pilot p = new Pilot();
		
		p.setFirstName("Soni");
		p.setLastName("Kullar");
		p.setPilotRank(PilotRank.Captain);
		p.setPilotLicense(12345678);
		
		System.out.println(p);
		ps.addPilot(p);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
