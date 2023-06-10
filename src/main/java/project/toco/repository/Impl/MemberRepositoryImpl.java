package project.toco.repository.Impl;

import static org.springframework.util.StringUtils.hasText;
import static project.toco.entity.QEducationType.educationType;
import static project.toco.entity.QMember.member;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import project.toco.dto.MemberDto;
import project.toco.repository.custom.MemberRepositoryCustom;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public MemberDto findMemberToDto(String uuid) {
    return jpaQueryFactory
        .select(Projections.fields(MemberDto.class, member.uuid, educationType.main, educationType.sub))
        .from(member)
        .where(uuidEq(uuid))
        .fetchOne();
  }
  @Override
  public List<MemberDto> findMembersToDto() {
    return jpaQueryFactory
        .select(Projections.fields(MemberDto.class, member.uuid, educationType.main, educationType.sub))
        .from(member)
        .fetch();
  }

  private BooleanExpression uuidEq(String uuid) {
    return hasText(uuid) ? member.uuid.eq(uuid) : null;
  }
}
