package com.itechart.hris.service.benefits;

import com.itechart.hris.model.benefits.Company;

import java.util.List;

public interface CompanyService {
  Company getById(Long companyId);

  List<Company> getAll();

  Company create(Company company);

  Company update(Long companyId, Company updatedCompany);

  void delete(Long companyId);
}
