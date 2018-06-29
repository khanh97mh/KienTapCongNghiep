package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.TaskAssignmentJpaRepository;
import com.tma.tlab.api.model.TaskAssignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class TaskAssignmentRepositoryImpl extends ResourceRepositoryBase<TaskAssignment, Long> implements TaskAssignmentRepository {

	@Autowired
	private TaskAssignmentJpaRepository jpaRepository;

	public TaskAssignmentRepositoryImpl() {
		super(TaskAssignment.class);
	}

	@Override
	public ResourceList<TaskAssignment> findAll(QuerySpec querySpec) {
		ResourceList<TaskAssignment> list = new DefaultResourceList<TaskAssignment>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<TaskAssignment> taskAssignments = jpaRepository.findAll();
		querySpec.apply(taskAssignments, list);
		return list;
	}

	@Override
	public TaskAssignment save(TaskAssignment obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		TaskAssignment obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}