package project.toco.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.toco.service.EducationService;

@Controller
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @GetMapping(value = {"/edu"})
    public String edu(){
        return "edu";
    }

    @GetMapping(value = {"/eduDetail"})
    public String eduDetail(){
        return "eduDetail";
    }
}
