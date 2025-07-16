package com.springAPP.comercio.Business.Roules;

import com.springAPP.comercio.Business.Utils.Find;
import com.springAPP.comercio.Model.Entities.Product_Entity;
import com.springAPP.comercio.Model.IProduct_Entity;
import com.springAPP.comercio.Model.ISallers_Entity;
import com.springAPP.comercio.Model.ISuppliers_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Stock {
    @Autowired
    IProduct_Entity iProductEntity;
    @Autowired
    ISallers_Entity iSallersEntity;
    @Autowired
    ISuppliers_Entity iSuppliersEntity;
    @Autowired
    public Find find;

    public ResponseEntity<Product_Entity> MovimentoEstoque(Integer idProduct, Integer quantidadeMovimentada, char tipMov){

        Product_Entity product = find.findByIdProduct(idProduct);
        if(product.getQuantidadeEstoque() == null){
            product.setQuantidadeEstoque(0);
        }

        if (tipMov == 'V'){
            product.setQuantidadeEstoque(product.getQuantidadeEstoque() - quantidadeMovimentada);
            iProductEntity.save(product);
            System.out.println("Estoque movimentado");
        } else if (tipMov == 'C') {
            product.setQuantidadeEstoque(product.getQuantidadeEstoque() + quantidadeMovimentada);
            iProductEntity.save(product);
            System.out.println("Estoque movimentado");
        }else {
            return ResponseEntity.status(400).body(product);
        }
        return ResponseEntity.status(200).body(product);
    }
}
