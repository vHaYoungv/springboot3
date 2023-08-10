package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
@Slf4j
public class MemberController {
    @Autowired //이걸 안하면 !!
    private MemberRepository memberRepository; // public이 아니라 private

    @GetMapping("/members/new")
    public String newArticleForm() {
        return "members/new";
    }

    @PostMapping("/members/join")
    public String joinMembers(MemberForm form) {
        log.info(form.toString());

        // 1. DTO -> 엔티티
        Member member = form.toEntity();
        log.info(member.toString());

        // 2. 리파지터리로 DB에 저장
        Member saved = memberRepository.save(member);
        log.info(saved.toString());

        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        Member memberEntity = memberRepository.findById(id).orElse(null);

        model.addAttribute("member", memberEntity);

        return "/members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        ArrayList<Member> memberEntityList = memberRepository.findAll();

        model.addAttribute("memberList", memberEntityList);

        return "/members/index";
    }
}
