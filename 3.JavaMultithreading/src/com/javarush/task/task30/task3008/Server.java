package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage(serverSocket.toString());
            while (true) {
                new Handler(serverSocket.accept()).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message userName;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "NAME_REQUEST"));
                userName = connection.receive();
                if (userName.getType() == MessageType.USER_NAME &&
                 ! userName.getData().isEmpty() &&
                 ! connectionMap.containsKey(userName.getData())) {

                    connectionMap.put(userName.getData(), connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED, "NAME_ACCEPTED"));
                    break;
                }
            }
            return userName.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {

            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if ( ! userName.equals(entry.getKey())) {
                    Message message = new Message(MessageType.USER_ADDED, entry.getKey());
                    connection.send(message);
                }

            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(message.getType(), userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Incorrect type of message");
                }
            }
        }

        public void run() {

            ConsoleHelper.writeMessage(String.valueOf(socket.getRemoteSocketAddress()));

            Connection connection = null;
            String userName = null;
            try {
                connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            }
            try {
                if (userName != null) {
                    connectionMap.remove(userName);
                    Message message = new Message(MessageType.USER_REMOVED, userName);
                    sendBroadcastMessage(message);
                }
            } catch (Exception e) {
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            }

            ConsoleHelper.writeMessage("Connection  closed");

        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                try {
                    entry.getValue().send(new Message(MessageType.TEXT,
                            "Didn't send message to " + entry.getKey()+ ", cause: " + e.getMessage()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
