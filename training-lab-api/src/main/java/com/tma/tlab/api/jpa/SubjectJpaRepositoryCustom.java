package com.tma.tlab.api.jpa;

import com.tma.tlab.api.model.Subject;

public interface SubjectJpaRepositoryCustom {
	Iterable<Subject> findAllWithDescription(String description);
}
