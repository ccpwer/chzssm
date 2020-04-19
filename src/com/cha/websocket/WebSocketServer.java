package com.cha.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/*
*�����cuttingMergeId�������Ϊ����Id,
*/
@ServerEndpoint("/webSocket/chat/{cuttingMergeId}/{permId}")
public class WebSocketServer {
    // ʹ��map���ռ�session��keyΪcuttingMergeId��valueΪͬһ��������û�����
    // concurrentMap��key������ʱ�������Ƿ���null
    private static final Map<String, Set<Session>> rooms = new ConcurrentHashMap<String, Set<Session>>();
//    private static final Map<String, String> permIdList = new     ConcurrentHashMap<String, String>();
    @OnOpen
    public void connect(@PathParam("cuttingMergeId") String cuttingMergeId,
                        @PathParam("permId") String permId, Session session) throws Exception {
        // ��session���շ��������洢��������������û�����
        if (!rooms.containsKey(cuttingMergeId)) {
            System.out.println("xxxxx");
            // �������䲻����ʱ����������
            Set<Session> room = new HashSet<Session>();
            // ����û�
            room.add(session);

            rooms.put(cuttingMergeId, room);
        } else {
            // �����Ѵ��ڣ�ֱ������û�����Ӧ�ķ���
            rooms.get(cuttingMergeId).add(session);
        }
        System.err.println("permId"+permId);
        System.out.println("a client has connected!");
    }

    @OnClose
    public void disConnect(@PathParam("cuttingMergeId") String cuttingMergeId,@PathParam("permId") String permId, Session session) {
        rooms.get(cuttingMergeId).remove(session);
        System.out.println("a client has disconnected"+permId);
    }

    @OnMessage
    public void receiveMsg(@PathParam("cuttingMergeId") String cuttingMergeId,@PathParam("permId") String permId,
                           String msg, Session session) throws Exception {
        
//        msg = permId + ":" + msg;
        System.out.println(permId + ":" + msg);
        // ���յ���Ϣ����й㲥
        broadcast(cuttingMergeId, msg);
    }

    // ���շ��������й㲥
    public static void broadcast(String cuttingMergeId, String msg) throws Exception {
        for (Session session : rooms.get(cuttingMergeId)) {
//        	System.out.println(session.getId());
            session.getBasicRemote().sendText(msg);
        }
    }

}
