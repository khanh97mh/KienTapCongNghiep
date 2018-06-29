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

import com.tma.tlab.api.jpa.FunctionJpaRepository;
import com.tma.tlab.api.model.Function;


@RunWith(MockitoJUnitRunner.class)
public class FunctionRepositoryImplTest {

	@InjectMocks
	private FunctionRepositoryImpl repository;
	
	@Mock
	private FunctionJpaRepository jpaRepository;
	
	@Test
	public void testSave() {
		Function function = new Function();
		function.setFunctionId("ID");
		function.setName("Name");

		repository.save(function);
		ArgumentCaptor<Function> argumentCaptor = ArgumentCaptor.forClass(Function.class);
		verify(jpaRepository).save(argumentCaptor.capture());
		Assert.assertEquals(function, argumentCaptor.getValue());
	}
	@Test
	public void testDelete() {
		Function function = new Function();
		function.setFunctionId("ID");
		function.setName("Name");
		when(jpaRepository.getOne(1L)).thenReturn(function);
		repository.delete(1L);

		ArgumentCaptor<Function> argumentCaptor = ArgumentCaptor.forClass(Function.class);
		verify(jpaRepository).delete(argumentCaptor.capture());
		Assert.assertEquals(function, argumentCaptor.getValue());
	}

}
