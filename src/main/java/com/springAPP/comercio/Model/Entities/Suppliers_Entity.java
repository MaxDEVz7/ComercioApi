package com.springAPP.comercio.Model.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Suppliers")
public class Suppliers_Entity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "supplier", nullable = false)
    private String supplier;

    @Column(name = "address", nullable = false)
    private String address;


    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "cnpj", length = 18, nullable = true)
    private String cnpj;

    @Column(name = "cpf", length = 14, nullable = true)
    private String cpf;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
