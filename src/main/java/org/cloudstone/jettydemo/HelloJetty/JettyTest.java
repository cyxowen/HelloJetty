package org.cloudstone.jettydemo.HelloJetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class JettyTest extends AbstractHandler {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		server.setHandler(new JettyTest());
		server.start();
		server.join();
	}

	public void handle(String target, Request baseRequest,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException, ServletException {
		
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		response.getWriter().println("<h1>HelloWorld</h1>");
	}
}
