package com.imooc.web.controller;

import com.imooc.dto.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {
    private final String folder = "/home/derek/Playground/Java/SpringBoot/imooc-security/imooc-security-demo/src/main/java/com/imooc/web/controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        log.info("filename: {}", file.getName());
        log.info("original name: {}", file.getOriginalFilename());
        log.info("size: {}", file.getSize());


        File localFile = new File(folder, new Date().getTime() + ".txt");
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (
                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = response.getOutputStream()) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }
    }
}
