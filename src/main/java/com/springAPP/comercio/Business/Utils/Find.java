package com.springAPP.comercio.Business.Utils;

import com.springAPP.comercio.Model.Entities.Product_Entity;
import com.springAPP.comercio.Model.Entities.Sallers_Entity;
import com.springAPP.comercio.Model.Entities.Suppliers_Entity;
import com.springAPP.comercio.Model.IProduct_Entity;
import com.springAPP.comercio.Model.ISallers_Entity;
import com.springAPP.comercio.Model.ISuppliers_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Find {

    @Autowired
    IProduct_Entity iProductEntity;
    @Autowired
    ISallers_Entity iSallersEntity;
    @Autowired
    ISuppliers_Entity iSuppliersEntity;

    public Product_Entity findByIdProduct(Integer id) {
        return iProductEntity.findById(id).get();
    }

    public Sallers_Entity findByIdSallers(Integer id) {
        return iSallersEntity.findById(id).get();
    }

    public Suppliers_Entity findByIdSuppliers(Integer id) {
        return iSuppliersEntity.findById(id).get();
    }


    public List<Product_Entity> findAllProducts() {
        return iProductEntity.findAll();
    }

    public List<Sallers_Entity> findAllSallers() {
        return iSallersEntity.findAll();
    }

    public List<Suppliers_Entity> findAllSuppliers() {
        return iSuppliersEntity.findAll();
    }
}


