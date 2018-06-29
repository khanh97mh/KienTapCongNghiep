package com.tma.tlab.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tma.tlab.api.jpa.RoleFunctionJpaRepository;
import com.tma.tlab.api.model.RoleFunction;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class RoleFunctionRepositoryImpl extends ResourceRepositoryBase<RoleFunction, Long> implements RoleFunctionRepository {

	@Autowired
	private RoleFunctionJpaRepository jpaRepository;

	public RoleFunctionRepositoryImpl() {
		super(RoleFunction.class);
	}

	@Override
	public ResourceList<RoleFunction> findAll(QuerySpec querySpec) {
		ResourceList<RoleFunction> list = new DefaultResourceList<RoleFunction>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<RoleFunction> roleFunctions = jpaRepository.findAll();
		querySpec.apply(roleFunctions, list);
		return list;
	}

	@Override
	public RoleFunction save(RoleFunction obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		RoleFunction obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}