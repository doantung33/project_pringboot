package com.example.springboot.service;

import com.example.springboot.model.Category;
import com.example.springboot.model.Product;
import com.example.springboot.repo.IRepoCategory;
import com.example.springboot.repo.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private IRepoCategory iRepoCategory;

    @Override
    public List<Category> findAll() {
        return (List<Category>) iRepoCategory.findAll();
    }

    @Override
    public Category findById(long id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void remote(long id) {

    }

    @Override
    public List<Product> search(String name) {
        return null;
    }
}
