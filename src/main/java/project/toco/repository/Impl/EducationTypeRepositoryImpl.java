package project.toco.repository.Impl;

import static project.toco.entity.QEducation.education;
import static project.toco.entity.QEducationType.educationType;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import project.toco.dto.EducationTypeDto;
import project.toco.repository.custom.EducationTypeCustom;

@RequiredArgsConstructor
public class EducationTypeRepositoryImpl implements EducationTypeCustom {
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<EducationTypeDto> findTypesToDto() {
    return jpaQueryFactory
        .select(Projections.fields(EducationTypeDto.class, educationType.uuid, educationType.main, educationType.sub))
        .from(educationType)
        .fetch();
  }

  @Override
  public List<EducationTypeDto> findTypesToDtoByMain(String main) {
    return jpaQueryFactory
        .select(Projections.fields(EducationTypeDto.class, educationType.uuid, educationType.main, educationType.sub))
        .from(educationType)
        .where(mainEq(main))
        .fetch();
  }

  @Override
  public List<String> findMainType() {
    return jpaQueryFactory
        .select(educationType.main).distinct()
        .from(educationType)
        .orderBy(educationType.main.desc())
        .fetch();
  }

  @Override
  public List<String> findUuidByMainAndSub(String main, String sub) {
    return jpaQueryFactory
        .select(educationType.uuid)
        .from(educationType)
        .where(mainEq(main), subEq(sub))
        .fetch();
  }

  private BooleanExpression mainEq(String main) {
    return !main.isEmpty() ? educationType.main.eq(main) : null;
  }

  private BooleanExpression subEq(String sub) {
    return !sub.isEmpty() ? educationType.uuid.eq(sub) : null;
  }

}
