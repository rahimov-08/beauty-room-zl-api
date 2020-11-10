package ru.bmstu.iu3.beautyroomzlapp.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.bmstu.iu3.beautyroomzlapp.model.Privilege;
import ru.bmstu.iu3.beautyroomzlapp.model.Status;
import ru.bmstu.iu3.beautyroomzlapp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public JwtUserFactory(){

    }

    public static  JwtUser create(User user){
        return new JwtUser(user.getUser_id(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getStatus().equals(Status.ACTIVE),
                user.getUpdated(),
                mapToGrantedAuthorities(new ArrayList<>(user.getPrivileges())));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Privilege> userPrivileges){
        return userPrivileges.stream()
                .map(privilege ->
                    new SimpleGrantedAuthority(privilege.getName())
                ).collect(Collectors.toList());
    }
}
