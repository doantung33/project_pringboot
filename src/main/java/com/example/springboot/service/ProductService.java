package com.example.springboot.service;

import com.example.springboot.model.Product;
import com.example.springboot.repo.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IRepository iRepository;
    @Override
    public List<Product> findAll() {
        return (List<Product>) iRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return iRepository.findById(id).get();
    }

    @Override
    public void save(Product product) {
        iRepository.save(product);
    }

    @Override
    public void remote(long id) {
        iRepository.deleteById(id);
    }

    @Override
    public List<Product> search(String name) {
        return iRepository.findByName(name);
    }


}
