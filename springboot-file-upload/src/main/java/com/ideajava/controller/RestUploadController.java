package com.ideajava.controller;

import com.ideajava.model.UploadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rason on 4/13/17.
 */
@RestController
public class RestUploadController {

    private final Logger logger = LoggerFactory.getLogger(RestUploadController.class);

    // Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/rason/Documents/tmp/";

    // Single file upload
    @PostMapping("/api/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadFile) {

        logger.info("Single file upload!");

        if(uploadFile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {
            saveUploadFiles(Arrays.asList(uploadFile));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded - " +
                uploadFile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }

    // Multiple file upload
    @PostMapping("/api/upload/multi")
    public ResponseEntity<?> uploadFileMulti(@RequestParam("extraField") String extraField,
                                             @RequestParam("files") MultipartFile[] multipartFiles) {

        logger.info("Multiple file upload!");

        String uploadFileName = Arrays.stream(multipartFiles).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));

        if (StringUtils.isEmpty(uploadFileName)) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {

            saveUploadFiles(Arrays.asList(multipartFiles));

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded - "
                + uploadFileName, HttpStatus.OK);
    }

    // Map html form to a Model
    @PostMapping("/api/upload/multi/model")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute UploadModel model) {

        logger.debug("Multiple file upload! With UploadModel");

        try {

            saveUploadFiles(Arrays.asList(model.getFiles()));

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);

    }

    private void saveUploadFiles(List<MultipartFile> multipartFiles)  throws IOException {

        for (MultipartFile file : multipartFiles) {

            if(file.isEmpty()) {
                continue;
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        }

    }

}
