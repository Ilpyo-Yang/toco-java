package project.toco.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import project.toco.service.EducationService;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final EducationService educationService;

    @GetMapping(value = {"/", "/index"})
    public String index(){
        educationService.findAll();
        return "index";
    }
}
