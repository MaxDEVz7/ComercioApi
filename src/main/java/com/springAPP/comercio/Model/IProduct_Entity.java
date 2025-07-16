package com.springAPP.comercio.Model;

import com.springAPP.comercio.Model.Entities.Product_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduct_Entity extends JpaRepository<Product_Entity, Integer> {

}