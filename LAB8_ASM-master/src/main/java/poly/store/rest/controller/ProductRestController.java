package poly.store.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import poly.store.entity.Product;
import poly.store.service.ProductService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getAll() {
        return productService.findAll();
    }
    @RequestMapping("user")
    public String getUser(Authentication auth) {
        if (auth==null){
            return null;
        }else {
            return auth.getName();
        }
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        System.out.println("sssssssssssssssssss");
        return productService.create(product);
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id")Integer id){
        return productService.findById(id);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable("id") Integer id,@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
         productService.delete(id);
    }
}
