package project.toco.repository.Impl;

import static org.springframework.util.StringUtils.hasText;
import static project.toco.entity.QEducation.education;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import project.toco.dto.EducationDto;
import project.toco.dto.condition.EduCondition;
import project.toco.entity.Level;
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
  public List<EducationDto> findAllToDto() {
    return jpaQueryFactory
        .select(Projections.fields(EducationDto.class,
            education.uuid, education.name, education.intro, education.students, education.period,
            education.type, education.level, education.createdDate, education.lastModifiedDate))
        .from(education)
        .fetch();
  }

  @Override
  public List<EducationDto> findAllToDtoWithCondition(EduCondition eduCondition) {
    return jpaQueryFactory
        .select(Projections.fields(EducationDto.class,
            education.uuid, education.name, education.intro, education.students, education.period,
            education.type, education.level, education.createdDate, education.lastModifiedDate))
        .from(education)
        .where(typeEq(eduCondition.getType_uuid()),
            levelEq(eduCondition.getLevel()),
            periodEq(eduCondition.getPeriod()))
        .fetch();
  }

  @Override
  public List<String> findAllEduNames() {
    return jpaQueryFactory
        .select(education.uuid)
        .from(education)
        .fetch();
  }

  private BooleanExpression uuidEq(String uuid) {
    return hasText(uuid) ? education.uuid.eq(uuid) : null;
  }

  private BooleanExpression typeEq(List<String> type) {
    return type!=null ? education.type.in(type) : null;
  }

  private BooleanExpression levelEq(Level level) {
    return !"All".equals(level.name()) ? education.level.eq(level) : null;
  }

  private BooleanExpression periodEq(int period) {
    return period!=0 ? education.period.between(period-10, period) : null;
  }
}
