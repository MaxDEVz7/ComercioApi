package com.springAPP.comercio.Model.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Sallers")

public class Sallers_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "saller", length = 255, nullable = false)
    private String saller;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "phone", length = 16, nullable = false)
    private String phone;

    @Column(name = "cnpj", length = 18, nullable = true)
    private String cnpj;

    @Column(name = "cpf", length = 14, nullable = true)
    private String cpf;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSaller() {
        return saller;
    }

    public void setSaller(String saller) {
        this.saller = saller;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
