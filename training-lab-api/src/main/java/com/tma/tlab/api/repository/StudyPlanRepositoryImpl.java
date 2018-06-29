package com.tma.tlab.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tma.tlab.api.jpa.StudyPlanJpaRepository;
import com.tma.tlab.api.model.StudyPlan;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class StudyPlanRepositoryImpl extends ResourceRepositoryBase<StudyPlan, Long> implements StudyPlanRepository {

	@Autowired
	private StudyPlanJpaRepository jpaRepository;

	public StudyPlanRepositoryImpl() {
		super(StudyPlan.class);
	}

	@Override
	public ResourceList<StudyPlan> findAll(QuerySpec querySpec) {
		ResourceList<StudyPlan> list = new DefaultResourceList<StudyPlan>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<StudyPlan> studyPlans = jpaRepository.findAll();
		querySpec.apply(studyPlans, list);
		return list;
	}

	@Override
	public StudyPlan save(StudyPlan obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		StudyPlan obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}