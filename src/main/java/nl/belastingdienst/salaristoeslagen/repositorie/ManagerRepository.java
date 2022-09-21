package nl.belastingdienst.salaristoeslagen.repositorie;

import nl.belastingdienst.salaristoeslagen.models.Employee;
import nl.belastingdienst.salaristoeslagen.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;


public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
