package se331.rest.lab.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import se331.rest.lab.util.CloudStorageHelper;

@Component
@Controller
@RequiredArgsConstructor
public class BucketController {
    @Autowired
    CloudStorageHelper cloudStorageHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file") MultipartFile file)
            throws IOException, ServletException {
        return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file, "imageupload-4b2c0.appspot.com"));
    }
}
