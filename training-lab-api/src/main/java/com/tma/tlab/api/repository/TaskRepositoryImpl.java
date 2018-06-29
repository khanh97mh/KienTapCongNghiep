package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.TaskJpaRepository;
import com.tma.tlab.api.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class TaskRepositoryImpl extends ResourceRepositoryBase<Task, Long> implements TaskRepository {

	@Autowired
	private TaskJpaRepository jpaRepository;

	public TaskRepositoryImpl() {
		super(Task.class);
	}

	@Override
	public ResourceList<Task> findAll(QuerySpec querySpec) {
		ResourceList<Task> list = new DefaultResourceList<Task>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<Task> tasks = jpaRepository.findAll();
		querySpec.apply(tasks, list);
		return list;
	}

	@Override
	public Task save(Task obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		Task obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}