package com.tma.tlab.api.jpa;

import com.tma.tlab.api.model.Area;

public interface AreaJpaRepositoryCustom {
	Iterable<Area> findAllWithDescription(String description);
}
