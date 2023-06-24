package project.toco.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,  @RequestParam("password") String password){
        return memberService.login(email, password);
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
