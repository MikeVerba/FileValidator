package com.company.logic;

import com.company.utils.FileSignatures;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSignatureChecker {

     String checkFileSignature(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        int fileSignature = input.readInt();
        input.close();

        if (fileSignature == FileSignatures.JPEG_SIGNATURE) {
            return "JPEG";
        } else if(fileSignature == FileSignatures.PNG_SIGNATURE){
            return "PNG";
        } else if(fileSignature == FileSignatures.GIF_SIGNATURE){
            return "GIF";
        } else if(fileSignature == FileSignatures.PDF_SIGNATURE) {
            return "PDF";
//        }else if(fileSignature = readFirstLine(pathToFile)){
//            return "TXT"; todo implement checking .txt files - when magic number equals the first line of file
//             then it is text/plain
        } else throw new IllegalArgumentException("Unsupported file format!");
    }


    //todo for checking .txt files
    public String readFirstLine(String pathToFile) {

        String firstLine = "";
        Path filePath = Paths.get(pathToFile);
        try {
            firstLine = Files.lines(filePath).findFirst().get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(firstLine);
        return firstLine;
    }
}
