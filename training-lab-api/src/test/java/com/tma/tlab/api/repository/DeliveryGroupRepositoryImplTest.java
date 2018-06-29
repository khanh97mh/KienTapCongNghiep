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

import com.tma.tlab.api.jpa.DeliveryGroupJpaRepository;
import com.tma.tlab.api.model.DeliveryGroup;


@RunWith(MockitoJUnitRunner.class)
public class DeliveryGroupRepositoryImplTest {

	@InjectMocks
	private DeliveryGroupRepositoryImpl repository;
	
	@Mock
	private DeliveryGroupJpaRepository jpaRepository;
	
	@Test
	public void testSave() {
		DeliveryGroup deliveryGroup = new DeliveryGroup();
		deliveryGroup.setDeliveryGroupId(1L);
		deliveryGroup.setDescription("Description");
		deliveryGroup.setName("Name");

		repository.save(deliveryGroup);
		ArgumentCaptor<DeliveryGroup> argumentCaptor = ArgumentCaptor.forClass(DeliveryGroup.class);
		verify(jpaRepository).save(argumentCaptor.capture());
		Assert.assertEquals(deliveryGroup, argumentCaptor.getValue());
	}
	@Test
	public void testDelete() {
		DeliveryGroup deliveryGroup = new DeliveryGroup();
		deliveryGroup.setDeliveryGroupId(1L);
		deliveryGroup.setDescription("Description");
		deliveryGroup.setName("Name");
		when(jpaRepository.getOne(1L)).thenReturn(deliveryGroup);
		repository.delete(1L);

		ArgumentCaptor<DeliveryGroup> argumentCaptor = ArgumentCaptor.forClass(DeliveryGroup.class);
		verify(jpaRepository).delete(argumentCaptor.capture());
		Assert.assertEquals(deliveryGroup, argumentCaptor.getValue());
	}

}
