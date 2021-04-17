package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.cup.models.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
}
