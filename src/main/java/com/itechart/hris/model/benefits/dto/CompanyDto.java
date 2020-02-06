package com.itechart.hris.model.benefits.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDto {
  private String name;
  private Long countryId;
  private String address;
  private List<Long> employeesId;
}
