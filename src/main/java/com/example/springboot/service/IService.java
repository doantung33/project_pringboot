package com.example.springboot.service;

import com.example.springboot.model.Product;

import java.util.List;

public interface IService <T>{
    List<T>findAll();
    T findById(long id);
    void save(T t);
    void remote(long id);
    List<Product>search(String name);


}
