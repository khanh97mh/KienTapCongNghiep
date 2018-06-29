package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.CsvCandidateJpaRepository;
import com.tma.tlab.api.model.CsvCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class CsvCandidateRepositoryImpl extends ResourceRepositoryBase<CsvCandidate, Long> implements CsvCandidateRepository {

	@Autowired
	private CsvCandidateJpaRepository jpaRepository;

	public CsvCandidateRepositoryImpl() {
		super(CsvCandidate.class);
	}

	@Override
	public ResourceList<CsvCandidate> findAll(QuerySpec querySpec) {
		ResourceList<CsvCandidate> list = new DefaultResourceList<CsvCandidate>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<CsvCandidate> csvCandidates = jpaRepository.findAll();
		querySpec.apply(csvCandidates, list);
		return list;
	}

	@Override
	public CsvCandidate save(CsvCandidate obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		CsvCandidate obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}