package com.tech.senthil.youtubeclone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "document")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment {

    @Id
    private String id;
    private String text;
    private String authorId;
    private Integer likesCount;
    private Integer dislikeCount;


}
