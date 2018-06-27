package com.tma.tlab.api.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.tma.tlab.api.model.Skill;

public class SkillJpaRepositoryImpl implements SkillJpaRepositoryCustom{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Iterable<Skill> findAllWithDescription(String description) {
		TypedQuery<Object[]> query = entityManager.createNamedQuery("Skill.findAllWithDescription", Object[].class);
        query.setParameter("description", description);
        List results = query.getResultList();
        return results;

	}

}
