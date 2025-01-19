package com.vodapally.service;

import com.vodapally.dto.Product;
import com.vodapally.exception.DuplicateProductException;
import com.vodapally.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

    // list of products
    List<Product> productList = Stream.of(
            new Product("PTC49893", "Mobile", 9500, "SAMSUNG Galaxy F13 (Sunrise Copper, 64 GB)", "Electronics"),
            new Product("PTC25563", "Keyboard", 9500, "MAC Magic Keyboard", "Electronics"),
            new Product("PTC25372", "Books", 250, "It Ends With Us", "Education"),
            new Product("PTC49823", "Remote Control Toys", 699, "Wembley High Speed Mini 1:24 Scale Rechargeable Remote Control car with Lithium Battery", "Baby&Kids")
    ).collect(Collectors.toList());

    public List<Product> getProducts(){
        return productList;
    }

    public List<Product> saveProduct(Product product){
        //uncomment to test @AfterThrowing aspect
//        if(product.getId().length()<3){
//            throw new RuntimeException("Enter product id > 3");
//        }
        //System.out.println("Product Service...id : "+product.getId());
        boolean containsProductId = productList.stream()
                .map(Product::getId)
                .anyMatch(productId -> productId.equals(product.getId()));

        if(!containsProductId)
            productList.add(product);
        else
            throw new DuplicateProductException("Product code already exists in the system : "+product.getId());

        return productList;
    }

    public List<Product> getProductByType(String productType){
        List<Product> products = productList.stream()
                .filter(product -> product.getProductType().equals(productType))
                .collect(Collectors.toList());

        return Optional.of(products)
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new ProductNotFoundException("Products not available for the type "+productType));
    }
}
