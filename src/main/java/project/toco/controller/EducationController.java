package project.toco.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.toco.dto.EducationDto;
import project.toco.service.EducationScoreService;
import project.toco.service.EducationService;
import project.toco.service.EducationTypeService;

@Controller
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;
    private final EducationScoreService educationScoreService;

    @GetMapping(value = {"/edu"})
    public String edu(Model model){
        List<EducationDto> educationDtoList = educationService.findAllToDto();
        Long score;
        for(EducationDto dto: educationDtoList){
            dto.setScore(educationScoreService.calculateScore(dto.getUuid()));
        }
        model.addAttribute("educationDtoList", educationDtoList);
        return "edu";
    }

    @GetMapping(value = {"/eduDetail/{uuid}"})
    public String eduDetail(Model model, @PathVariable(value = "uuid", required = true) String uuid){
        EducationDto education = educationService.findOneEduToDto(uuid);
        model.addAttribute("education", education);
        return "eduDetail";
    }
}
