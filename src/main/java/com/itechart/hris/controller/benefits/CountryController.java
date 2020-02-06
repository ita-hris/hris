package com.itechart.hris.controller.benefits;

import com.itechart.hris.model.benefits.Country;
import com.itechart.hris.model.benefits.dto.CountryDto;
import com.itechart.hris.service.benefits.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/benefits/countries", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {
  private final CountryService service;

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
  public Country createCountry(@RequestBody CountryDto dto) {
    return service.create(dto);
  }

  @PutMapping("/{countryId}")
  public Country updateCountry(
      @PathVariable("countryId") Long countryId, @RequestBody CountryDto dto) {
    return service.update(countryId, dto);
  }

  @DeleteMapping("/{countryId}")
  public void deleteCountry(@PathVariable("countryId") Long countryId) {
    service.delete(countryId);
  }
}
