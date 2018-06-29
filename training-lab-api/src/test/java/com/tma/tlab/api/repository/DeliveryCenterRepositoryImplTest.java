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

import com.tma.tlab.api.jpa.DeliveryCenterJpaRepository;
import com.tma.tlab.api.model.DeliveryCenter;

@RunWith(MockitoJUnitRunner.class)
public class DeliveryCenterRepositoryImplTest {

	@InjectMocks
	private DeliveryCenterRepositoryImpl repository;

	@Mock
	private DeliveryCenterJpaRepository jpaRepository;

	@Test
	public void testSave() {
		DeliveryCenter deliveryCenter = new DeliveryCenter();
		deliveryCenter.setDeliveryCenterId(1L);
		deliveryCenter.setName("Name");
		deliveryCenter.setDescription("Description");

		repository.save(deliveryCenter);
		ArgumentCaptor<DeliveryCenter> argumentCaptor = ArgumentCaptor.forClass(DeliveryCenter.class);
		verify(jpaRepository).save(argumentCaptor.capture());
		Assert.assertEquals(deliveryCenter, argumentCaptor.getValue());
	}

	@Test
	public void testDelete() {
		DeliveryCenter deliveryCenter = new DeliveryCenter();
		deliveryCenter.setDeliveryCenterId(1L);
		deliveryCenter.setName("Name");
		deliveryCenter.setDescription("Description");
		when(jpaRepository.getOne(1L)).thenReturn(deliveryCenter);
		repository.delete(1L);

		ArgumentCaptor<DeliveryCenter> argumentCaptor = ArgumentCaptor.forClass(DeliveryCenter.class);
		verify(jpaRepository).delete(argumentCaptor.capture());
		Assert.assertEquals(deliveryCenter, argumentCaptor.getValue());
	}

}
