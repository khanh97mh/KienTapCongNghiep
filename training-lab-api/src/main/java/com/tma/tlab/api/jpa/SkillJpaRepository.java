package com.tma.tlab.api.jpa;

import com.tma.tlab.api.model.Skill;

public interface SkillJpaRepository  extends CommonJpaRepository< Skill, Long>, SkillJpaRepositoryCustom {
}
