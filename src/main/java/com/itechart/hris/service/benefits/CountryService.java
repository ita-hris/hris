package com.itechart.hris.service.benefits;

import com.itechart.hris.model.benefits.Country;
import com.itechart.hris.model.benefits.dto.CountryDto;

import java.util.List;

public interface CountryService {
  Country getById(Long countryId);

  List<Country> getAll();

  Country create(CountryDto dto);

  Country update(Long countryId, CountryDto updatedDto);

  void delete(Long countryId);
}
