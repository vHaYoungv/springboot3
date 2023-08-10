package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title; //제목을 받을 필드
    private String content; //내용을 받을 필드

//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    } //@AllArgsConstructor로 대체

//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    } //@ToString으로 대체

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
