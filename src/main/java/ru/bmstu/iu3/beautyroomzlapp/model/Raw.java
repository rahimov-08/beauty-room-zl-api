package ru.bmstu.iu3.beautyroomzlapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "raw")
public class Raw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raw_id")
    private Long raw_id;

    @Column(name = "name")
    private String name;

    @Column(name = "supplier_id")
    private Long supplier_id;

    @Column(name = "balance")
    private int balance;
}
