package com.itechart.hris.model.benefits.dto;

import com.itechart.hris.model.benefits.Company;
import com.itechart.hris.model.benefits.Country;

import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDto {
  private String name;
  private Set<Company> companies;

  public static Country toCountry(CountryDto dto) {
    Country country = new Country();
    country.setName(dto.getName());
    country.setCompanies(dto.getCompanies());
    return country;
  }
}
