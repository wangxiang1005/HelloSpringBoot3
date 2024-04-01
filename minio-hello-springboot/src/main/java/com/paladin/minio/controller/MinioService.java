package com.paladin.minio.controller;

import com.paladin.minio.config.MinioPojo;
import io.minio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MinioService {
    @Autowired
    private MinioClient minioClient;
    @Autowired
    private MinioPojo minioPojo;

    public String uploadImage(String bucketName, MultipartFile file) {
        try {
            //判断桶是否存在
            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!bucketExists){
                //如果不存在,就创建桶
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
            //本地时间:具体到年、月、日
            String yyyymmdd = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String filename = yyyymmdd+"/"+file.getOriginalFilename();
            //加一个/表示创建一个文件夹
            minioClient.putObject(PutObjectArgs.builder().
                    bucket(bucketName).
                    object(filename).
                    stream(file.getInputStream(), file.getSize(), -1).
            //文件上传的类型,如果不指定,那么每次访问时都要先下载文件
            contentType(file.getContentType()).build());
            return minioPojo.getUrl()+"/"+minioPojo.getBucketName()+"/"+filename;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传失败");
        }
    }

    public String getImage(String url){
        try{
            InputStream inputStream = minioClient.getObject(GetObjectArgs.builder()
                    .bucket(minioPojo.getBucketName())
                    .object(url)
                    .build());
            // 将输入流的内容复制到一个文件中
            Files.copy(inputStream, Path.of("D://test.png"),
                    StandardCopyOption.REPLACE_EXISTING);
            return "文件上传成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "文件上传失败";
    }

    public String deleteImage(String bucketName,String url) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(bucketName)
                    .object(url)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }
}