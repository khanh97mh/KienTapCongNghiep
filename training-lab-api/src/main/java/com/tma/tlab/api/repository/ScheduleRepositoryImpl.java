package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.ScheduleJpaRepository;
import com.tma.tlab.api.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class ScheduleRepositoryImpl extends ResourceRepositoryBase<Schedule, Long> implements ScheduleRepository {

	@Autowired
	private ScheduleJpaRepository jpaRepository;

	public ScheduleRepositoryImpl() {
		super(Schedule.class);
	}

	@Override
	public ResourceList<Schedule> findAll(QuerySpec querySpec) {
		ResourceList<Schedule> list = new DefaultResourceList<Schedule>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<Schedule> schedules = jpaRepository.findAll();
		querySpec.apply(schedules, list);
		return list;
	}

	@Override
	public Schedule save(Schedule obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		Schedule obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}