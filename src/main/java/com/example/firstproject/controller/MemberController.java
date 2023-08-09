package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired //이걸 안하면 !!
    private MemberRepository memberRepository; // public이 아니라 private

    @GetMapping("/members/new")
    public String newArticleForm() {
        return "members/new";
    }

    @PostMapping("/members/join")
    public String joinMembers(MemberForm form) {

        System.out.println(form.toString());
        // 1. DTO -> 엔티티
        Member member = form.toEntity();
        System.out.println(member.toString());
        // 2. 리파지터리로 DB에 저장
        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());
        return "";
    }

}
