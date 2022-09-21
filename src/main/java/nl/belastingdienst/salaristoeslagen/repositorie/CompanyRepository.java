package nl.belastingdienst.salaristoeslagen.repositorie;

import nl.belastingdienst.salaristoeslagen.models.Company;
import nl.belastingdienst.salaristoeslagen.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
