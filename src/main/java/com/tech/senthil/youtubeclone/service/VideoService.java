package com.tech.senthil.youtubeclone.service;

import com.tech.senthil.youtubeclone.models.Video;
import com.tech.senthil.youtubeclone.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class VideoService {
    @Autowired
    private FileService fileService;
    @Autowired
    private VideoRepository videoRepository;

    public void uploadFile(MultipartFile multipartFile)
    {
        var url= fileService.uploadFile(multipartFile);
        Video video = new Video();
        video.setVideoUrl(url);
        videoRepository.save(video);

    }

}
