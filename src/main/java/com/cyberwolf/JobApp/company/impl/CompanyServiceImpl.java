package com.cyberwolf.JobApp.company.impl;

import com.cyberwolf.JobApp.company.Company;
import com.cyberwolf.JobApp.company.CompanyRepository;
import com.cyberwolf.JobApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
