package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {
    @Autowired
    private ArticleService articleService; // 서비스 객체 주입: 리파지터리가 아닌 서비스 객체 주입 !

    //GET
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }

    //POST
//    @PostMapping("/api/articles")
//    public Article create(@RequestBody ArticleForm dto) {
//        return articleService.create(dto);
//    } 내 예상: 틀림,

    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created = articleService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); //판단 정도는 컨트롤러에서 하는 구나
    }

//    @PatchMapping("/api/articles/{id}")
//    public ResponseEntity<Article> update(@RequestBody ArticleForm dto, @PathVariable Long id) {
//        // 1. 엔티티 변환
//        Article article = dto.toEntity();
//
//        // 2. 타깃 조회
//        Article target = articleRepository.findById(article.getId()).orElse(null);
//
//        // 3. 잘못된 요청 처리하기
//        if (target == null || id != article.getId()) {
//            // 400, 잘못된 요청 응답
//            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        // 4. 업데이트 및 정상응답하기
//        target.patch(article);
//        Article updated = articleRepository.save(article);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }

//    //PATCH
//    @PatchMapping("/api/articles/{id}")
//    public ResponseEntity<Article> update(@RequestBody ArticleForm dto, @PathVariable Long id) {
//        // 1. 엔티티 변환
//        Article article = dto.toEntity();
//
//        // 2. 타깃 조회
//        Article target = articleRepository.findById(article.getId()).orElse(null);
//
//        // 3. 잘못된 요청 처리하기
//        if (target == null || id != article.getId()) {
//            // 400, 잘못된 요청 응답
//            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        // 4. 업데이트 및 정상응답하기
//        target.patch(article);
//        Article updated = articleRepository.save(article);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }
//    //DELETE
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Article> delete(@PathVariable Long id) {
//        // 1. 대상 찾기
//        Article target = articleRepository.findById(id).orElse(null);
//
//        // 2. 잘못된 요청 처리하기
//        if (target == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        // 3. 대상 삭제하기
//        articleRepository.delete(target);
//        return ResponseEntity.status(HttpStatus.OK).body(null);
//    }
}
