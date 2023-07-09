package project.toco.repository.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project.toco.repository.custom.ProgressCustom;

@RequiredArgsConstructor
public class ProgressRepositoryImpl implements ProgressCustom {
  private final JPAQueryFactory jpaQueryFactory;


}
