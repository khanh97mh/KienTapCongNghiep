package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.UserTestResultJpaRepository;
import com.tma.tlab.api.model.UserTestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class UserTestResultRepositoryImpl extends ResourceRepositoryBase<UserTestResult, Long> implements UserTestResultRepository {

	@Autowired
	private UserTestResultJpaRepository jpaRepository;

	public UserTestResultRepositoryImpl() {
		super(UserTestResult.class);
	}

	@Override
	public ResourceList<UserTestResult> findAll(QuerySpec querySpec) {
		ResourceList<UserTestResult> list = new DefaultResourceList<UserTestResult>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<UserTestResult> userTestResults = jpaRepository.findAll();
		querySpec.apply(userTestResults, list);
		return list;
	}

	@Override
	public UserTestResult save(UserTestResult obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		UserTestResult obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}