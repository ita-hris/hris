package com.itechart.hris.service.benefits;

import com.itechart.hris.model.benefits.Company;
import com.itechart.hris.model.benefits.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
  Company getById(Long companyId);

  List<Company> getAll();

  List<Company> getAllById(List<Long> companiesId);

  Company create(CompanyDto dto);

  Company update(Long companyId, CompanyDto updatedDto);

  void delete(Long companyId);
}
