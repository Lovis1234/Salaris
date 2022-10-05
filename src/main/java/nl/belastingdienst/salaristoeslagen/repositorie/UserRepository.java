package nl.belastingdienst.salaristoeslagen.repositorie;

import nl.belastingdienst.salaristoeslagen.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
