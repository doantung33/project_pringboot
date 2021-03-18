package com.example.springboot.repo;

import com.example.springboot.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface IRepoCategory extends CrudRepository<Category,Long> {
}
