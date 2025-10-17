package org.example.blogproject.service;

import org.example.blogproject.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
