package project.toco.repository.Impl;

import static org.springframework.util.StringUtils.hasText;
import static project.toco.entity.QMember.member;
import static project.toco.entity.QProgress.progress;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import project.toco.dto.MemberDto;
import project.toco.dto.ProgressDto;
import project.toco.repository.custom.ProgressCustom;

@RequiredArgsConstructor
public class ProgressRepositoryImpl implements ProgressCustom {
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<ProgressDto> findByMemberUuid(String memberUuid) {
    return jpaQueryFactory
        .select(Projections.fields(ProgressDto.class, progress.uuid, progress.status,
            progress.member.uuid, progress.education_content.uuid,
            progress.createdBy, progress.lastModifiedBy,
            progress.createdDate, progress.lastModifiedDate))
        .from(progress)
        .where(memberUuidEq(memberUuid))
        .fetch();
  }

  private BooleanExpression memberUuidEq(String memberUuidEq) {
    return hasText(memberUuidEq) ? progress.member.uuid.eq(memberUuidEq) : null;
  }
}
