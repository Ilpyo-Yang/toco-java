package project.toco.repository.Impl;

import static project.toco.entity.QEducationContent.educationContent;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import project.toco.dto.EducationContentDto;
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

  @Override
  public List<EducationContentDto> findAllToDto(Education education) {
    return jpaQueryFactory
        .select(Projections.fields(EducationContentDto.class,
            educationContent.uuid, educationContent.chapter, educationContent.name, educationContent.intro,
            educationContent.details, educationContent.education.uuid))
        .from(educationContent)
        .where(educationEq(education))
        .orderBy(educationContent.chapter.asc())
        .fetch();
  }

  private BooleanExpression chapterEq(int chapter) {
    return chapter!=0 ? educationContent.chapter.eq(chapter) : null;
  }

  private BooleanExpression educationEq(Education education) {
    return education!=null ? educationContent.education.eq(education) : null;
  }
}
