package project.toco.repository.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project.toco.repository.custom.BaseRepositoryCustom;

@RequiredArgsConstructor
public class BaseRepositoryImpl implements BaseRepositoryCustom {
  private final JPAQueryFactory jpaQueryFactory;

}
