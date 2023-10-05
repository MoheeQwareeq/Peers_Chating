package Peers_Chating;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.net.NetworkInterface;
import java.util.Enumeration;
import javax.swing.DefaultListModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Server extends javax.swing.JFrame {

    ArrayList<Socket> onlinelist = new ArrayList<Socket>();
    ArrayList<String> usernamelist = new ArrayList<String>();

    private int Server_Port;
    private String Server_IP;
    private InetAddress server_ip;
    private Thread t;

    private ServerSocket ListeningSocket;
    private DefaultListModel demoList;

    public Server() {
        initComponents();
        demoList = new DefaultListModel();
        OnlineList.setModel(demoList);
        this.setTitle("Server");

        try {
            ServerPort_Text.setText("8888");
            Server_IP = "127.0.0.1";
            server_ip = InetAddress.getByName(Server_IP);
        } catch (Exception ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ScreenText = new javax.swing.JTextPane();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        jScrollPane4 = new javax.swing.JScrollPane();
        OnlineList = new javax.swing.JList<>();
        AvilableInterfaces = new javax.swing.JComboBox<>();
        label4 = new java.awt.Label();
        label1 = new java.awt.Label();
        StatusText = new javax.swing.JTextField();
        StartListening = new javax.swing.JButton();
        ServerPort_Text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ScreenText.setEditable(false);
        ScreenText.setBorder(new javax.swing.border.MatteBorder(null));
        ScreenText.setFont(new java.awt.Font("American Typewriter", 1, 16)); // NOI18N
        jScrollPane1.setViewportView(ScreenText);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 410, 190));

        label2.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label2.setText("Online User:");
        jPanel2.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 100, -1));

        label3.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label3.setText("Port:");
        jPanel2.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 40, 30));

        OnlineList.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        OnlineList.setFont(new java.awt.Font("American Typewriter", 3, 14)); // NOI18N
        jScrollPane4.setViewportView(OnlineList);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 220, 340));

        AvilableInterfaces.setFont(new java.awt.Font("Kokonor", 0, 13)); // NOI18N
        AvilableInterfaces.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loopback pseudo-Interface", "WI-FI", " ", " " }));
        AvilableInterfaces.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AvilableInterfaces.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AvilableInterfacesItemStateChanged(evt);
            }
        });
        jPanel2.add(AvilableInterfaces, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 320, -1));

        label4.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label4.setText("Available Interfaces:");
        jPanel2.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 150, -1));

        label1.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label1.setText("Status:");
        jPanel2.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 60, 43));

        StatusText.setEditable(false);
        StatusText.setFont(new java.awt.Font("American Typewriter", 3, 18)); // NOI18N
        StatusText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel2.add(StatusText, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 410, 40));

        StartListening.setFont(new java.awt.Font("Trattatello", 0, 14)); // NOI18N
        StartListening.setLabel("Start Listening");
        StartListening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartListeningActionPerformed(evt);
            }
        });
        jPanel2.add(StartListening, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 180, 30));

        ServerPort_Text.setFont(new java.awt.Font("Marker Felt", 2, 13)); // NOI18N
        ServerPort_Text.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(ServerPort_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 150, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void AvilableInterfacesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AvilableInterfacesItemStateChanged
        if (AvilableInterfaces.getSelectedIndex() == 0) {

            try {
                Server_IP = "127.0.0.1";
                server_ip = InetAddress.getByName(Server_IP);
            } catch (Exception ex) {
            }
        }

        if (AvilableInterfaces.getSelectedIndex() == 1) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = networkInterfaces.nextElement();
                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();

                        // Check for IPv4 addresses
                        if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
                            Server_IP = inetAddress.getHostAddress();
                        }
                    }
                }

                server_ip = InetAddress.getByName(Server_IP);
            } catch (Exception ex) {
            }
        }

    }//GEN-LAST:event_AvilableInterfacesItemStateChanged

    private void StartListeningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartListeningActionPerformed
        try {
            ServerPort_Text.setEditable(false);
            AvilableInterfaces.setEnabled(false);
            Server_Port = Integer.parseInt(ServerPort_Text.getText());
            ListeningSocket = new ServerSocket(Server_Port, 100, server_ip);
            StatusText.setText("Server IP: " + Server_IP + "    Server Port: " + Server_Port);
            Server.run m = new Server.run();
            t = new Thread(m);
            t.start();
            StartListening.setEnabled(false);

        } catch (Exception ex) {
        }
    }//GEN-LAST:event_StartListeningActionPerformed

    private void Login() {
        try {

            while (true) {
                Socket connectionSocket = ListeningSocket.accept();

                addTextToArea(connectionSocket.getRemoteSocketAddress() + "    LOGIN\n", false);
                onlinelist.add(connectionSocket);
                BufferedReader inFromClient
                        = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                String clientSentence = inFromClient.readLine();
                demoList.clear();
                Thread t1 = new Thread(new Server.run1(connectionSocket));
                t1.start();

                usernamelist.add(clientSentence);
                for (int i = 0; i < onlinelist.size(); i++) {
                    demoList.addElement(onlinelist.get(i).getRemoteSocketAddress() + "  " + usernamelist.get(i));
                }
                String str = "";
                for (int i = 0; i < onlinelist.size(); i++) {
                    str += usernamelist.get(i) + "@" + onlinelist.get(i).getRemoteSocketAddress().toString() + "@";
                }

                for (int i = 0; i < onlinelist.size(); i++) {
                    DataOutputStream outToClient
                            = new DataOutputStream(onlinelist.get(i).getOutputStream());
                    outToClient.writeBytes(str + "\n");
                }

            }
        } catch (Exception ex) {
        }
    }

    public class run implements Runnable {

        @Override
        public void run() {

            Login();
        }
    }

    public class run1 implements Runnable {

        private Socket socket;

        public run1(Socket s) {
            socket = s;
        }

        @Override
        public void run() {

            try {

                BufferedReader inFromClient
                        = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientSentence = inFromClient.readLine();
                if (clientSentence.contains("LOGOUT")) {
                    String[] str = clientSentence.split(",");
                    for (int i = 0; i < onlinelist.size(); i++) {
                        if (usernamelist.get(i).equals(str[0])) {
                            addTextToArea(onlinelist.get(i).getRemoteSocketAddress() + "    LOGOUT\n", true);
                            demoList.clear();
                            onlinelist.remove(i);
                            usernamelist.remove(i);
                        }
                    }

                    for (int i = 0; i < onlinelist.size(); i++) {
                        demoList.addElement(onlinelist.get(i).getRemoteSocketAddress() + "  " + usernamelist.get(i));
                    }

                }
                String str = "";
                for (int i = 0; i < onlinelist.size(); i++) {
                    str += usernamelist.get(i) + "@" + onlinelist.get(i).getRemoteSocketAddress().toString() + "@";
                }

                for (int i = 0; i < onlinelist.size(); i++) {
                    DataOutputStream outToClient
                            = new DataOutputStream(onlinelist.get(i).getOutputStream());
                    outToClient.writeBytes(str + "\n");
                }

            } catch (Exception ex) {
            }

        }
    }

    public void addTextToArea(String str, boolean color) throws BadLocationException {
        if (color) {
            StyledDocument doc = ScreenText.getStyledDocument();
            Style style = ScreenText.addStyle("", null);
            StyleConstants.setForeground(style, Color.BLUE);
            StyleConstants.setBackground(style, Color.white);
            doc.insertString(doc.getLength(), str, style);
        } else {
            StyledDocument doc = ScreenText.getStyledDocument();
            Style style = ScreenText.addStyle("", null);
            StyleConstants.setForeground(style, Color.RED);
            StyleConstants.setBackground(style, Color.white);
            doc.insertString(doc.getLength(), str, style);

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AvilableInterfaces;
    private javax.swing.JList<String> OnlineList;
    private javax.swing.JTextPane ScreenText;
    private javax.swing.JTextField ServerPort_Text;
    private javax.swing.JButton StartListening;
    private javax.swing.JTextField StatusText;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    // End of variables declaration//GEN-END:variables
}
