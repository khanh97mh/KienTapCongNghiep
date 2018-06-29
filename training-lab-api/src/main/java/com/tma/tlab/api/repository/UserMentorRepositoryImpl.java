package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.UserMentorJpaRepository;
import com.tma.tlab.api.model.UserMentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class UserMentorRepositoryImpl extends ResourceRepositoryBase<UserMentor, Long> implements UserMentorRepository {

	@Autowired
	private UserMentorJpaRepository jpaRepository;

	public UserMentorRepositoryImpl() {
		super(UserMentor.class);
	}

	@Override
	public ResourceList<UserMentor> findAll(QuerySpec querySpec) {
		ResourceList<UserMentor> list = new DefaultResourceList<UserMentor>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<UserMentor> userMentors = jpaRepository.findAll();
		querySpec.apply(userMentors, list);
		return list;
	}

	@Override
	public UserMentor save(UserMentor obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		UserMentor obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}