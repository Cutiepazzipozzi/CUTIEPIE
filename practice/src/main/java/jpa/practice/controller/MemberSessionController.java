package jpa.practice.controller;

import jpa.practice.member.Member;
import jpa.practice.member.MemberSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
//모든 매핑은 member를 상속함! 다는 의미래용
public class MemberSessionController {

    private final MemberSessionService memberService;

    @GetMapping("/add")
    public String joinMember(@ModelAttribute("member") Member member) {
        return "members/joinMember";
    }

    @PostMapping("/add")
    public String joinMember2(@Valid @ModelAttribute Member member, BindingResult b) {
        if(b.hasErrors()) {
            return "members/joinMember";
        }
        memberService.save(member);
        return "redirect:/";
    }

}