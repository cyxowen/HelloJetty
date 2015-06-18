package org.cloudstone.jettydemo.HelloJetty;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class FileSystemJetty {
	public static void main(String[] args) throws Exception {
		new FileSystem("D:/").start();
	}
	
	static class FileSystem {
		private Server server;
		public FileSystem(String path) {
			server = new Server(8080);
			ResourceHandler resourceHandler = new ResourceHandler();
			resourceHandler.setResourceBase(path);
			resourceHandler.setDirectoriesListed(true);
			HandlerList handlerList = new HandlerList();
			handlerList.setHandlers(new Handler[]{resourceHandler, new DefaultHandler()});
			server.setHandler(handlerList);
		}
		
		public void start() throws Exception{
			server.start();
			server.join();
		}
	}
}
