package ru.bmstu.iu3.beautyroomzlapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.iu3.beautyroomzlapp.model.User;

import javax.jws.soap.SOAPBinding;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
