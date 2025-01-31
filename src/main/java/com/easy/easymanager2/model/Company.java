package com.easy.easymanager2.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "dim_companies")
@Entity(name = "Company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
