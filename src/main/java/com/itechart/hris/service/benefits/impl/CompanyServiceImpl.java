package com.itechart.hris.service.benefits.impl;

import com.itechart.hris.model.benefits.Company;
import com.itechart.hris.repository.benefits.CompanyRepository;
import com.itechart.hris.service.benefits.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
  private CompanyRepository repository;

  @Autowired
  public CompanyServiceImpl(CompanyRepository repository) {
    this.repository = repository;
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
  public Company create(Company company) {
    return repository.save(company);
  }

  @Override
  public Company update(Long companyId, Company updatedCompany) {
    Optional<Company> optionalCompany = repository.findById(companyId);
    if (optionalCompany.isPresent()) {
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
}
