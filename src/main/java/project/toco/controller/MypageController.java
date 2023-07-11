package project.toco.controller;

import static project.toco.util.Utils.getRandomFileName;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.toco.dto.ProgressDto;
import project.toco.entity.LoginUser;
import project.toco.service.MemberService;
import project.toco.service.ProgressService;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {
    private final ProgressService progressService;
    private final MemberService memberService;

    @GetMapping
    public String myPage(Model model, @AuthenticationPrincipal LoginUser user){
        List<ProgressDto> progressDtoList = progressService.findByMemberUuidToDto(user.getUuid());
        model.addAttribute("notStartCnt", progressService.getNotStartCnt(progressDtoList));
        model.addAttribute("progressCnt", progressService.getProgressCnt(progressDtoList));
        model.addAttribute("finishedCnt", progressService.getFinishedCnt(progressDtoList));
        model.addAttribute("stoppedCnt", progressService.getStoppedCnt(progressDtoList));
        model.addAttribute("progressDtoList", progressDtoList);
        model.addAttribute("profile", getRandomFileName("src/main/resources/static/image/profile"));
        if(user!=null){
            model.addAttribute("name", memberService.findByEmail(user.getUsername()).getName());
        }
        return "mypage";
    }

}
