package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.TaskTemplateJpaRepository;
import com.tma.tlab.api.model.TaskTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class TaskTemplateRepositoryImpl extends ResourceRepositoryBase<TaskTemplate, Long> implements TaskTemplateRepository {

	@Autowired
	private TaskTemplateJpaRepository jpaRepository;

	public TaskTemplateRepositoryImpl() {
		super(TaskTemplate.class);
	}

	@Override
	public ResourceList<TaskTemplate> findAll(QuerySpec querySpec) {
		ResourceList<TaskTemplate> list = new DefaultResourceList<TaskTemplate>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<TaskTemplate> taskTemplates = jpaRepository.findAll();
		querySpec.apply(taskTemplates, list);
		return list;
	}

	@Override
	public TaskTemplate save(TaskTemplate obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		TaskTemplate obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}