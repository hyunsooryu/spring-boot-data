package me.hyunsoo.artofspringbootdata;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Table;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

}
