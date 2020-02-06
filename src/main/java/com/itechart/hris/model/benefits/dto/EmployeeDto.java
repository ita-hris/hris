package com.itechart.hris.model.benefits.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
  private String firstName;
  private String lastName;
  private String email;
  private Long departmentId;
  private Long companyId;
}
