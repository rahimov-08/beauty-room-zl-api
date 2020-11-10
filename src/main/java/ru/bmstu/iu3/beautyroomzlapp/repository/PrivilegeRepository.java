package ru.bmstu.iu3.beautyroomzlapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.iu3.beautyroomzlapp.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
    Privilege findByName(String name);
}
