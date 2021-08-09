package com.rs.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutController {

	public static void logout(HttpServletRequest req, HttpServletResponse res) throws IOException{
		req.getSession();
		res.setStatus(200);
		res.getWriter().println("User Logged Out");
	}
	
}
