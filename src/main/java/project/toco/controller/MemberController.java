package project.toco.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import project.toco.service.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;



}
