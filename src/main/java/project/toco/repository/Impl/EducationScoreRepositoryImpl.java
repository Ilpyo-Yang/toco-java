package project.toco.repository.Impl;

import static org.springframework.util.StringUtils.hasText;
import static com.querydsl.core.types.ExpressionUtils.count;
import static project.toco.entity.QEducation.education;
import static project.toco.entity.QEducationScore.educationScore;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project.toco.repository.custom.EducationScoreCustom;

@RequiredArgsConstructor
public class EducationScoreRepositoryImpl implements EducationScoreCustom {
  private final JPAQueryFactory jpaQueryFactory;

  public long calculateScore(String uuid) {
    return jpaQueryFactory
        .select(educationScore.score.sum().longValue().divide(count(educationScore.uuid)))
        .from(educationScore)
        .where(uuidEq(uuid))
        .fetchOne();
  }

  private BooleanExpression uuidEq(String uuid) {
    return hasText(uuid)? education.uuid.eq(uuid) : null;
  }
}
