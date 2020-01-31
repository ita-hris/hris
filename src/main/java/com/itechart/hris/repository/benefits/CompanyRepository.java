package com.itechart.hris.repository.benefits;

import com.itechart.hris.model.benefits.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {}
