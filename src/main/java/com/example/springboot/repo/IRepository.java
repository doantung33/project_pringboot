package com.example.springboot.repo;

import com.example.springboot.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepository extends CrudRepository<Product,Long> {
    @Query(value = "select * from product where name like ?",nativeQuery = true)
    List<Product>findByName(String name);
}
