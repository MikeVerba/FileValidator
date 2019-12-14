package com.company.logic;

import com.company.utils.FileSignatures;

import java.io.*;

public class FileSignatureChecker {

    public String checkFileSignature(String pathToFile) throws IOException {
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
        } else if(fileSignature == FileSignatures.PDF_SIGNATURE){
            return "PDF";
        } else throw new IllegalArgumentException("Unsupported file format!");
    }
}
