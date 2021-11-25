package com.example.getmesocialservice.Resource;


import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.example.getmesocialservice.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://photoapp2265.s3-website-us-east-1.amazonaws.com"})
@RequestMapping("/api/files")
public class FileResource {
    @Autowired
    private FileService fileService;
    @PostMapping
    public boolean upload(@RequestParam(name="file") MultipartFile file){
        return fileService.upload(file);}
    @GetMapping("/view")
    public void view(@RequestParam(name="key") String key, HttpServletResponse response) throws IOException {
        S3Object object=fileService.getFile(key);

        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }

    @GetMapping("/download")

    public ResponseEntity<ByteArrayResource> download(@RequestParam(name="key") String key) throws IOException {
        S3Object data=fileService.getFile(key); // fileName is key which is used while uploading the object
        S3ObjectInputStream objectContent = data.getObjectContent();
        byte[] bytes = IOUtils.toByteArray(objectContent);
        ByteArrayResource resource = new ByteArrayResource(bytes);
        objectContent.close();
        return ResponseEntity
                .ok()
                .contentLength(bytes.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + key + "\"")
                .body(resource);
    }

    @DeleteMapping
    public void delete(@RequestParam(name="key") String key){
        fileService.deleteFile(key);
    }
}
