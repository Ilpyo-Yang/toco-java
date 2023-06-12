package project.toco.repository;

import static project.toco.entity.QEducationType.educationType;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.dto.EducationTypeDto;
import project.toco.entity.EducationType;
import project.toco.repository.custom.EducationTypeCustom;

@Repository
@RequiredArgsConstructor
public class EducationTypeRepository {
  private final JPAQueryFactory jpaQueryFactory;

  public List<EducationTypeDto> findTypesToDto() {
    return jpaQueryFactory
        .select(Projections.fields(EducationTypeDto.class, educationType.uuid, educationType.main, educationType.sub))
        .from(educationType)
        .fetch();
  }
}
