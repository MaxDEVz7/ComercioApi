package com.springAPP.comercio.Controller;

import com.springAPP.comercio.Business.Roules.Registrations;
import com.springAPP.comercio.Business.Roules.Stock;
import com.springAPP.comercio.Business.Utils.Find;
import com.springAPP.comercio.Model.Entities.Product_Entity;
import com.springAPP.comercio.Model.Entities.Sallers_Entity;
import com.springAPP.comercio.Model.Entities.Suppliers_Entity;
import com.springAPP.comercio.Model.DTO.DtoMovimentoEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
// Esta anotation é usada para demonstrar que esta classe é um controlador do tipo REST. Ou seja, esta classe é responsável por lidar com as requisições HTTP.
// APIs REST são APIs que seguem o padrão REST (Representational State Transfer). Este padrão é baseado em 6 princípios:
//São eles:
// 1. Cliente-Servidor: O cliente e o servidor são separados, o que significa que eles podem ser desenvolvidos e evoluídos independentemente.
// 2. Stateless: Cada requisição do cliente para o servidor deve conter todas as informações necessárias para que o servidor entenda e responda a ela. O servidor não deve manter nenhuma informação sobre o estado do cliente.
// 3. Cache: O servidor deve indicar se as respostas podem ser armazenadas em cache ou não.
// 4. Interface Uniforme: A interface entre o cliente e o servidor deve ser uniforme, o que significa que todas as requisições devem seguir o mesmo padrão.
// 5. Sistema em camadas: O cliente não precisa saber se está se comunicando diretamente com o servidor ou com um intermediário.
// 6. Código sob demanda: O servidor pode enviar código executável para o cliente, que pode ser executado no cliente.

//Também temos APIs do tipo StateFull, que são APIs que mantêm o estado do cliente no servidor. Isso significa que o servidor mantém informações sobre o estado do cliente e pode usá-las para responder a requisições futuras.
// APIs REST são mais comuns do que APIs StateFull, pois são mais simples de implementar e escalar.

@RequestMapping("/api")
@CrossOrigin("*")
public class controller {

    @Autowired
    private Stock stock;
    @Autowired
    private Registrations registrations;
    @Autowired
    public Find find;

    @GetMapping("/Products")
    List<Product_Entity> AllProducts() {
        return find.findAllProducts();
    }

    @GetMapping("/Sallers")
        public List<Sallers_Entity> AllSallers() {
            return find.findAllSallers();
        }

    @GetMapping("/Suppliers")
        public List<Suppliers_Entity> AllSuppliers() {
            return find.findAllSuppliers();
        }

    @PostMapping("/saveSaller")
        public Sallers_Entity saveSaller(@RequestBody Sallers_Entity saller) {
            return (registrations.saveSaller(saller));
        }

    @PostMapping("/saveProduct")
        public Product_Entity saveProduct(@RequestBody Product_Entity product) {
            return (registrations.saveProduct(product));
        }

    @PostMapping("/saveSupplier")
        public Suppliers_Entity saveSupplier(@RequestBody Suppliers_Entity suppliersEntity) {
            return (registrations.saveSupplier(suppliersEntity));
        }

    @GetMapping("/Saller/{id}")
        public Sallers_Entity findByIdSallers(@PathVariable Integer id) {
            return find.findByIdSallers(id);
        }

    @GetMapping("/Supplier/{id}")
        public Suppliers_Entity findByIdSuppliers(@PathVariable Integer id) {
            return find.findByIdSuppliers(id);
        }

    @PostMapping("/MovimentarEstoque")
        public void MovimentoDeEstoque(@RequestBody DtoMovimentoEstoque dtoMovimentoEstoque){
            System.out.println("encontrou produto: " + dtoMovimentoEstoque.getIdProduct() + "\nquantidade movimentada: " + dtoMovimentoEstoque.getQuantMov() + "Tipo Movimento: " + dtoMovimentoEstoque.getTipMov());
            stock.MovimentoEstoque(dtoMovimentoEstoque.getIdProduct(), dtoMovimentoEstoque.getQuantMov(), dtoMovimentoEstoque.getTipMov());
        }


}