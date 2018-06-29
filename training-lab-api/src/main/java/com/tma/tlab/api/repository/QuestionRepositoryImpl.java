package com.tma.tlab.api.repository;

import java.util.List;

import com.tma.tlab.api.jpa.QuestionJpaRepository;
import com.tma.tlab.api.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.links.DefaultPagedLinksInformation;
import io.katharsis.resource.list.DefaultResourceList;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.meta.DefaultPagedMetaInformation;

@Component
public class QuestionRepositoryImpl extends ResourceRepositoryBase<Question, Long> implements QuestionRepository {

	@Autowired
	private QuestionJpaRepository jpaRepository;

	public QuestionRepositoryImpl() {
		super(Question.class);
	}

	@Override
	public ResourceList<Question> findAll(QuerySpec querySpec) {
		ResourceList<Question> list = new DefaultResourceList<Question>(new DefaultPagedMetaInformation(),
				new DefaultPagedLinksInformation());
		List<Question> questions = jpaRepository.findAll();
		querySpec.apply(questions, list);
		return list;
	}

	@Override
	public Question save(Question obj) {
		return jpaRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		Question obj = jpaRepository.getOne(id);
		this.jpaRepository.delete(obj);
	}
}