/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacramera;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexa
 */
public class startClass {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                qrGen.qrGentoDb();
            }
            
        } catch (WriterException ex) {
            Logger.getLogger(startClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(startClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(startClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
