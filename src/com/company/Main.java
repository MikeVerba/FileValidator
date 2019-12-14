package com.company;

import com.company.logic.FileValidator;

public class Main {

    public static void main(String[] args) throws Exception {

        FileValidator fileValidator = new FileValidator();
        fileValidator.performMainLoop();
    }
}
