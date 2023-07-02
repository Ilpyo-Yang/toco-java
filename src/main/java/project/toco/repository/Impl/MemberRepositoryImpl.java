package project.toco.repository.Impl;

import static org.springframework.util.StringUtils.hasText;
import static project.toco.entity.QEducationType.educationType;
import static project.toco.entity.QMember.member;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.toco.dto.MemberDto;
import project.toco.repository.custom.MemberRepositoryCustom;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public MemberDto findByEmail(String uuid) {
    return jpaQueryFactory
        .select(Projections.fields(MemberDto.class, member.uuid, member.name, member.email, member.password, member.role,
            member.createdDate, member.lastModifiedDate))
        .from(member)
        .where(emailEq(uuid))
        .fetchOne();
  }

  private BooleanExpression emailEq(String email) {
    return hasText(email) ? member.email.eq(email) : null;
  }
}
