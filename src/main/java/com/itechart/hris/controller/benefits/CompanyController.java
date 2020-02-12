package com.itechart.hris.controller.benefits;

import com.itechart.hris.model.benefits.Company;
import com.itechart.hris.model.benefits.dto.CompanyDto;
import com.itechart.hris.service.benefits.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Company controller", description = "CRUD operations with companies")
public class CompanyController {
  private final CompanyService service;

  @Autowired
  public CompanyController(CompanyService service) {
    this.service = service;
  }

  @GetMapping
  @ApiOperation(value = "Get a list of companies")
  public List<Company> getAllCompanies() {
    return service.getAll();
  }

  @GetMapping("/{companyId}")
  @ApiOperation(value = "Get a company by id")
  public Company getCompany(@PathVariable("companyId") Long companyId) {
    return service.getById(companyId);
  }

  @PostMapping
  @ApiOperation(value = "Create a new company")
  public Company createCompany(@RequestBody CompanyDto dto) {
    return service.create(dto);
  }

  @PutMapping("/{companyId}")
  @ApiOperation(value = "Update a company")
  public Company updateCompany(
      @PathVariable("companyId") Long companyId, @RequestBody CompanyDto dto) {
    return service.update(companyId, dto);
  }

  @DeleteMapping("/{companyId}")
  @ApiOperation(value = "Delete a company")
  public void deleteCompany(@PathVariable("companyId") Long companyId) {
    service.delete(companyId);
  }
}
