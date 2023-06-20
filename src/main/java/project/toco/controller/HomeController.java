package project.toco.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.toco.dto.EducationDto;
import project.toco.dto.condition.EduCondition;
import project.toco.entity.Level;
import project.toco.service.EducationService;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final EducationService educationService;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model){
        List<EducationDto> eduList = educationService.findAllToDto();
        model.addAttribute("eduList", eduList);
        model.addAttribute("topList", educationService.getTopThree(eduList));
        return "index";
    }

    @GetMapping(value = {"/info"})
    public String info(){
        return "info";
    }
}
