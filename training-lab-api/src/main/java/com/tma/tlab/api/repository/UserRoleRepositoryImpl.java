package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.UserRoleJpaRepository;
import com.tma.tlab.api.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class UserRoleRepositoryImpl extends ResourceRepositoryBase<UserRole, Long> implements UserRoleRepository {

	@Autowired
	private UserRoleJpaRepository jpaRepository;

	public UserRoleRepositoryImpl() {
		super(UserRole.class);
	}

	@Override
	public ResourceList<UserRole> findAll(QuerySpec querySpec) {
		ResourceList<UserRole> list = new DefaultResourceList<UserRole>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<UserRole> userRoles = jpaRepository.findAll();
		querySpec.apply(userRoles, list);
		return list;
	}

	@Override
	public UserRole save(UserRole obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		UserRole obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}