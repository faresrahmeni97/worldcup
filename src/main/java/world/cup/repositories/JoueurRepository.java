package world.cup.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.cup.models.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur,Long> {

     //   Optional<Equipe> findByIdAndInstructorId(Long id, Long equipeId);

}
