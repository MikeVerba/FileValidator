package com.company.logic;

import com.company.comunicator.UserCommunicator;

public class FileValidator {

    private final ContentTypeChecker contentTypeChecker = new ContentTypeChecker();
    private final FileSignatureChecker fileSignatureChecker = new FileSignatureChecker();

    private String filePath;

    private boolean isModuleRunning = true;


    private boolean validate(String path) throws Exception {

        String contentType = contentTypeChecker.getContentType(path);

        String fileSignature = fileSignatureChecker.checkFileSignature(path);

//        System.out.println(contentTypeChecker.getContentType(path));
//
//        System.out.println(fileSignatureChecker.checkFileSignature(path));


        if(contentType.equals("image/gif") && fileSignature.equals("GIF")){
            return true;
        }
        else if(contentType.equals("image/jpeg") && fileSignature.equals("JPEG")){
            return true;
        }
        else if(contentType.equals("image/png") && fileSignature.equals("PNG")){
            return true;
        }
        else if(contentType.equals("application/pdf") && fileSignature.equals("PDF")){
            return true;
        }
        
        //todo add logic to check .txt

        return false;
    }

    public void performMainLoop() throws Exception {

    while(isModuleRunning) {

       UserCommunicator.printMessage(UserCommunicator.USER_WELCOME);
       UserCommunicator.printMessage(UserCommunicator.ASK_FOR_FILE_PATH);
       UserCommunicator.printMessage(UserCommunicator.ASK_FOR_PROGRAM_TERMINATION);
       filePath = UserCommunicator.scanner.next();

       if (filePath.equals("x")){
           break;
       }

       if(validate(filePath)){

           UserCommunicator.printMessage(UserCommunicator.FILE_IS_VALID_MESSAGE);

       } else {
           UserCommunicator.printMessage(UserCommunicator.FILE_IS_NOT_VALID_MESSAGE);
           UserCommunicator.printMessage(UserCommunicator.EXTENSION_IS_MESSAGE + contentTypeChecker.getContentType(filePath));
           UserCommunicator.printMessage(UserCommunicator.ACTUALLY_IS_MESSAGE + fileSignatureChecker.checkFileSignature(filePath));
       }
    }
    }
}
