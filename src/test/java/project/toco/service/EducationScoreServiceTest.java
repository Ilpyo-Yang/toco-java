package project.toco.service;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.toco.entity.Education;
import project.toco.entity.EducationScore;
import project.toco.entity.Member;
import project.toco.repository.EducationRepository;
import project.toco.repository.EducationScoreRepository;
import project.toco.repository.MemberRepository;

@SpringBootTest
@Transactional
class EducationScoreServiceTest {
  @Autowired
  EducationScoreRepository educationScoreRepository;
  @Autowired
  EducationRepository educationRepository;
  @Autowired
  MemberRepository memberRepository;

  @Test
  void create() {
    Member member = memberRepository.findAll().get(0);
    Education education = educationRepository.findAll().get(0);
    EducationScore educationScore = EducationScore.createEducationScore(member.getUuid(), 5, education);
    EducationScore score = educationScoreRepository.save(educationScore);
    assert score.getMember_uuid().equals(member.getUuid());
  }

  // spring data
  @Test
  void findById() {}

  @Test
  void calculateScore() {
    EducationScore educationScore = educationScoreRepository.findAll().get(0);
    long score = educationScoreRepository.calculateScore(educationScore.getEducation().getUuid());
    List<EducationScore> educationScoreList = educationScoreRepository.findAllByEducationUuid(educationScore.getEducation().getUuid());
    long sum = 0;
    for(EducationScore es : educationScoreList){
      sum += educationScore.getScore();
    }
    assert  score == sum/educationScoreList.size();
  }
}