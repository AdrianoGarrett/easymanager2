package com.easy.easymanager2.model;

import com.easy.easymanager2.record.DadosCadastroCustomer;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Table(name = "dim_customers")
@Entity(name = "Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    private String city;
    private String state;
    private String country;
    private String gender;
    @Column(name = "company_id")
    private int companyId;
    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    public Customer(DadosCadastroCustomer dados) {
        this.firstName = dados.firstName();
        this.lastName = dados.lastName();
        this.email = dados.email();
        this.phoneNumber = Integer.parseInt(dados.phoneNumber().replaceAll("[^\\d]", ""));
        this.city = dados.city();
        this.state = dados.state();
        this.country = dados.country();
        this.gender = dados.gender();
        this.registrationDate = new Date();
        this.companyId = Integer.parseInt(dados.companyId());
    }
}
