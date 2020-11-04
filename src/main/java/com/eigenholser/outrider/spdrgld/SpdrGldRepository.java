package com.eigenholser.outrider.spdrgld;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SpdrGldRepository extends CrudRepository<SpdrGld, Long> {
	List<SpdrGld> findByDateBetween(Date dateStart, Date dateEnd);

	SpdrGld findByDate(Date date);
}
