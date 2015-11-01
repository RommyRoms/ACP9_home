package chat;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author mayun8
 *
 * Realization of client-server chat, based on sockets
 *
 * This class realize the client GUI with Runnable classes to read and write messages for server
 */
public class ChatClient {
    private String nickName;
    public static final String DEFAULT_IP ="localhost";
    //ip of the server
    public  String ip = DEFAULT_IP;
    public static final int DEFAULT_SOCKET = 8888;
    //socket of the program process
    public  int socket = DEFAULT_SOCKET;

    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    JTextField ipArea;
    JTextField nickNameField;
    JTextField socketArea;
    JButton submitSocketAndIPButton;

    public static void main(String[] args) {
        new ChatClient().go();
    }

    public void go() {
        //initialization of the users frame,that makes client GUI of the chat
        JFrame frame = new JFrame("Chat client");
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15, 32);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        //button, that push message to the server
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        //making the panel with the text area & sending message area
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        //border colour of the settings panels, that will be visible before user submit the settings
        Color withoutSettingsBorderColour = Color.red;

        //panel with settings components
        JPanel topPanel = new JPanel();
        ipArea = new JTextField(9);
        ipArea.setText(ip);
        ipArea.setBorder(new LineBorder(withoutSettingsBorderColour));
        socketArea = new JTextField(5);
        socketArea.setText("" + socket);
        socketArea.setBorder(new LineBorder(withoutSettingsBorderColour));
        nickNameField = new JTextField("your nickname");
        nickNameField.setBorder(new LineBorder(withoutSettingsBorderColour));
        submitSocketAndIPButton = new JButton("Save configs");
        submitSocketAndIPButton.addActionListener(new SubmitConfig());
        topPanel.add(ipArea);
        topPanel.add(socketArea);
        topPanel.add(nickNameField);
        topPanel.add(submitSocketAndIPButton);

        setUpNetworking();
        //starting threat,that will update new  messages from server
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.NORTH, topPanel);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 380);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    //loading properties for making stable connection to the server
    private void setUpNetworking(){
        try{
            sock = new Socket(ip, socket);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("network established");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //listener of the send to server button
    public class SendButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                writer.println(nickName+"~ " + outgoing.getText());
                writer.flush();
            }catch (Exception e1){
                e1.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    //listener o the submit configuration button
    public class SubmitConfig implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ip = ipArea.getText().trim();
            socket = Integer.parseInt(socketArea.getText().trim());
            nickName= nickNameField.getText();
            //border color, that is visible when all settings from user are correct
            Color submitColor = Color.green;

            ipArea.setEditable(false);
            ipArea.setBorder(new LineBorder(submitColor));

            socketArea.setEditable(false);
            socketArea.setBorder(new LineBorder(submitColor));

            nickNameField.setEditable(false);
            nickNameField.setBorder(new LineBorder(submitColor));
        }
    }

    //reader from server realization
    public class IncomingReader implements Runnable{
        @Override
        public void run() {
            String message;
            try{
                while((message=reader.readLine())!=null){
                    System.out.println("read " + message);
                    incoming.append(message + "\n");
/*                    incoming.update(incoming.getGraphics());*/
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
