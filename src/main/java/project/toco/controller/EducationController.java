package project.toco.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.toco.dto.EducationDto;
import project.toco.dto.EducationTypeDto;
import project.toco.dto.condition.EduCondition;
import project.toco.entity.Level;
import project.toco.service.EducationContentService;
import project.toco.service.EducationService;
import project.toco.service.EducationTypeService;

@Controller
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;
    private final EducationTypeService educationTypeService;
    private final EducationContentService educationContentService;

    /* 리스트페이지 */
    @GetMapping(value = {"/edu"})
    public String edu(Model model){
        List<String> mainTypeList = educationTypeService.findMainType();
        model.addAttribute("mainTypeList", mainTypeList);
        return "edu";
    }

    @ResponseBody
    @GetMapping(value = {"/edu/list"})
    public List<EducationDto> eduList(Model model,
                            @RequestParam("period") int period,
                            @RequestParam("star") int star,
                            @RequestParam("level") String level,
                            @RequestParam("main") String main,
                            @RequestParam("sub") String sub){
        List<String> type = educationTypeService.findUuid(main, sub);
        Level enum_level = level.equals(null)? null : Level.valueOf(level);
        EduCondition eduCondition = new EduCondition(period, star, enum_level, type);
        return educationService.findAllToDtoWithCondition(eduCondition);
    }

    @ResponseBody
    @GetMapping(value = {"/edu/type/sub"})
    public List<EducationTypeDto> typeList(Model model, @RequestParam("main") String main){
        if("all".equals(main)) main = null;
        return educationTypeService.findTypesToDtoByMain(main);
    }

    /* 상세페이지 */
    @GetMapping(value = {"/eduDetail/{uuid}"})
    public String eduDetail(Model model, @PathVariable("uuid") String uuid){
        model.addAttribute("dto", educationService.findOneEduToDto(uuid));
        model.addAttribute("contents", educationContentService.findAllToDto());
        return "eduDetail";
    }
}
