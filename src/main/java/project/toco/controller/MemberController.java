package project.toco.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpServletResponse response){
        String token = memberService.login(email, password);
        if(token.isEmpty()){ return "failed";}
        response.addCookie(new Cookie("AUTHTOKEN", token));
        return "success";
    }

    @GetMapping(value = {"/signup"})
    public String signup(Model model){
        model.addAttribute("form", new SignupForm());
        return "signup";
    }

    @PostMapping(value = {"/signup"})
    public String signup(SignupForm form){
        memberService.create(form);
        return "index";
    }

    @GetMapping(value = {"/logout"})
    public void logout(){}

    @ResponseBody
    @GetMapping("member/existEmail")
    public String existEmail(@RequestParam("email") String email){
        return memberService.existEmail(email);
    }

}
