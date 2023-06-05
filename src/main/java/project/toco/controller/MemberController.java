package project.toco.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @PostMapping("/logout")
    public String logout(){
        return "/";
    }

}
