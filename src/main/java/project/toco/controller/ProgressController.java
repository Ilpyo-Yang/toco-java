package project.toco.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import project.toco.service.ProgressService;

@Controller
@RequiredArgsConstructor
public class ProgressController {
    private final ProgressService progressService;



}
