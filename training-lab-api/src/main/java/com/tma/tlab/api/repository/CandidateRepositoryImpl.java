package com.tma.tlab.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tma.tlab.api.jpa.CandidateJpaRepository;
import com.tma.tlab.api.model.Candidate;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class CandidateRepositoryImpl extends ResourceRepositoryBase<Candidate, Long> implements CandidateRepository {

	@Autowired
	private CandidateJpaRepository jpaRepository;

	public CandidateRepositoryImpl() {
		super(Candidate.class);
	}

	@Override
	public ResourceList<Candidate> findAll(QuerySpec querySpec) {
		ResourceList<Candidate> list = new DefaultResourceList<Candidate>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<Candidate> candidates = jpaRepository.findAll();
		querySpec.apply(candidates, list);
		return list;
	}

	@Override
	public Candidate save(Candidate obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		Candidate obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}
