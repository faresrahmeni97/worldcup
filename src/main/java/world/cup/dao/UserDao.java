package world.cup.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import world.cup.models.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}