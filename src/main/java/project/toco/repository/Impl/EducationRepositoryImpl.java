package project.toco.repository.Impl;

import static com.querydsl.core.types.ExpressionUtils.count;
import static project.toco.entity.QEducation.education;
import static project.toco.entity.QEducationScore.educationScore;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import project.toco.dto.EducationDto;
import project.toco.dto.condition.EduCondition;
import project.toco.repository.custom.EducationCustom;

@RequiredArgsConstructor
public class EducationRepositoryImpl implements EducationCustom {
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public EducationDto findOneEduToDto(String uuid) {
    return jpaQueryFactory
        .select(Projections.fields(EducationDto.class,
            education.uuid, education.name, education.intro, education.students, education.period,
            education.type, education.level, education.createdDate, education.lastModifiedDate))
        .from(education)
        .where(uuidEq(uuid))
        .fetchOne();
  }

  @Override
  public List<EducationDto> findAllToDto(EduCondition eduCondition) {
    return jpaQueryFactory
        .select(Projections.fields(EducationDto.class,
            education.uuid, education.name, education.intro, education.students, education.period,
            education.type, education.level, education.createdDate, education.lastModifiedDate))
        .from(education)
        .where(typeEq(eduCondition.getSub()),
            education.period.between(eduCondition.getPeriod()-10,eduCondition.getPeriod()))
        .fetch();
  }

  private BooleanExpression uuidEq(String uuid) {
    return uuid!=null ? education.uuid.eq(uuid) : null;
  }

  private BooleanExpression typeEq(String type) {
    return type!=null ? education.type.eq(type) : null;
  }
}
