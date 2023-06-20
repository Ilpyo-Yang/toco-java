package project.toco.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.toco.dto.form.SignupForm;
import project.toco.service.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping(value = {"/login"})
    public String login(){
        return "login";
    }

    @GetMapping(value = {"/signup"})
    public String signup(Model model){
        model.addAttribute("form", new SignupForm());
        return "signup";
    }

    @PostMapping(value = {"/signup"})
    public String signup(@RequestParam("form") SignupForm form){
        memberService.create(form);
        return "/";
    }

    @GetMapping(value = {"/logout"})
    public void logout(){

    }

}
