package project.toco.repository.Impl;

import static project.toco.entity.QEducationType.educationType;

import com.querydsl.core.types.Projections;
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
}
