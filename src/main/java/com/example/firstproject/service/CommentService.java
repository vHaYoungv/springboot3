package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDTO;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.firstproject.dto.CommentDTO.createCommentDTO;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;


    public List<CommentDTO> comments(Long articleId) {
        // 1. 댓글 조회
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        // 2. 엔티티 -> DTO 변환
        List<CommentDTO> dtos = new ArrayList<CommentDTO>();
        for (int i = 0; i < comments.size(); i++) {
            Comment c = comments.get(i);
            CommentDTO dto = createCommentDTO(c);
            dtos.add(dto);
        }
        // 3. 결과 반환
        return commentRepository.findByArticleId(articleId)
                .stream() // 대슥ㄹ 엔티티 목록을 스트림으로 변환
                .map(c->CommentDTO.createCommentDTO(c))// 엔티티를 DTO로 매핑
                .collect(Collectors.toList()); // 스트림을 리스트로 변환
    }

    @Transactional
    public CommentDTO create(Long articleId, CommentDTO dto) {
        // 1. 게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId)
                .orElseThrow(()->new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다."));

        // 2. 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, article);

        // 3. 댓글 엔티티를 DB에 저장
        Comment created = commentRepository.save(comment);

        // 4. DTO로 변환해 반환
        return CommentDTO.createCommentDTO(created);
    }
}
