package project.toco.repository.Impl;

import static org.springframework.util.StringUtils.hasText;
import static project.toco.entity.QEducationContent.educationContent;
import static project.toco.entity.QMember.member;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project.toco.entity.Education;
import project.toco.repository.custom.EducationContentCustom;

@RequiredArgsConstructor
public class EducationContentRepositoryImpl implements EducationContentCustom {
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public String getNextUuid(int nextChapter, Education education) {
    return jpaQueryFactory
        .select(educationContent.uuid)
        .from(educationContent)
        .where(chapterEq(nextChapter),educationEq(education))
        .fetchOne();
  }

  private BooleanExpression chapterEq(int chapter) {
    return chapter!=0 ? educationContent.chapter.eq(chapter) : null;
  }

  private BooleanExpression educationEq(Education education) {
    return education!=null ? educationContent.education.eq(education) : null;
  }
}
