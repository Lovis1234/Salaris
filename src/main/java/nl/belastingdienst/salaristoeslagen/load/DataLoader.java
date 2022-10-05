package nl.belastingdienst.salaristoeslagen.load;

import nl.belastingdienst.salaristoeslagen.models.Company;
import nl.belastingdienst.salaristoeslagen.models.Employee;
import nl.belastingdienst.salaristoeslagen.repositorie.CompanyRepository;
import nl.belastingdienst.salaristoeslagen.repositorie.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader {
    EmployeeRepository employeeRepository;
    CompanyRepository companyRepository;

    public DataLoader(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        load();
    }

    private void load(){

        Company company = new Company(1001L,"Tax and Customs Administration",null);
        Company returnCompany = companyRepository.save(company);
        Employee employee = new Employee(1001L,"Stan","Kuipers", LocalDate.now(),"Wolvega",21,89,"Zuiderpark 11",1,returnCompany);
        employeeRepository.save(employee);
    }
}
