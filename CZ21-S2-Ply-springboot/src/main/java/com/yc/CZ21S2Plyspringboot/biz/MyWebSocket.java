package com.yc.CZ21S2Plyspringboot.biz;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/websocket/{id}")
@Component
public class MyWebSocket {

	private static Hashtable<String, Session> webSocketMap = new Hashtable<>();
	
	@javax.websocket.OnOpen
	public void OnOpen(@PathParam("id")String id, Session session) {
		session.getUserProperties().put("myid", id);
		webSocketMap.put(id, session);
	}
	
	@OnClose
	public void OnClose(Session session) {
		//
		String id = (String) session.getUserProperties().get("myid");
		
		webSocketMap.remove(id);
	}
	
	@OnMessage
	public void OnMessage(String message, Session session) throws IOException {
		String[] items = message.split(":");
		String youid = items[0];
		String msg = items[1];
		String myid = (String) session.getUserProperties().get("myid");
		//
		Session recvSession = webSocketMap.get(myid);
		recvSession.getBasicRemote().sendText(myid + ":" + msg);
	}
	
}
