package com.tma.tlab.api.jpa;

import com.tma.tlab.api.model.Subject;

public interface SubjectJpaRepository extends CommonJpaRepository<Subject, Long>, SubjectJpaRepositoryCustom {
}