package com.akash.careerspring.company.impl;

import com.akash.careerspring.company.Company;
import com.akash.careerspring.company.CompanyRepository;
import com.akash.careerspring.company.CompanyService;
import com.akash.careerspring.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Boolean updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company foundCompany = companyOptional.get();
            companyRepository.save(getUpdatedCompany(updatedCompany, foundCompany));
            return true;
        }
        return false;
    }

    private Company getUpdatedCompany(Company updatedCompany, Company company) {
        company.setName(updatedCompany.getName());
        company.setDescription(updatedCompany.getDescription());
        company.setJobs(updatedCompany.getJobs());

        return company;
    }
}
