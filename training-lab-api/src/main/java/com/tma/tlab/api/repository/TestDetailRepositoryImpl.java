package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.TestDetailJpaRepository;
import com.tma.tlab.api.model.TestDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class TestDetailRepositoryImpl extends ResourceRepositoryBase<TestDetail, Long> implements TestDetailRepository {

	@Autowired
	private TestDetailJpaRepository jpaRepository;

	public TestDetailRepositoryImpl() {
		super(TestDetail.class);
	}

	@Override
	public ResourceList<TestDetail> findAll(QuerySpec querySpec) {
		ResourceList<TestDetail> list = new DefaultResourceList<TestDetail>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<TestDetail> testDetails = jpaRepository.findAll();
		querySpec.apply(testDetails, list);
		return list;
	}

	@Override
	public TestDetail save(TestDetail obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		TestDetail obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}