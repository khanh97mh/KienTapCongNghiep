package com.tma.tlab.api.repository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tma.tlab.api.e.EnumQuestion;
import com.tma.tlab.api.e.EnumQuestionChoice;
import com.tma.tlab.api.e.EnumQuestionType;
import com.tma.tlab.api.jpa.QuestionChoiceJpaRepository;
import com.tma.tlab.api.model.QuestionChoice;


@RunWith(MockitoJUnitRunner.class)
public class QuestionChoiceRepositoryImplTest {

	@InjectMocks
	private QuestionChoiceRepositoryImpl repository;
	
	@Mock
	private QuestionChoiceJpaRepository jpaRepository;
	
	@Test
	public void testSave() {
		QuestionChoice questionChoice = new QuestionChoice();
		questionChoice.setChoiceId(1L);
		questionChoice.setDescription("Description");
		questionChoice.setCorrected(EnumQuestionChoice.Y);
		questionChoice.setFillIn("FillIn");

		repository.save(questionChoice);
		ArgumentCaptor<QuestionChoice> argumentCaptor = ArgumentCaptor.forClass(QuestionChoice.class);
		verify(jpaRepository).save(argumentCaptor.capture());
		Assert.assertEquals(questionChoice, argumentCaptor.getValue());
	}
	@Test
	public void testDelete() {
		QuestionChoice questionChoice = new QuestionChoice();
		questionChoice.setChoiceId(1L);
		questionChoice.setDescription("Description");
		questionChoice.setCorrected(EnumQuestionChoice.Y);
		questionChoice.setFillIn("FillIn");
		
		when(jpaRepository.getOne(1L)).thenReturn(questionChoice);
		repository.delete(1L);

		ArgumentCaptor<QuestionChoice> argumentCaptor = ArgumentCaptor.forClass(QuestionChoice.class);
		verify(jpaRepository).delete(argumentCaptor.capture());
		Assert.assertEquals(questionChoice, argumentCaptor.getValue());
	}

}
