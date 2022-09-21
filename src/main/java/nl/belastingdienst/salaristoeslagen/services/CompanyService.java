package nl.belastingdienst.salaristoeslagen.services;

import nl.belastingdienst.salaristoeslagen.dto.CompanyDto;
import nl.belastingdienst.salaristoeslagen.exception.RecordNotFoundException;
import nl.belastingdienst.salaristoeslagen.models.Company;
import nl.belastingdienst.salaristoeslagen.repositorie.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyDto> getAllCompanys() {
        List<Company> companys = companyRepository.findAll();
        List<CompanyDto> companyDtos = new ArrayList<>();
        for(Company company : companys){
            companyDtos.add(fromCompany(company));
        }
        return companyDtos;
    }
    public CompanyDto getCompanyById(Long id) {
        Optional<Company> CompanyOptional = companyRepository.findById(id);
        if (!CompanyOptional.isPresent()) {
            throw new RecordNotFoundException("Company not found");
        } else {
            Company company = CompanyOptional.get();
            CompanyDto companyDto = fromCompany(company);
            return companyDto;
        }
    }
    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = toCompany(companyDto);
        Company newCompany = companyRepository.save(company);
        CompanyDto dto = fromCompany(newCompany);
        return dto;

    }
    

    private CompanyDto fromCompany(Company company){
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        return companyDto;
    }

    private Company toCompany(CompanyDto companyDto){
        Company company = new Company();
        company.setId(company.getId());
        company.setName(companyDto.getName());
        return company;
    }
    }

