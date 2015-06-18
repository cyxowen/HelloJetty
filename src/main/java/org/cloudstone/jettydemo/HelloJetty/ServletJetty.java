package org.cloudstone.jettydemo.HelloJetty;

import org.cloudstone.jettydemo.servlets.HelloServletJetty;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ServletJetty {
	public static void main(String[] args) throws Exception {
		new ServletJettyRunnable().run();
	}
	
	static class ServletJettyRunnable {
		private Server server;

		public ServletJettyRunnable() {
			server = new Server(8080);
			ServerConnector connector = new ServerConnector(server);
			ServletContextHandler context = new ServletContextHandler();
			context.setContextPath("/");
			context.addServlet(HelloServletJetty.class, "/hello");
			HandlerCollection handlers = new HandlerCollection();
			handlers.setHandlers(new Handler[]{context, new DefaultHandler()});
			server.setHandler(handlers);
		}
		
		public void run() throws Exception {
			server.start();
			server.join();
		}
	}
}
