package project.toco.service;

import jdk.jfr.Threshold;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.repository.ProgressRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProgressService {
  private final ProgressRepository progressRepository;


}
