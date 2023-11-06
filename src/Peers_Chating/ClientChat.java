package Peers_Chating;

import java.awt.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class ClientChat extends javax.swing.JFrame {

    ArrayList< InetSocketAddress> onlinelist = new ArrayList< InetSocketAddress>();
    ArrayList<String> usernamelist = new ArrayList<String>();

    private String Remote_IP;
    private String Local_IP;
    private String Tcp_Server_IP;
    private String UserName;

    private InetAddress remote_ip;
    private InetAddress local_ip;
    private InetAddress tcp_server_ip;

    private int Local_Port;
    private int Remote_Port;
    private int Tcp_Server_Port;
    private File selectedFile;

    private Thread UDPThread;
    private Thread TCPThread;
    private DatagramSocket UDPSocket;
    private Socket TCPSocket;
    private DefaultListModel demoList;
    private DataOutputStream outToServer;
    private BufferedReader inFromServer;
    String path;
    boolean flag ;

    public ClientChat(String path_to_save_file_recived) {
        initComponents();
        this.setLocationRelativeTo(null);
        MessegeAreaText.setText("Enter Text Here...");
        MessegeAreaText.setForeground(Color.GRAY);
        Local_IP_Text.setText("127.0.0.1");
        TCP_Server_IP_Text.setText("127.0.0.1");
        TCP_Server_Port_Text.setText("8888");
        Local_IP_Text.setEditable(false);
        Remote_IP_Text.setEditable(false);
        Remote_Port_Text.setEditable(false);
        demoList = new DefaultListModel();
        OnlineListe.setModel(demoList);
        OnlineListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Logout.setEnabled(false);
        Login.setEnabled(true);
        Send.setEnabled(false);
        SendToGroub.setEnabled(false);
        SendFile.setEnabled(false);
        AvilableInterfaces.setEnabled(true);
        flag= false;
        path = path_to_save_file_recived;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MessegeAreaText = new javax.swing.JTextPane();
        Login = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        label1 = new java.awt.Label();
        UserNameText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ScreenText = new javax.swing.JTextPane();
        label2 = new java.awt.Label();
        StatusText = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        TCP_Server_IP_Text = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        TCP_Server_Port_Text = new javax.swing.JTextField();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        AvilableInterfaces = new javax.swing.JComboBox<>();
        Local_Port_Text = new javax.swing.JTextField();
        label7 = new java.awt.Label();
        Local_IP_Text = new javax.swing.JTextField();
        SendFile = new javax.swing.JButton();
        label8 = new java.awt.Label();
        Remote_IP_Text = new javax.swing.JTextField();
        label9 = new java.awt.Label();
        label10 = new java.awt.Label();
        Remote_Port_Text = new javax.swing.JTextField();
        Send = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        OnlineListe = new javax.swing.JList<>();
        SendToGroub = new javax.swing.JButton();
        File = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chatting Between Peers ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MessegeAreaText.setBorder(new javax.swing.border.MatteBorder(null));
        MessegeAreaText.setFont(new java.awt.Font("American Typewriter", 0, 24)); // NOI18N
        MessegeAreaText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MessegeAreaTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                MessegeAreaTextFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(MessegeAreaText);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 419, 138));

        Login.setFont(new java.awt.Font("Trattatello", 0, 14)); // NOI18N
        Login.setLabel("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel2.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 100, 30));

        Logout.setFont(new java.awt.Font("Trattatello", 0, 13)); // NOI18N
        Logout.setText("logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel2.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 100, 30));

        label1.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label1.setText("Status:");
        jPanel2.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 50, 43));
        label1.getAccessibleContext().setAccessibleName("");
        label1.getAccessibleContext().setAccessibleDescription("");

        UserNameText.setFont(new java.awt.Font("Kokonor", 0, 13)); // NOI18N
        jPanel2.add(UserNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 160, 30));

        ScreenText.setEditable(false);
        ScreenText.setBorder(new javax.swing.border.MatteBorder(null));
        ScreenText.setFont(new java.awt.Font("American Typewriter", 1, 16)); // NOI18N
        jScrollPane1.setViewportView(ScreenText);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 419, 190));

        label2.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label2.setText("Online User:");
        jPanel2.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 100, -1));

        StatusText.setEditable(false);
        StatusText.setFont(new java.awt.Font("American Typewriter", 3, 30)); // NOI18N
        StatusText.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel2.add(StatusText, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 730, 43));

        label3.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label3.setText("Username :");
        jPanel2.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 30));

        TCP_Server_IP_Text.setFont(new java.awt.Font("Marker Felt", 2, 13)); // NOI18N
        TCP_Server_IP_Text.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(TCP_Server_IP_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 180, 29));

        label4.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label4.setText("Available Interfaces:");
        jPanel2.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 150, -1));

        TCP_Server_Port_Text.setFont(new java.awt.Font("Marker Felt", 2, 13)); // NOI18N
        TCP_Server_Port_Text.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(TCP_Server_Port_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 180, 30));

        label5.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label5.setText("TCP server Port :");
        jPanel2.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 140, 30));

        label6.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label6.setText("Local IP:");
        jPanel2.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 80, 30));

        AvilableInterfaces.setFont(new java.awt.Font("Kokonor", 0, 13)); // NOI18N
        AvilableInterfaces.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loopback pseudo-Interface", "WI-FI", " ", " " }));
        AvilableInterfaces.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AvilableInterfaces.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AvilableInterfacesItemStateChanged(evt);
            }
        });
        jPanel2.add(AvilableInterfaces, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 320, -1));

        Local_Port_Text.setFont(new java.awt.Font("Marker Felt", 2, 13)); // NOI18N
        Local_Port_Text.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(Local_Port_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 190, 30));

        label7.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label7.setText("Local Port:");
        jPanel2.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 90, 30));

        Local_IP_Text.setFont(new java.awt.Font("Marker Felt", 2, 13)); // NOI18N
        Local_IP_Text.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(Local_IP_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 190, 30));

        SendFile.setFont(new java.awt.Font("Trattatello", 0, 13)); // NOI18N
        SendFile.setText("Send File");
        SendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendFileActionPerformed(evt);
            }
        });
        jPanel2.add(SendFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, 120, 30));

        label8.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label8.setText("TCP server IP :");
        jPanel2.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 120, -1));

        Remote_IP_Text.setFont(new java.awt.Font("Marker Felt", 2, 13)); // NOI18N
        Remote_IP_Text.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(Remote_IP_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 190, 30));

        label9.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label9.setText("Remote IP:");
        jPanel2.add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 100, 30));

        label10.setFont(new java.awt.Font("Academy Engraved LET", 3, 17)); // NOI18N
        label10.setText("Remote Port:");
        jPanel2.add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 110, 30));

        Remote_Port_Text.setFont(new java.awt.Font("Marker Felt", 2, 13)); // NOI18N
        Remote_Port_Text.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(Remote_Port_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 190, 30));

        Send.setFont(new java.awt.Font("Trattatello", 0, 13)); // NOI18N
        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });
        jPanel2.add(Send, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 310, 30));

        OnlineListe.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        OnlineListe.setFont(new java.awt.Font("American Typewriter", 3, 12)); // NOI18N
        OnlineListe.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                OnlineListeValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(OnlineListe);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 180, 420));

        SendToGroub.setFont(new java.awt.Font("Trattatello", 0, 13)); // NOI18N
        SendToGroub.setText("Send To Groub");
        SendToGroub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendToGroubActionPerformed(evt);
            }
        });
        jPanel2.add(SendToGroub, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 310, 30));

        File.setEditable(false);
        File.setFont(new java.awt.Font("American Typewriter", 3, 18)); // NOI18N
        File.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel2.add(File, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 290, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Insert File.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 60, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
    logout();
    }//GEN-LAST:event_LogoutActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        ConeectWithServer();

    }//GEN-LAST:event_LoginActionPerformed

    private void SendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendFileActionPerformed
        SendFile();
    }//GEN-LAST:event_SendFileActionPerformed

    private void MessegeAreaTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MessegeAreaTextFocusGained
        if (MessegeAreaText.getText().equals("Enter Text Here...")) {
            MessegeAreaText.setForeground(Color.BLACK);
            MessegeAreaText.setText("");
        }
    }//GEN-LAST:event_MessegeAreaTextFocusGained

    private void MessegeAreaTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MessegeAreaTextFocusLost
        if (MessegeAreaText.getText().isEmpty()) {
            MessegeAreaText.setText("Enter Text Here...");
            MessegeAreaText.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_MessegeAreaTextFocusLost

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
        Send();
    }//GEN-LAST:event_SendActionPerformed

    private void AvilableInterfacesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AvilableInterfacesItemStateChanged
        if (AvilableInterfaces.getSelectedIndex() == 0) {
            Local_IP_Text.setText("127.0.0.1");
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
                            Local_IP_Text.setText(inetAddress.getHostAddress());
                        }
                    }
                }

            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_AvilableInterfacesItemStateChanged

    private void OnlineListeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_OnlineListeValueChanged

        try {
            int i = OnlineListe.getSelectedIndex();
            String Str = onlinelist.get(i).getAddress().toString();
            Str = Str.replace("/", "");
            Integer port = onlinelist.get(i).getPort();
            Remote_IP_Text.setText(Str);
            Remote_Port_Text.setText(port.toString());
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_OnlineListeValueChanged

    private void SendToGroubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendToGroubActionPerformed
        byte[] sendData;
        try {

            String sentence = "";
            OnlineListe.clearSelection();
            Remote_IP_Text.setText("For All");
            Remote_Port_Text.setText("For All");
            for (int i = 0; i < onlinelist.size(); i++) {
                sentence = MessegeAreaText.getText();
                if (MessegeAreaText.getText().equals("Enter Text Here...")) {
                    throw new Exception();
                }
                sendData = sentence.getBytes();
                DatagramPacket sendPacket
                        = new DatagramPacket(sendData, sendData.length, onlinelist.get(i));
                UDPSocket.send(sendPacket);
            }

            addTextToArea("Me for All: " + sentence + "  " + "\n", false);
            MessegeAreaText.setText("Enter Text Here...");
            MessegeAreaText.setForeground(Color.GRAY);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Enter All Field",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_SendToGroubActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
       if(flag)
        try {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();

                File.setText(selectedFile.getName());
            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_jLabel1MousePressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        logout();
    }//GEN-LAST:event_formWindowClosed

    private void SendFile() {

        try {

            Remote_IP = Remote_IP_Text.getText().trim();
            remote_ip = InetAddress.getByName(Remote_IP);
            Remote_Port = Integer.parseInt(Remote_Port_Text.getText());

            FileReader fileReader = new FileReader(selectedFile);
            BufferedReader br = new BufferedReader(fileReader);
            StringBuilder sb1 = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb1.append(line);
                sb1.append("\n");
            }

            byte[] sentfile = (sb1.toString() + "@" + selectedFile.getName()).getBytes();
            DatagramPacket sendPacket
                    = new DatagramPacket(sentfile, sentfile.length, remote_ip, Remote_Port);
            UDPSocket.send(sendPacket);
            addTextToArea("Me: " + selectedFile.getName() + "\n", false);
            File.setText("");
            fileReader.close();
            selectedFile = null;
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Can't send your file",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Send() {
        byte[] sendData;
        try {

            Remote_IP = Remote_IP_Text.getText().trim();
            remote_ip = InetAddress.getByName(Remote_IP);
            Remote_Port = Integer.parseInt(Remote_Port_Text.getText());
            String sentence = MessegeAreaText.getText();
            if (MessegeAreaText.getText().equals("Enter Text Here...")) {
                throw new Exception();
            }
            sendData = sentence.getBytes();
            DatagramPacket sendPacket
                    = new DatagramPacket(sendData, sendData.length, remote_ip, Remote_Port);
            UDPSocket.send(sendPacket);
            addTextToArea("Me: " + sentence + "\n", false);
            MessegeAreaText.setText("Enter Text Here...");
            MessegeAreaText.setForeground(Color.GRAY);


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Enter All Field",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ConeectWithServer() {

        try {
            if (UserNameText.getText().isEmpty()) {
                throw new Exception();
            }
            UserName = UserNameText.getText();
            Local_Port = Integer.parseInt(Local_Port_Text.getText());
            Local_IP = Local_IP_Text.getText();
            local_ip = InetAddress.getByName(Local_IP);
            UDPSocket = new DatagramSocket(Local_Port, local_ip);
            UDP m = new UDP();
            UDPThread = new Thread(m);
            UDPThread.start();

            Tcp_Server_IP = TCP_Server_IP_Text.getText();
            tcp_server_ip = InetAddress.getByName(Tcp_Server_IP);
            Tcp_Server_Port = Integer.parseInt(TCP_Server_Port_Text.getText());
            TCPSocket = new Socket(tcp_server_ip, Tcp_Server_Port, local_ip, Local_Port);
            DataOutputStream outToServer
                    = new DataOutputStream(TCPSocket.getOutputStream());
            outToServer.writeBytes(UserName + "\n");
            TCP s = new TCP();
            TCPThread = new Thread(s);
            TCPThread.start();
            Local_Port_Text.setEditable(false);
            TCP_Server_IP_Text.setEditable(false);
            TCP_Server_Port_Text.setEditable(false);
            AvilableInterfaces.setEnabled(false);
            Logout.setEnabled(true);
            Login.setEnabled(false);
            flag = true;
            Send.setEnabled(true);
            SendToGroub.setEnabled(true);
            SendFile.setEnabled(true);
        } catch (Exception ex) {
            try{
            demoList.clear();  
            UDPSocket.close();
            UDPThread.interrupt();
            TCPSocket.close();
            TCPThread.interrupt();
            System.out.print("test");
            }catch (Exception e) {}
            
              JOptionPane.showMessageDialog(this,
                    "Enter All Field",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Receive() {
        try {
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket
                        = new DatagramPacket(receiveData, receiveData.length);
                String sentence = "";
                UDPSocket.receive(receivePacket);
                sentence = new String(receivePacket.getData());

                if (sentence.contains(".txt")) {
                    DatagramPacket receivefile
                            = new DatagramPacket(receiveData, receiveData.length);
                    String str[] = sentence.split("@");
                    addTextToArea("Receive file:" + str[1] + "  From: " + receivePacket.getPort() + "\n", true);
                    String s = str[1].trim();
                    PrintWriter pw = new PrintWriter(path+ s);
                    pw.println(str[0]);
                    pw.close();
                } else {
                    addTextToArea("Rme :" + sentence + "  From: " + receivePacket.getPort() + "\n", true);
                }
                StatusText.setText("    From: " + receivePacket.getAddress() + "  ,   " + receivePacket.getPort());
            }
        } catch (Exception e) {
        }
    }
        private void logout() {
            try {

            outToServer = new DataOutputStream(TCPSocket.getOutputStream());
            outToServer.writeBytes(UserName + ",LOGOUT" + "\n");
            TCPSocket.close();
            UDPSocket.close();
            TCPThread.interrupt();
            UDPThread.interrupt();
            demoList.clear();
            Logout.setEnabled(false);
            Login.setEnabled(true);
            Send.setEnabled(false);
            SendToGroub.setEnabled(false);
            SendFile.setEnabled(false);
            AvilableInterfaces.setEnabled(true);
            flag = false;
        } catch (Exception ex) {
        }
        }
    private void receiveFromServer() {
        try {
            while (true) {
                inFromServer
                        = new BufferedReader(new InputStreamReader(TCPSocket.getInputStream()));
                String modifiedSentence = inFromServer.readLine();
                int CountOfOnlineUser;

                String name = "";
                String soketip;
                int port;
                String[] arrOfStr = modifiedSentence.split("@");
                usernamelist.clear();
                demoList.clear();
                onlinelist.clear();
                for (int i = 0; i < arrOfStr.length;) {
                    name = arrOfStr[i];
                    if (name.equals(UserName)) {
                        i += 2;
                        continue;
                    }
                    soketip = arrOfStr[i + 1];
                    soketip = soketip.replace("/", "");
                    String[] arr = soketip.split(":");
                    soketip = arr[0];
                    port = Integer.parseInt(arr[1]);
                    InetSocketAddress ip = new InetSocketAddress(soketip, port);
                    usernamelist.add(name);
                    onlinelist.add(ip);
                    i += 2;
                }
                for (int i = 0; i < usernamelist.size(); i++) {
                    demoList.addElement(usernamelist.get(i) + " " + onlinelist.get(i));
                }

            }
        } catch (Exception e) {
        }
    }

    public class UDP implements Runnable {

        @Override
        public void run() {
            Receive();
        }
    }

    public class TCP implements Runnable {

        @Override
        public void run() {
            receiveFromServer();

        }
    }

    public void addTextToArea(String str, boolean color) throws BadLocationException {
        if (color) {
            //in log in
            StyledDocument doc = ScreenText.getStyledDocument();
            Style style = ScreenText.addStyle("", null);
            StyleConstants.setForeground(style, Color.BLUE);
            StyleConstants.setBackground(style, Color.white);
            doc.insertString(doc.getLength(), str, style);
        } else {
            //in log out
            StyledDocument doc = ScreenText.getStyledDocument();
            Style style = ScreenText.addStyle("", null);
            StyleConstants.setForeground(style, Color.RED);
            StyleConstants.setBackground(style, Color.white);
            doc.insertString(doc.getLength(), str, style);

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AvilableInterfaces;
    private javax.swing.JTextField File;
    private javax.swing.JTextField Local_IP_Text;
    private javax.swing.JTextField Local_Port_Text;
    private javax.swing.JButton Login;
    private javax.swing.JButton Logout;
    private javax.swing.JTextPane MessegeAreaText;
    private javax.swing.JList<String> OnlineListe;
    private javax.swing.JTextField Remote_IP_Text;
    private javax.swing.JTextField Remote_Port_Text;
    private javax.swing.JTextPane ScreenText;
    private javax.swing.JButton Send;
    private javax.swing.JButton SendFile;
    private javax.swing.JButton SendToGroub;
    private javax.swing.JTextField StatusText;
    private javax.swing.JTextField TCP_Server_IP_Text;
    private javax.swing.JTextField TCP_Server_Port_Text;
    private javax.swing.JTextField UserNameText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    // End of variables declaration//GEN-END:variables

}
