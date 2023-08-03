package com.tech.senthil.youtubeclone.repository;

import com.tech.senthil.youtubeclone.models.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<Video,String> {
}
