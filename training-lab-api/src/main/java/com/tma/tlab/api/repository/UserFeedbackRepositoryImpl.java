package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.UserFeedbackJpaRepository;
import com.tma.tlab.api.model.UserFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class UserFeedbackRepositoryImpl extends ResourceRepositoryBase<UserFeedback, Long> implements UserFeedbackRepository {

	@Autowired
	private UserFeedbackJpaRepository jpaRepository;

	public UserFeedbackRepositoryImpl() {
		super(UserFeedback.class);
	}

	@Override
	public ResourceList<UserFeedback> findAll(QuerySpec querySpec) {
		ResourceList<UserFeedback> list = new DefaultResourceList<UserFeedback>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<UserFeedback> userFeedbacks = jpaRepository.findAll();
		querySpec.apply(userFeedbacks, list);
		return list;
	}

	@Override
	public UserFeedback save(UserFeedback obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		UserFeedback obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}