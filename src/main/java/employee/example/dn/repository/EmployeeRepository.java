package employee.example.dn.repository;

import employee.example.dn.dto.EmployeeDto;
import employee.example.dn.entity.EmployeeUser;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeUser, Long>{
    Optional<EmployeeUser> findByUsername(String username);

    Optional<EmployeeUser> findById(long id);

    boolean existsByUsername(String username);

}
