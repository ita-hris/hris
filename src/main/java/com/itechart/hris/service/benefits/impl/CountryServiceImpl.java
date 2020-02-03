package com.itechart.hris.service.benefits.impl;

import com.itechart.hris.model.benefits.Country;
import com.itechart.hris.repository.benefits.CountryRepository;
import com.itechart.hris.service.benefits.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
  private CountryRepository repository;

  @Autowired
  public CountryServiceImpl(CountryRepository repository) {
    this.repository = repository;
  }

  @Override
  public Country getById(Long countryId) {
    Optional<Country> optionalCountry = repository.findById(countryId);
    // TODO throw new ElementNotFoundException() if country is null;
    return optionalCountry.orElse(null);
  }

  @Override
  public List<Country> getAll() {
    return repository.findAll();
  }

  @Override
  public Country create(Country country) {
    return repository.save(country);
  }

  @Override
  public Country update(Long countryId, Country updatedCountry) {
    Optional<Country> optionalCountry = repository.findById(countryId);
    if (optionalCountry.isPresent()) {
      updatedCountry.setId(countryId);
      return repository.save(updatedCountry);
    } else {
      // TODO throw new ElementNotFoundException() if country is null;
      return null;
    }
  }

  @Override
  public void delete(Long countryId) {
    // TODO throw new ElementNotFoundException() if country is null;
    Country country = repository.findById(countryId).orElse(null);
    repository.delete(country);
  }
}
