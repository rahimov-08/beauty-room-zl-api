package ru.bmstu.iu3.beautyroomzlapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "privileges")
@Data
public class Privilege extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "privilege_id")
    private Long privilege_id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
    private List<User> users;

    public Long getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(Long privilege_id) {
        this.privilege_id = privilege_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
