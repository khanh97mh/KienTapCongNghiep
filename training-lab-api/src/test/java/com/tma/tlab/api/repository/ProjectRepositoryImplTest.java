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

import com.tma.tlab.api.jpa.ProjectJpaRepository;
import com.tma.tlab.api.model.Project;


@RunWith(MockitoJUnitRunner.class)
public class ProjectRepositoryImplTest {

	@InjectMocks
	private ProjectRepositoryImpl repository;
	
	@Mock
	private ProjectJpaRepository jpaRepository;
	
	@Test
	public void testSave() {
		Project project = new Project();
		project.setProjectId(1L);
		project.setDescription("Description");
		project.setName("Name");

		repository.save(project);
		ArgumentCaptor<Project> argumentCaptor = ArgumentCaptor.forClass(Project.class);
		verify(jpaRepository).save(argumentCaptor.capture());
		Assert.assertEquals(project, argumentCaptor.getValue());
	}
	@Test
	public void testDelete() {
		Project project = new Project();
		project.setProjectId(1L);
		project.setDescription("Description");
		project.setName("Name");
		
		when(jpaRepository.getOne(1L)).thenReturn(project);
		repository.delete(1L);

		ArgumentCaptor<Project> argumentCaptor = ArgumentCaptor.forClass(Project.class);
		verify(jpaRepository).delete(argumentCaptor.capture());
		Assert.assertEquals(project, argumentCaptor.getValue());
	}

}
