package com.itechart.hris.service.benefits.impl;

import com.itechart.hris.model.benefits.Country;
import com.itechart.hris.model.benefits.dto.CountryDto;
import com.itechart.hris.repository.benefits.CountryRepository;
import com.itechart.hris.service.benefits.CompanyService;
import com.itechart.hris.service.benefits.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
  private final CountryRepository repository;
  private final CompanyService companyService;

  @Autowired
  public CountryServiceImpl(CountryRepository repository, @Lazy CompanyService companyService) {
    this.repository = repository;
    this.companyService = companyService;
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
  public Country create(CountryDto dto) {
    return repository.save(toCountry(dto));
  }

  @Override
  public Country update(Long countryId, CountryDto updatedDto) {
    Optional<Country> optionalCountry = repository.findById(countryId);
    if (optionalCountry.isPresent()) {
      Country updatedCountry = toCountry(updatedDto);
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

  private Country toCountry(CountryDto dto) {
    return Country.builder()
        .name(dto.getName())
        .companies(companyService.getAllById(dto.getCompaniesId()))
        .build();
  }
}
