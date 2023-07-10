package project.toco.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.toco.dto.EducationDto;
import project.toco.dto.condition.EduCondition;
import project.toco.entity.Level;
import project.toco.entity.LoginUser;
import project.toco.service.EducationService;
import project.toco.service.MemberService;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final EducationService educationService;
    private final MemberService memberService;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model, @AuthenticationPrincipal LoginUser user){
        List<EducationDto> eduList = educationService.findAllToDto();
        if(user!=null){
            model.addAttribute("name", memberService.findByEmail(user.getUsername()).getName());
        }
        model.addAttribute("eduList", eduList);
        model.addAttribute("topList", educationService.getTopThree(eduList));
        return "index";
    }

    @GetMapping(value = {"/info"})
    public String info(){
        return "info";
    }
}
