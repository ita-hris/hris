package com.itechart.hris.service.benefits;

import com.itechart.hris.model.benefits.Department;

import java.util.List;

public interface DepartmentService {
  Department getById(Long departmentId);

  List<Department> getAll();

  Department create(Department department);

  Department update(Long departmentId, Department updatedDepartment);

  void delete(Long departmentId);
}
