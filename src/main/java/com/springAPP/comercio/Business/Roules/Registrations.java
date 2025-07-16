package com.springAPP.comercio.Business.Roules;

import com.springAPP.comercio.Model.Entities.Product_Entity;
import com.springAPP.comercio.Model.Entities.Sallers_Entity;
import com.springAPP.comercio.Model.Entities.Suppliers_Entity;
import com.springAPP.comercio.Model.IProduct_Entity;
import com.springAPP.comercio.Model.ISallers_Entity;
import com.springAPP.comercio.Model.ISuppliers_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Registrations {

    @Autowired
    IProduct_Entity iProductEntity;
    @Autowired
    ISallers_Entity iSallersEntity;
    @Autowired
    ISuppliers_Entity iSuppliersEntity;

    public Sallers_Entity saveSaller(Sallers_Entity saller) {
        return iSallersEntity.save(saller);
    }

    public Product_Entity saveProduct(Product_Entity product) {

        if (product.getQuantidadeEstoque() == null){
            product.setQuantidadeEstoque(0);
        }
        return iProductEntity.save(product);
    }


    public Suppliers_Entity saveSupplier(Suppliers_Entity supplier) {
        if (supplier.getCpf() == null && supplier.getCnpj() == null) {
            throw new IllegalArgumentException("CNPJ or CPF is required");
        }
        if (supplier.getCpf() != null && supplier.getCnpj() != null) {
            throw new IllegalArgumentException("CNPJ and CPF cannot be filled in at the same time");
        }

        return iSuppliersEntity.save(supplier);
    }
}
