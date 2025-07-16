package com.springAPP.comercio.Model.Entities;

import jakarta.persistence.*;


@Entity
@Table(name = "products") // Esta anotação é usada para indicar o nome da tabela no banco de dados.
public class Product_Entity {

    @Id // Esta anotação é usada para indicar que esta coluna é a chave primária da tabela.
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Esta anotação é usada para indicar que o valor desta coluna é gerado automaticamente pelo banco de dados.
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "product", nullable = false)
    private String product;

    @Column(name = "price", nullable = true)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "supplier", nullable = true)
    private Suppliers_Entity supplier;

    @ManyToOne
    @JoinColumn(name = "saller", nullable = true)
    private Sallers_Entity saller;

    @Column(name = "quantity", nullable = false)
    private Integer quantidadeEstoque;

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Suppliers_Entity getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers_Entity supplier) {
        this.supplier = supplier;
    }

    public Sallers_Entity getSaller() {
        return saller;
    }

    public void setSaller(Sallers_Entity saller) {
        this.saller = saller;
    }

    @Override
    public String toString() {
        return "Produto: " + getProduct() + "Id: " + getId();
    }
}
