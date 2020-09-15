package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Distancedao;
import com.dao.Passengerdao;
import com.dao.Paymentdao;
import com.dao.Routedao;
import com.dao.Ticketdao;
import com.dao.Userdao;
import com.dto.Passenger;
import com.dto.Route;

@WebServlet("/Redbusservlet")
public class Redbusservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("bt");
		HttpSession se = request.getSession();
		PrintWriter pw = response.getWriter();
		if (button == null) {
			List<String> cList;
			List<Route> table;
			try {
				cList = Routedao.getAllRoutes();
				table = Routedao.getTableDetails();
				System.out.println(cList);
				System.out.println(table);
				se.setAttribute("cList", cList);
				se.setAttribute("table", table);
				request.getRequestDispatcher("Loginredbus.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("bt");
		PrintWriter pw = response.getWriter();
		HttpSession se = request.getSession();
		List<Passenger> firstlist = new ArrayList<Passenger>();
		if (button.equals("Register")) {

			String n = request.getParameter("f1");
			String e = request.getParameter("f2");
			String p = request.getParameter("f3");
			String a = request.getParameter("f4");
			String phoneno = request.getParameter("f5");

			try {
				boolean check = Userdao.checkEmailExistsorNot(e);
				if (check) {
					System.out.println("registered sucessufully");
				} else {
					boolean insert = Userdao.register(n, e, p, a, phoneno);
					if (insert) {
						pw.println("Registered sucessfully");
						request.getRequestDispatcher("Registerredbus.jsp").forward(request, response);

					} else {
						pw.println("Registration not sucessfull");
					}

				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (button.equals("Login")) {
			String e = request.getParameter("t1");
			String p = request.getParameter("t2");

			try {
				boolean login = Userdao.emailexistsornot(e, p);

				String welcomename = Userdao.getnameafterwelcome(e);

				int uid = Userdao.getIdUsingEmail(e);
				se.setAttribute("uid", uid);
				if (login) {
					pw.println("logged in");
					se.setAttribute("n", welcomename);
					request.getRequestDispatcher("Homeredbus.jsp").forward(request, response);
				} else {
					pw.println("incorret credentials");
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} /*
			 * else if (button == null) { List<String> cList; List<Route> table;
			 * try { cList = Routedao.getAllRoutes(); table =
			 * Routedao.getTableDetails(); System.out.println(cList);
			 * System.out.println(table); se.setAttribute("cList", cList);
			 * se.setAttribute("table", table);
			 * request.getRequestDispatcher("Homeredbus.jsp").forward(request,
			 * response);
			 * 
			 * } catch (ClassNotFoundException | SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } }
			 */

		else if (button.equals("Book Ticket")) {
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			se.setAttribute("from", from);
			se.setAttribute("to", to);
			String user_name = request.getParameter("t1");
			int user_id = (Integer) se.getAttribute("uid");
			boolean insertticket = false;

			try {
				if (from.equals(to)) {
					pw.println("destination and starting should not be same");
				} else {
					insertticket = Ticketdao.getticket(user_id, from, to);

					if (insertticket) {
						int ticket_id = Ticketdao.getticketId(user_id);
						System.out.println(ticket_id);
						se.setAttribute("ticket_id", ticket_id);
						request.getRequestDispatcher("Addpassenger.jsp").forward(request, response);
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// request.getRequestDispatcher("Addpassenger.jsp").forward(request,
			// response);
		} else if (button.equals("Add")) {
			String n1 = request.getParameter("t1");
			System.out.println(n1);
			String g = request.getParameter("t4");
			int a1 = Integer.parseInt(request.getParameter("t2"));
			String category = request.getParameter("t5");
			int uid1 = (Integer) se.getAttribute("uid");
			System.out.println(uid1);
			System.out.println(uid1);
			Date d = new Date();
			Timestamp ts = new Timestamp(d.getTime());
			System.out.println(ts);
			List<Passenger> plist = new ArrayList<Passenger>();

			try {
				int ticket_id = (int) se.getAttribute("ticket_id");
				boolean insert = Passengerdao.insertpassengerdetails(uid1, ticket_id, n1, g, a1, category, ts);
				if (insert) {

					plist = Passengerdao.ShowPassengerDetails(uid1, ticket_id);
					System.out.println(n1);
					int count = 0;

					System.out.println(plist);

					se.setAttribute("plist", plist);
					request.getRequestDispatcher("Addpassenger.jsp").include(request, response);

				}

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (button.equals("Proceedtopayment")) {
			String from = (String) se.getAttribute("from");
			String to = (String) se.getAttribute("to");
			int uid1 = (Integer) se.getAttribute("uid");
			int ticket_id = (int) se.getAttribute("ticket_id");
			int totalprice = 0;

			List<Passenger> plist = new ArrayList<Passenger>();
			try {
				plist = Passengerdao.ShowPassengerDetails(uid1, ticket_id);
				int kilometers = Distancedao.getkilometers(from, to);
				System.out.println(kilometers);
				int numofpassengers = Passengerdao.getcount(ticket_id);
				System.out.println(numofpassengers);
				totalprice = (kilometers * numofpassengers * 6);
				System.out.println(totalprice);
				se.setAttribute("totalprice", totalprice);
				se.setAttribute("numofpassengers", numofpassengers);
				se.setAttribute("plist", plist);
				request.getRequestDispatcher("Passengerdetails.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (button.equals("Makepayment")) {
			String from = (String) se.getAttribute("from");
			String to = (String) se.getAttribute("to");
			int uid1 = (Integer) se.getAttribute("uid");
			int ticket_id = (int) se.getAttribute("ticket_id");
			int totalprice = (int) se.getAttribute("totalprice");
			try {
				boolean finalinsert = Paymentdao.insertpaymentdetails(uid1, ticket_id, from, to, totalprice);
				if (finalinsert) {
					request.getRequestDispatcher("Final.jsp").forward(request, response);
				} else {
					pw.println("payment is not sucessfull");
				}

			}

			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (button.equals("Home")) {
			request.getRequestDispatcher("Homeredbus.jsp").forward(request, response);

		} else if (button.equals("Locate")) {
			String pos = request.getParameter("position");
			if (pos != null) {
				se.setAttribute("city", pos);
				request.getRequestDispatcher("Homeredbus.jsp").include(request, response);
			}

		}

	}

}
