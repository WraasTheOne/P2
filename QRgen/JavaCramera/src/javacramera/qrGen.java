package javacramera;

import com.google.zxing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 *
 * @author alexa
 */
public class qrGen {

    public static String[] ranNames = {"Anabella", "Brenda", "Madelynn", "Paxton", "Zavier", "Kenneth", "Claire", "Isabela", "Jovanni", "Aliana", "Ronan", "Gwendolyn", "Marilyn", "Lia", "Cassandra", "Hayden", "Mira", "Jennifer", "Shamar", "Jaydon", "Conrad"};
    public static String[] CountryCode = {"DK", "US", "UK", "SE", "NO", "JP", "MX"};

    public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException {
//the BitMatrix class represents the 2D matrix of bits  
//MultiFormatWriter is a factory class that finds the appropriate Writer subclass for the BarcodeFormat requested and encodes the barcode with the supplied contents.  
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    }
//main() method  

    public static void qrGentoDb() throws WriterException, IOException, NotFoundException {
//data that we want to store in the QR code  

        int randIndex = (int) (Math.random() * ranNames.length);
        String currentName = ranNames[randIndex];
        randIndex = (int) (Math.random() * CountryCode.length);
        String currentCode = CountryCode[randIndex];
        int idGen = (int) (Math.random() * 1000000000);
        int age = (int) (Math.random() * 90);
        System.out.println(currentName + ":" + idGen);

        //path where we want to get QR Code  
        String path = "C:\\Users\\alexa\\OneDrive\\pjocektor\\QR_pngs\\" + currentName +"_"+ currentCode + ".png";
        //Encoding charset to be used  
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        //generates QR code with Low level(L) error correction capability  
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        //invoking the user-defined method that creates the QR code  
        generateQRcode(String.valueOf(idGen), path, charset, hashMap, 400, 400);//increase or decrease height and width accodingly   
        //prints if the QR code is generated   
        //
        getDbMysql.insertDb(idGen, currentName, currentCode, age);
        System.out.println("QR Code created successfully.");
    }

}
