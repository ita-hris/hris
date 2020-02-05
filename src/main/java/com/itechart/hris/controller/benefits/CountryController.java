package com.itechart.hris.controller.benefits;

import com.itechart.hris.model.benefits.Country;
import com.itechart.hris.model.benefits.dto.CountryDto;
import com.itechart.hris.service.benefits.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/benefits/countries")
public class CountryController {
  private CountryService service;

  @Autowired
  public CountryController(CountryService service) {
    this.service = service;
  }

  @GetMapping
  public List<Country> getAllCountries() {
    return service.getAll();
  }

  @GetMapping("/{countryId}")
  public Country getCountry(@PathVariable("countryId") Long countryId) {
    return service.getById(countryId);
  }

  @PostMapping
  public Country createCountry(CountryDto dto) {
    return service.create(CountryDto.toCountry(dto));
  }

  @PutMapping("/{countryId}")
  public Country updateCountry(@PathVariable("countryId") Long countryId, CountryDto dto) {
    return service.update(countryId, CountryDto.toCountry(dto));
  }

  @DeleteMapping("/{countryId}")
  public void deleteCountry(@PathVariable("countryId") Long countryId) {
    service.delete(countryId);
  }
}
