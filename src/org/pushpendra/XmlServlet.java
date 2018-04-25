package org.pushpendra;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XmlServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("userName");
		HttpSession session = request.getSession();
		if(name !=null && name!="") {
			session.setAttribute("savedName",name);
		}
		writer.print("Hello from GET : " + name + "!!");
		writer.print("Hello from Session : " + session.getAttribute("savedName") + "!!");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("userName");
		HttpSession session = request.getSession();
		if(name !=null && name!="") {
			session.setAttribute("savedName",name);
		}
		String prof = request.getParameter("prof");
		String location = request.getParameter("location");
		String locationArray[] = request.getParameterValues("location");
		writer.println("Hello from POST : " + name + "!!" + "you are " + prof);
		writer.println("Hello from Session : " + name + "!!" );
		writer.println("You are at " + locationArray.length + " Places");
		
		for(String s: locationArray) {
			writer.print(s + " ");
		}
		
		for(String s: locationArray) {
			writer.print(s + " ");
		}
	}
	
	// checking
}
