package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.RoleJpaRepository;
import com.tma.tlab.api.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class RoleRepositoryImpl extends ResourceRepositoryBase<Role, Long> implements RoleRepository {

	@Autowired
	private RoleJpaRepository jpaRepository;

	public RoleRepositoryImpl() {
		super(Role.class);
	}

	@Override
	public ResourceList<Role> findAll(QuerySpec querySpec) {
		ResourceList<Role> list = new DefaultResourceList<Role>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<Role> roles = jpaRepository.findAll();
		querySpec.apply(roles, list);
		return list;
	}

	@Override
	public Role save(Role obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		Role obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}