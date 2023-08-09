package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {
    @Autowired // 스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입(DI)
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString()); //sout 대신 log.info
//        System.out.println(form.toString());

        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity(); //DTO를 엔티티로 변환하려면, 엔티티 클래스를 만들어야 한다. (여기서 Article)
        log.info(article.toString());
//        System.out.println(article.toString());

        //Article : 엔티티 ArticleForm: DTO

        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article); //레퍼지토리에 저장한걸 왜 반환?
        log.info(saved.toString());
//        System.out.println(saved.toString());
        return "";
    }
}
