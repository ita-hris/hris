package com.itechart.hris.model.benefits;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;
  private String lastName;
  private String email;

  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;
}
