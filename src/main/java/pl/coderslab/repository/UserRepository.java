package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
