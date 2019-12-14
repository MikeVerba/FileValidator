package com.company.logic;

import com.company.utils.FileSignatures;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSignatureChecker {

     String checkFileSignature(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        int fileSignature = input.readInt();
        input.close();


         if(Files.probeContentType(file.toPath()).equals("text/plain")){
            String firstLineInHex = String.format("%040x", new BigInteger(readFirstLine(pathToFile).getBytes()));
            if(firstLineInHex.contains(Integer.toHexString(fileSignature))){
                return "TXT";
            }
        }

         if (fileSignature == FileSignatures.JPEG_SIGNATURE) {
            return "JPEG";
        } else if(fileSignature == FileSignatures.PNG_SIGNATURE){
            return "PNG";
        } else if(fileSignature == FileSignatures.GIF_SIGNATURE){
            return "GIF";
        } else if(fileSignature == FileSignatures.PDF_SIGNATURE) {
            return "PDF";
        } else throw new IllegalArgumentException("Unsupported file format!");
    }

    private String readFirstLine(String pathToFile) {

        String firstLine = "";
        Path filePath = Paths.get(pathToFile);
        try {
            firstLine = Files.lines(filePath).findFirst().get();
        } catch (Exception e) {
            System.out.println("The file is not valid!!");
        }
        return firstLine;
    }
}
