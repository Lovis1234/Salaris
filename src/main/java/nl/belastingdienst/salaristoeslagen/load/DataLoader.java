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
        Employee employee = new Employee(1001L,"Stan","Kuipers", LocalDate.now(),"Zuiderpark 11","Wolvega",89,69.11,1,1);
        Company company = new Company(1001L,"Tax and Customs Administration");
        companyRepository.save(company);
        employeeRepository.save(employee);
    }
}
