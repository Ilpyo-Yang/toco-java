package project.toco.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.entity.EducationScore;
import project.toco.repository.EducationScoreRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EducationScoreService {
  private final EducationScoreRepository educationScoreRepository;

  public EducationScore create(EducationScore score){
    return educationScoreRepository.save(score);
  }

  public EducationScore findById(String uuid){
    return educationScoreRepository.findById(uuid).get();
  }

  public long calculateScore(String uuid) {
    return educationScoreRepository.calculateScore(uuid);
  }
}
