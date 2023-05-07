package com.example.mobileapp;

import com.example.app.TableStructure.BigBags;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.HashTable;
import com.example.app.TableStructure.Kooperation;
import com.github.sarxos.webcam.*;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.*;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.Reader;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.RGBLuminanceSource; // import RGBLuminanceSource

import javax.swing.*;
import java.awt.image.BufferedImage;

import java.awt.Dimension;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


public class Menu extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private BigBags currntBigBag = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private final Executor executor = Executors.newSingleThreadExecutor(this);

    public Menu() {
        initComponents();
        jPanel1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        result_freld = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Ilive = new javax.swing.JButton();
        Ilive1 = new javax.swing.JButton();
        Ilive2 = new javax.swing.JButton();
        Ilive3 = new javax.swing.JButton();
        Ilive4 = new javax.swing.JButton();
        Ilive5 = new javax.swing.JButton();
        Ilive6 = new javax.swing.JButton();
        Ilive7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Ilive8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jusername = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        username = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 500, 360));

        result_freld.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        result_freld.setText("");
        result_freld.setBorder(null);
        jPanel1.add(result_freld, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 500, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 670, 20));

        jLabel1.setText("Location");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, -1));

        jTextField3.setText("Rresult:");
        jTextField3.setBorder(null);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jButton3.setText("Collection");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePro(evt, 1);
            }
        });
        jButton3.setFocusable(false);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 180, -1));

        jButton4.setText("Stacking");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePro(evt,2);
            }
        });

        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 180, -1));



        Ilive1.setText("Sorting");
        Ilive1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePro(evt,3);
            }
        });
        jPanel1.add(Ilive1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 180, -1));

        Ilive2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Ilive2.setText("Label");
        Ilive2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePro(evt,4);
            }
        });
        jPanel1.add(Ilive2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 180, -1));

        Ilive3.setText("Storage CORPS");
        Ilive3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePro(evt,5);
            }
        });
        jPanel1.add(Ilive3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 180, -1));

        Ilive4.setText("Centercorp Delivery");
        Ilive4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePro(evt, 6);
            }
        });
        jPanel1.add(Ilive4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 180, -1));

        Ilive5.setText("Compress and weighing");
        Ilive5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePro(evt,7);
            }
        });
        jPanel1.add(Ilive5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 180, -1));

        Ilive6.setText("Label compressed weight");
        Ilive6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePro(evt, 8);
            }
        });
        jPanel1.add(Ilive6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 180, -1));

        Ilive7.setText("Storage centerCORP");
        Ilive7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePro(evt, 9);
            }
        });
        jPanel1.add(Ilive7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 180, -1));
        Ilive.setText("Selling");
        Ilive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePro(evt,10);
            }
        });
        jPanel1.add(Ilive, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 180, -1));
        jButton5.setText("Location A");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLoc(evt,1);
            }
        });

        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 180, -1));

        jButton6.setText("Location B");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLoc(evt,2);
            }
        });

        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 180, -1));

        Ilive8.setText("Location C");
        Ilive8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLoc(evt,3);
            }
        });
        jPanel1.add(Ilive8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 180, -1));

        jLabel2.setText("Proces");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 460));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User", "Admin", "Centercoop", "Kooperation" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 130, 20));

        jLabel4.setText("Select User");
        jLabel4.setToolTipText("");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        jPanel3.add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 130, -1));

        passwordLabel.setText("Password:");
        jPanel3.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 193, 130, -1));

        username.setText("Username:");
        jPanel3.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 130, -1));


        jusername.setText("");
        jPanel3.add(jusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 130, -1));

        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButton(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 910, 470));

        pack();
    }// </editor-fold>



    private void LoginButton(java.awt.event.ActionEvent evt) {
        HashTable.makeHashTables();
        String selectedUserType = jComboBox1.getSelectedItem().toString().toLowerCase();
        String username = jusername.getText();
        String password = String.valueOf(jPasswordField.getPassword());

        System.out.println(password);
        switch (selectedUserType) {
            case "select user" ->
                    JOptionPane.showMessageDialog(null, "Please select a valid user type", "Error", JOptionPane.ERROR_MESSAGE);
            case "kooperation" ->
            {


            }
            case"admin", "centercoop" -> {
                Boolean userExist = DBUtil.findUser(username, password, selectedUserType);
                if (Boolean.TRUE.equals(userExist)) {
                    initWebcam();
                    jPanel3.setVisible(false);
                    jPanel1.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            default ->
                    JOptionPane.showMessageDialog(null, "Invalid user type selected", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }




    private void changeLoc(java.awt.event.ActionEvent evt, int intOfLoc) {
        if (currntBigBag != null){
            currntBigBag.setLocation(intOfLoc);
            SetResutFreld(currntBigBag);

        }
        else {
            System.out.println("nahej det må du ikke");
        }
    }


    private void changePro(java.awt.event.ActionEvent evt, int intOfPro) {
       if (currntBigBag != null){
           currntBigBag.setNUVProcess(intOfPro);
           SetResutFreld(currntBigBag);

       }
       else {
           System.out.println("nahej det må du ikke");
       }
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Ilive;
    private javax.swing.JButton Ilive1;
    private javax.swing.JButton Ilive2;
    private javax.swing.JButton Ilive3;
    private javax.swing.JButton Ilive4;
    private javax.swing.JButton Ilive5;
    private javax.swing.JButton Ilive6;
    private javax.swing.JButton Ilive7;
    private javax.swing.JButton Ilive8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel username;
    private javax.swing.JTextField jusername;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField result_freld;
    // End of variables declaration

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 360));

        executor.execute(this);

    }

    @Override
    public void run() {

        do {
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage imge = null;

            if (webcam.isOpen()) {
                if ((imge = webcam.getImage()) == null) {
                    continue;
                }

            }try {
                String decodedText = readQRCode(imge);
                System.out.println("Decoded QR code: " + decodedText);
                String split = decodedText.replaceAll("[^\\d]", "");
                int qrId = Integer.parseInt(split);
                //com.example.app.TableStructure.BigBags MyBig = new BigBags();
                currntBigBag = new BigBags(qrId);
                SetResutFreld(currntBigBag);
                //result_freld.setText("BID " + currntBigBag.BID + " OwnerId: " + currntBigBag.OwnerId + ", NUVProcess: " + currntBigBag.NUVProcess + ", Type: " + currntBigBag.Type);


                // Do something with the decoded text
            } catch (NotFoundException e) {
                // QR code not found in the image
            } catch (Exception e) {
                // Other exceptions
                //e.printStackTrace();
            }
        }while (true);

    }


    public void SetResutFreld(BigBags currntBigBag){
        result_freld.setText("BID " + currntBigBag.BID + " OwnerId: " + currntBigBag.OwnerId + ", NUVProcess: " + currntBigBag.NUVProcess + ", Type: " + currntBigBag.Type + ", Location: " + currntBigBag.Location);

    }

    public String readQRCode(BufferedImage image) throws NotFoundException {
        // Convert the BufferedImage to RGBLuminanceSource
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
        RGBLuminanceSource source = new RGBLuminanceSource(image.getWidth(), image.getHeight(), pixels);

        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Reader reader = new QRCodeReader();
        Result result;
        try {
            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            result = reader.decode(bitmap, hints);
            return result.getText();
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("Error decoding QR code", e);
        }
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My thread");
        t.setDaemon(true);
        return t;

    }
}
