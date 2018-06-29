package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.TaskDetailJpaRepository;
import com.tma.tlab.api.model.TaskDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class TaskDetailRepositoryImpl extends ResourceRepositoryBase<TaskDetail, Long> implements TaskDetailRepository {

	@Autowired
	private TaskDetailJpaRepository jpaRepository;

	public TaskDetailRepositoryImpl() {
		super(TaskDetail.class);
	}

	@Override
	public ResourceList<TaskDetail> findAll(QuerySpec querySpec) {
		ResourceList<TaskDetail> list = new DefaultResourceList<TaskDetail>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<TaskDetail> taskDetails = jpaRepository.findAll();
		querySpec.apply(taskDetails, list);
		return list;
	}

	@Override
	public TaskDetail save(TaskDetail obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		TaskDetail obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}