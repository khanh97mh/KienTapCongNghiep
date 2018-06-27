package com.tma.tlab.api.jpa;

import com.tma.tlab.api.model.Skill;

public interface SkillJpaRepositoryCustom {
	Iterable<Skill> findAllWithDescription(String description);
}
