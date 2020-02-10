package com.itechart.hris.service.benefits.impl;

import com.itechart.hris.model.benefits.Company;
import com.itechart.hris.model.benefits.dto.CompanyDto;
import com.itechart.hris.repository.benefits.CompanyRepository;
import com.itechart.hris.service.benefits.CompanyService;
import com.itechart.hris.service.benefits.CountryService;
import com.itechart.hris.service.benefits.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
  private final CompanyRepository repository;
  private final CountryService countryService;
  private final DepartmentService departmentService;

  @Autowired
  public CompanyServiceImpl(
      CompanyRepository repository,
      @Lazy CountryService countryService,
      @Lazy DepartmentService departmentService) {
    this.repository = repository;
    this.countryService = countryService;
    this.departmentService = departmentService;
  }

  @Override
  public Company getById(Long companyId) {
    Optional<Company> optionalCompany = repository.findById(companyId);
    // TODO throw new ElementNotFoundException() if company is null;
    return optionalCompany.orElse(null);
  }

  @Override
  public List<Company> getAll() {
    return repository.findAll();
  }

  @Override
  public List<Company> getAllById(List<Long> companiesId) {
    return repository.findAllById(companiesId);
  }

  @Override
  public Company create(CompanyDto dto) {
    return repository.save(toCompany(dto));
  }

  @Override
  public Company update(Long companyId, CompanyDto updatedDto) {
    Optional<Company> optionalCompany = repository.findById(companyId);
    if (optionalCompany.isPresent()) {
      Company updatedCompany = toCompany(updatedDto);
      updatedCompany.setId(companyId);
      return repository.save(updatedCompany);
    } else {
      // TODO throw new ElementNotFoundException() if company is null;
      return null;
    }
  }

  @Override
  public void delete(Long companyId) {
    // TODO throw new ElementNotFoundException() if company is null;
    Company company = repository.findById(companyId).orElse(null);
    repository.delete(company);
  }

  private Company toCompany(CompanyDto dto) {
    return Company.builder()
        .name(dto.getName())
        .address(dto.getAddress())
        .country(countryService.getById(dto.getCountryId()))
        .departments(departmentService.getAllById(dto.getDepartmentsId()))
        .build();
  }
}
