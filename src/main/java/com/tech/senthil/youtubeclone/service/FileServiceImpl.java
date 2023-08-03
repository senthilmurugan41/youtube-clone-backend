package com.tech.senthil.youtubeclone.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {


    @Value("${accessKey}")
    private String accessKey;
    private final AmazonS3 amazonS3Client;

    private final String BUCKET_NAME= "senthil-youtube-clone";

    @Override
    public String uploadFile(MultipartFile multipartFile)
    {
        var key = UUID.randomUUID()+"."+ StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType());


        try {
            amazonS3Client.putObject(BUCKET_NAME,key,multipartFile.getInputStream(),objectMetadata);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        amazonS3Client.setBucketAcl(BUCKET_NAME, CannedAccessControlList.PublicRead);
        return amazonS3Client.getUrl(BUCKET_NAME,key).toString();

    }
}
