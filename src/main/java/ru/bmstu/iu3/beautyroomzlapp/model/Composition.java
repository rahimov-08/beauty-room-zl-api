package ru.bmstu.iu3.beautyroomzlapp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "composition")
@Data
public class Composition {

    @Column(name = "raw_id")
    private Long raw_id;

    @Column(name = "product_id")
    private Long product_id;
}
