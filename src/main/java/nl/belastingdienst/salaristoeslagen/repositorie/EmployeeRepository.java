package nl.belastingdienst.salaristoeslagen.repositorie;

import nl.belastingdienst.salaristoeslagen.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
