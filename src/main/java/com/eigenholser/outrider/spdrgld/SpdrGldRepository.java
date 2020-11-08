package com.eigenholser.outrider.spdrgld;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface SpdrGldRepository extends CrudRepository<SpdrGld, Long> {
	Page<SpdrGld> findByDateBetween(LocalDate dateStart, LocalDate dateEnd, Pageable pageable);

	SpdrGld findByDate(LocalDate date);
}
