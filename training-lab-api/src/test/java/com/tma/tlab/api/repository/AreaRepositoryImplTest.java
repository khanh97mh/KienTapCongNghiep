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

import com.tma.tlab.api.jpa.AreaJpaRepository;
import com.tma.tlab.api.model.Area;


@RunWith(MockitoJUnitRunner.class)
public class AreaRepositoryImplTest {

	@InjectMocks
	private AreaRepositoryImpl repository;
	
	@Mock
	private AreaJpaRepository jpaRepository;
	
	@Test
	public void testSave() {
		Area area = new Area();
		area.setAreaId(1L);
		area.setDescription("Area");

		repository.save(area);
		ArgumentCaptor<Area> argumentCaptor = ArgumentCaptor.forClass(Area.class);
		verify(jpaRepository).save(argumentCaptor.capture());
		Assert.assertEquals(area, argumentCaptor.getValue());
	}
	@Test
	public void testDelete() {
		Area area = new Area();
		area.setAreaId(1L);
		area.setDescription("Area");
		when(jpaRepository.getOne(1L)).thenReturn(area);
		repository.delete(1L);

		ArgumentCaptor<Area> argumentCaptor = ArgumentCaptor.forClass(Area.class);
		verify(jpaRepository).delete(argumentCaptor.capture());
		Assert.assertEquals(area, argumentCaptor.getValue());
	}

}
