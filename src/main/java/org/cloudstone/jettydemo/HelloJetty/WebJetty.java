package org.cloudstone.jettydemo.HelloJetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebJetty {

	public static void main(String[] args) throws Exception {
		new Web("/CS", "G:/CS.war").run();
	}

	static class Web {
		private Server server;

		public Web(String contextPath, String warPath) {
			server = new Server(8080);
			WebAppContext context = new WebAppContext();
			context.setContextPath(contextPath);
			context.setWar(warPath);
			server.setHandler(context);
		}
		public void run() throws Exception{
			server.start();
			server.join();
		}
	}
}
