package com.itechart.hris.repository.benefits;

import com.itechart.hris.model.benefits.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {}
