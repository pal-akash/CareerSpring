package com.akash.careerspring.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    //Company getCompanyById(Long id);

    Boolean updateCompany(Company company, Long id);

    void createCompany(Company company);
}
