package com.itechart.hris.controller.benefits;

import com.itechart.hris.model.benefits.Department;
import com.itechart.hris.model.benefits.dto.DepartmentDto;
import com.itechart.hris.service.benefits.DepartmentService;
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
public class DepartmentController {
  private final DepartmentService service;

  @Autowired
  public DepartmentController(DepartmentService service) {
    this.service = service;
  }

  @GetMapping
  public List<Department> getAllDepartments() {
    return service.getAll();
  }

  @GetMapping("/{departmentId}")
  public Department getDepartment(@PathVariable("departmentId") Long departmentId) {
    return service.getById(departmentId);
  }

  @PostMapping
  public Department createDepartment(@RequestBody DepartmentDto dto) {
    return service.create(dto);
  }

  @PutMapping("/{departmentId}")
  public Department updateDepartment(
      @PathVariable("departmentId") Long departmentId, @RequestBody DepartmentDto dto) {
    return service.update(departmentId, dto);
  }

  @DeleteMapping("/{departmentId}")
  public void deleteDepartment(@PathVariable("departmentId") Long departmentId) {
    service.delete(departmentId);
  }
}
