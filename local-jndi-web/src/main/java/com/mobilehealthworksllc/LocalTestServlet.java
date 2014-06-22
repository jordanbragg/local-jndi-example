package com.mobilehealthworksllc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilehealthworksllc.ejb.TestBeanLocal;

/**
 * Servlet used to invoke a local JNDI bean in all the different ways.
 * It runs in the jboss-web-policy security-domain as TestUser
 * @author Jordan Bragg
 *
 */
@RunAs("TestUser")
public class LocalTestServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6040245764390354638L;
	
	@EJB
	TestBeanLocal localBean;
	
	@EJB(mappedName=TestBeanLocal.JNDI_NAME)
	TestBeanLocal localMappedBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<html><head>");
		writer.println("<style>.failure{background-color:red}.success{background-color:green}</style>");
		writer.println("</head><body><table><tr>");
		
		//Tests using @EJB injection to get the bean within the package
		if(localBean.invoke()){
			writer.println("<td>@EJB Injection:</td><td class=\"success\"> Success</td>");
		}else{
			writer.println("<td>@EJB Injection:</td><td class=\"failure\"> Failure</td>");
		}
		writer.println("</tr><tr>");
		
		//Tests using @EJB injection with mappedName metadata to get any bean in the JVM
		if(localMappedBean.invoke()){
			writer.println("<td>@EJB(mappedName) Injection:</td><td class=\"success\"> Success</td>");
		}else{
			writer.println("<td>@EJB(mappedName) Injection:</td><td class=\"failure\"> Failure</td>");
		}
		writer.println("</tr><tr>");
				
		//Testing looking up the bean via global jndi name (this method allows to get any bean within the JVM)
		try {
			Context ctx = new InitialContext();
			TestBeanLocal localLookupService = (TestBeanLocal) ctx.lookup(TestBeanLocal.JNDI_NAME);
			if(localLookupService.invoke()){
				writer.println("<td>EJB Lookup:</td><td class=\"success\"> Success</td>");
			}else{
				writer.println("<td>EJB Lookup:</td><td class=\"failure\"> Failure</td>");
			}
		} catch (NamingException e) {
			e.printStackTrace();
			writer.println("<td>EJB Lookup:</td><td class=\"failure\"> Failure</td>");
		}
		
		writer.println("</tr></table>");
		writer.println("</body></html>");
	}
}
