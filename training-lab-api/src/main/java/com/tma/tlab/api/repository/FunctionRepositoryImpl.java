package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.FunctionJpaRepository;
import com.tma.tlab.api.model.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class FunctionRepositoryImpl extends ResourceRepositoryBase<Function, Long> implements FunctionRepository {

	@Autowired
	private FunctionJpaRepository jpaRepository;

	public FunctionRepositoryImpl() {
		super(Function.class);
	}

	@Override
	public ResourceList<Function> findAll(QuerySpec querySpec) {
		ResourceList<Function> list = new DefaultResourceList<Function>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<Function> functions = jpaRepository.findAll();
		querySpec.apply(functions, list);
		return list;
	}

	@Override
	public Function save(Function obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		Function obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}