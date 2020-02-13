package com.itechart.hris.controller.benefits;

import com.itechart.hris.model.benefits.Department;
import com.itechart.hris.model.benefits.dto.DepartmentDto;
import com.itechart.hris.service.benefits.DepartmentService;
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
@RequestMapping(value = "/benefits/departments", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Department controller", description = "CRUD operations with departments")
public class DepartmentController {
  private final DepartmentService service;

  @Autowired
  public DepartmentController(DepartmentService service) {
    this.service = service;
  }

  @GetMapping
  @ApiOperation(value = "Get a list of departments")
  public List<Department> getAllDepartments() {
    return service.getAll();
  }

  @GetMapping("/{departmentId}")
  @ApiOperation(value = "Get a department by id")
  public Department getDepartment(@PathVariable("departmentId") Long departmentId) {
    return service.getById(departmentId);
  }

  @PostMapping
  @ApiOperation(value = "Create a new department")
  public Department createDepartment(@RequestBody DepartmentDto dto) {
    return service.create(dto);
  }

  @PutMapping("/{departmentId}")
  @ApiOperation(value = "Update a department")
  public Department updateDepartment(
      @PathVariable("departmentId") Long departmentId, @RequestBody DepartmentDto dto) {
    return service.update(departmentId, dto);
  }

  @DeleteMapping("/{departmentId}")
  @ApiOperation(value = "Delete a department")
  public void deleteDepartment(@PathVariable("departmentId") Long departmentId) {
    service.delete(departmentId);
  }
}
