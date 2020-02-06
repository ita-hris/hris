package com.itechart.hris.controller.benefits;

import com.itechart.hris.model.benefits.Company;
import com.itechart.hris.model.benefits.dto.CompanyDto;
import com.itechart.hris.service.benefits.CompanyService;
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
@RequestMapping(value = "/benefits/companies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {
  private final CompanyService service;

  @Autowired
  public CompanyController(CompanyService service) {
    this.service = service;
  }

  @GetMapping
  public List<Company> getAllCompanies() {
    return service.getAll();
  }

  @GetMapping("/{companyId}")
  public Company getCompany(@PathVariable("companyId") Long companyId) {
    return service.getById(companyId);
  }

  @PostMapping
  public Company createCompany(@RequestBody CompanyDto dto) {
    return service.create(dto);
  }

  @PutMapping("/{companyId}")
  public Company updateCompany(
      @PathVariable("companyId") Long companyId, @RequestBody CompanyDto dto) {
    return service.update(companyId, dto);
  }

  @DeleteMapping("/{companyId}")
  public void deleteCompany(@PathVariable("companyId") Long companyId) {
    service.delete(companyId);
  }
}
