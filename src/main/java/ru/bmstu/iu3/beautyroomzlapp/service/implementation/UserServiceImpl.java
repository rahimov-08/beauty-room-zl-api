package ru.bmstu.iu3.beautyroomzlapp.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.bmstu.iu3.beautyroomzlapp.model.Privilege;
import ru.bmstu.iu3.beautyroomzlapp.model.Status;
import ru.bmstu.iu3.beautyroomzlapp.model.User;
import ru.bmstu.iu3.beautyroomzlapp.repository.PrivilegeRepository;
import ru.bmstu.iu3.beautyroomzlapp.repository.UserRepository;
import ru.bmstu.iu3.beautyroomzlapp.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PrivilegeRepository privilegeRepository;
    private final BCryptPasswordEncoder passwordEncoder;



    public UserServiceImpl(UserRepository userRepository, PrivilegeRepository privilegeRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.privilegeRepository = privilegeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Privilege privilegeUser = privilegeRepository.findByName("USER");
        List<Privilege> privileges = new ArrayList<>();
        privileges.add(privilegeUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPrivileges(privileges);
        user.setStatus(Status.ACTIVE);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {

        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null){
            //TODO
        }
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
