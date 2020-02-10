package com.itechart.hris.service.benefits;

import com.itechart.hris.model.benefits.Department;
import com.itechart.hris.model.benefits.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
  Department getById(Long departmentId);

  List<Department> getAll();

  List<Department> getAllById(List<Long> departmentsId);

  Department create(DepartmentDto dto);

  Department update(Long departmentId, DepartmentDto updatedDto);

  void delete(Long departmentId);
}
