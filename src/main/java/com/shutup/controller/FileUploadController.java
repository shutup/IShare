package com.shutup.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Tom on 12/5/16.
 */
@RequestMapping(path = {"/fileUpload"})
@RestController
public class FileUploadController {

    @RequestMapping(method = RequestMethod.POST)
    public void fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File file1 = new File("");
        byte[] bytes = file.getBytes();
        // Creating the directory to store file
        String rootPath = "./";
        File dir = new File(rootPath + File.separator + "tmpFiles");
        if (!dir.exists())
            dir.mkdirs();

        // Create the file on server
        File serverFile = new File(dir.getAbsolutePath()
                + File.separator + file.getOriginalFilename());
        BufferedOutputStream stream = null;
        try {
            stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("got file" +file.getOriginalFilename());
    }
}
