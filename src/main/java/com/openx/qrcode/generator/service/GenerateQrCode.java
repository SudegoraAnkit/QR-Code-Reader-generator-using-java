package com.openx.qrcode.generator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

@Component
public class GenerateQrCode {

    void generateQrCode(String inputData, String outputFile) {
        try{
            QRCodeWriter qrWriter=new QRCodeWriter();

            HashMap<EncodeHintType,Object> hints=new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

            BitMatrix bitMatrix = qrWriter.encode(inputData, BarcodeFormat.QR_CODE,300,300,hints);
            Path path = Paths.get(outputFile);
            MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
        }catch (Exception e){
            System.out.println("Error: writing" );
            e.printStackTrace();
        }
    }
}
