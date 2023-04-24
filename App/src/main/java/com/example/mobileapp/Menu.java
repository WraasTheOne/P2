package com.example.mobileapp;

import com.example.app.TableStructure.BigBags;
import com.github.sarxos.webcam.*;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.*;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.RGBLuminanceSource; // import RGBLuminanceSource

import java.awt.image.BufferedImage;

import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


public class Menu extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private final Executor executor = Executors.newSingleThreadExecutor(this);

    public Menu() {
        initComponents();
        initWebcam();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        result_freld = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Ilive = new javax.swing.JButton();
        Ilive1 = new javax.swing.JButton();
        Ilive2 = new javax.swing.JButton();
        Ilive3 = new javax.swing.JButton();
        Ilive4 = new javax.swing.JButton();
        Ilive5 = new javax.swing.JButton();
        Ilive6 = new javax.swing.JButton();
        Ilive7 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        result_freld.setBorder(null);
        result_freld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                result_freldActionPerformed(evt);
            }
        });
        jPanel1.add(result_freld, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 500, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 670, 20));

        jLabel1.setText("Proces");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 500, 360));

        jTextField3.setText("Rresult");
        jTextField3.setBorder(null);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jButton2.setText("Collection");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 180, -1));

        jButton4.setText("Stacking");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 180, -1));

        Ilive.setText("Selling");
        Ilive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IliveActionPerformed(evt);
            }
        });
        jPanel1.add(Ilive, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 180, -1));

        Ilive1.setText("Sorting");
        jPanel1.add(Ilive1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 180, -1));

        Ilive2.setText("Label");
        jPanel1.add(Ilive2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 180, -1));

        Ilive3.setText("Storage CORPS");
        jPanel1.add(Ilive3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 180, -1));

        Ilive4.setText("Centercorp Delivery");
        Ilive4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ilive4ActionPerformed(evt);
            }
        });
        jPanel1.add(Ilive4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 180, -1));

        Ilive5.setText("Compress and weighing");
        jPanel1.add(Ilive5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 180, -1));

        Ilive6.setText("Label compressed weight");
        Ilive6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ilive6ActionPerformed(evt);
            }
        });
        jPanel1.add(Ilive6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 180, -1));

        Ilive7.setText("Storage centerCORP");
        Ilive7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ilive7ActionPerformed(evt);
            }
        });
        jPanel1.add(Ilive7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 460));

        pack();
    }// </editor-fold>

    private void result_freldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        System.out.println("javacramera.Menu.jButton4ActionPerformed()");

    }

    private void Ilive4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void IliveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Ilive6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Ilive7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
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
                com.example.app.TableStructure.BigBags MyBig = new BigBags();
                com.example.app.TableStructure.BigBags.getBigbag(qrId, MyBig);
                result_freld.setText();


                // Do something with the decoded text
            } catch (NotFoundException e) {
                // QR code not found in the image
            } catch (Exception e) {
                // Other exceptions
                //e.printStackTrace();
            }
        }while (true);

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
