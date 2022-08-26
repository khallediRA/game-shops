package com.gameshop.gameshop.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class FileStoringService {

    String ressource_dir = Path.of("").toAbsolutePath().toString() + "/productimages/";

    public String save(byte[] content, String imageName) throws Exception {
        String uniqueImagesName = new Date().getTime() + "-" + imageName;
        Path newFile = Paths.get(ressource_dir + uniqueImagesName);
        Files.createDirectories(newFile.getParent());

        Files.write(newFile, content);

        return uniqueImagesName;
    }
}
