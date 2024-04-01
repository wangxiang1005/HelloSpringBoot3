package com.paladin.minio.controller;

import com.paladin.minio.config.MinioPojo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/minio")
public class TestController {
    @Autowired
    private MinioService minioService;

    @Autowired
    private MinioPojo minioPojo;

    @RequestMapping("/helloworld")
    public String hello() {
        return "SUCCESS";
    }

    //文件上传
    @Operation(summary = "上传图片")
    @PostMapping("/uploadImage")
    public String uploadImage(MultipartFile file){
        return minioService.uploadImage(minioPojo.getBucketName(), file);
    }

    //文件上传
    @Operation(summary = "查询图片")
    @PostMapping("/getImage")
    public String getImage(String url){
        return minioService.getImage(url);
    }

    //文件上传
    @Operation(summary = "删除图片")
    @PostMapping("/deleteImage")
    public String deleteImage(String url){
        return minioService.deleteImage(minioPojo.getBucketName(), url);
    }
}