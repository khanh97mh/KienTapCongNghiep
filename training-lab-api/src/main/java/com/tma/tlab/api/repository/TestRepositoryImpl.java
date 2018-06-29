package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.TestJpaRepository;
import com.tma.tlab.api.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class TestRepositoryImpl extends ResourceRepositoryBase<Test, Long> implements TestRepository {

	@Autowired
	private TestJpaRepository jpaRepository;

	public TestRepositoryImpl() {
		super(Test.class);
	}

	@Override
	public ResourceList<Test> findAll(QuerySpec querySpec) {
		ResourceList<Test> list = new DefaultResourceList<Test>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<Test> tests = jpaRepository.findAll();
		querySpec.apply(tests, list);
		return list;
	}

	@Override
	public Test save(Test obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		Test obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}