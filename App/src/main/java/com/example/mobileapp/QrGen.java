package com.example.mobileapp;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import com.google.zxing.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.awt.image.BufferedImage;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import java.awt.Color;
//import com.google.zxing.client.j2se.matrixtoimagewriter;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 *
 * @author alexa
 */

public class QrGen {
/*
    public static Node generateQRcode(String data) throws WriterException {
        String charset = "UTF-8";
        int h = 100;
        int w = 100;
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                image.setRGB(x, y, matrix.get(x,y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }
        //ImageView imageView = new ImageView(SwingFXUtils.toFXImage(image, null));
        return imageView;
    }

*/

}
