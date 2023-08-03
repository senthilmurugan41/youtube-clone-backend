package com.tech.senthil.youtubeclone.controller;

import com.tech.senthil.youtubeclone.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping(value = "/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadFile(@RequestParam("file") MultipartFile multipartFile)
    {
        videoService.uploadFile(multipartFile);
    }
}
