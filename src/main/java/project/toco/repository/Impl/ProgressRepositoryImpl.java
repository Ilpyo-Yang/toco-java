package project.toco.repository.Impl;

import static org.springframework.util.StringUtils.hasText;
import static project.toco.entity.QProgress.progress;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import project.toco.dto.ProgressDto;
import project.toco.entity.QEducationContent;
import project.toco.repository.custom.ProgressCustom;

@RequiredArgsConstructor
public class ProgressRepositoryImpl implements ProgressCustom {
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<ProgressDto> findByMemberUuidToDto(String memberUuid) {
    return jpaQueryFactory
        .select(Projections.fields(ProgressDto.class, progress.uuid, progress.status,
            progress.member.uuid.as("memberUuid"),
            progress.education_content.uuid.as("educationContentUuid"),
            progress.education_content.name.as("educationContentName"),
            progress.education_content.education.uuid.as("educationUuid"),
            progress.education_content.education.name.as("educationName"),
            progress.startDate, progress.mailingDays))
        .from(progress)
        .where(memberUuidEq(memberUuid))
        .fetch();
  }

  private BooleanExpression memberUuidEq(String memberUuidEq) {
    return hasText(memberUuidEq) ? progress.member.uuid.eq(memberUuidEq) : null;
  }
}
