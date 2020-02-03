package com.itechart.hris.service.benefits;

import com.itechart.hris.model.benefits.Country;

import java.util.List;

public interface CountryService {
  Country getById(Long countryId);

  List<Country> getAll();

  Country create(Country country);

  Country update(Long countryId, Country updatedCountry);

  void delete(Long countryId);
}
