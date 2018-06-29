package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.TaskCategoryJpaRepository;
import com.tma.tlab.api.model.TaskCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class TaskCategoryRepositoryImpl extends ResourceRepositoryBase<TaskCategory, Long> implements TaskCategoryRepository {

	@Autowired
	private TaskCategoryJpaRepository jpaRepository;

	public TaskCategoryRepositoryImpl() {
		super(TaskCategory.class);
	}

	@Override
	public ResourceList<TaskCategory> findAll(QuerySpec querySpec) {
		ResourceList<TaskCategory> list = new DefaultResourceList<TaskCategory>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<TaskCategory> taskCategorys = jpaRepository.findAll();
		querySpec.apply(taskCategorys, list);
		return list;
	}

	@Override
	public TaskCategory save(TaskCategory obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		TaskCategory obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}