package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author mayun8
 *
 * Realization of client-server chat, based on sockets
 *
 * This class realize the server side logic of the chat
 *
 */
public class ChatServer {

    public static final int DEFAULT_SOCKET = 8888;
    List<PrintWriter> clientOutputStreams;

    public static void main(String[] args) {
        new ChatServer().go();
    }

    public void go(){
        clientOutputStreams = new ArrayList<>();

        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(DEFAULT_SOCKET);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try{
            while (true){
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
                System.out.println("got a connection");
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void tellEveryone(String message){
        clientOutputStreams.stream().forEach(writer->{
              try {
                  writer.println(message);
                  writer.flush();
              }catch (Exception e){
                  e.printStackTrace();
              }
        });
    }

    public class ClientHandler implements Runnable{
        Scanner scanner;
        Socket clientSocket;
        InputStream is;

        public ClientHandler(Socket clientSocket) {
            try{
                this.clientSocket = clientSocket;
                is = clientSocket.getInputStream();
                scanner = new Scanner(is);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try{
                while(true){
                    message =scanner.nextLine();
                    System.out.println("read "+ message);
                    tellEveryone(message);
                }
            }catch (NoSuchElementException ex){
//                ex.printStackTrace(); умышленно ловим этот runtime exception и игнорим его stacktrace
            }
        }
    }
}
