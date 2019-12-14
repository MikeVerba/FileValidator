package com.company.logic;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ContentTypeChecker {

    public String getContentType(String pathToFile) throws Exception {

        Path path = new File(pathToFile).toPath();

        String result = Files.probeContentType(path);

        if (result == null) {
            throw new IllegalArgumentException("Unsupported file extension!");
        }
        return result;
    }
}
