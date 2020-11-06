package com.eigenholser.outrider.spdrgld;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SpdrGldRepository extends CrudRepository<SpdrGld, Long> {
	List<SpdrGld> findByDateBetween(LocalDate dateStart, LocalDate dateEnd);

	SpdrGld findByDate(LocalDate date);
}
