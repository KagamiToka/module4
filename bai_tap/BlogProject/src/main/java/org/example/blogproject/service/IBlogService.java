package org.example.blogproject.service;

import org.example.blogproject.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAllByAuthorContaining(String name);
    List<Blog> findAll();
    boolean save(Blog blog);
    void delete(Blog blog);
    boolean update(Blog blog);
    Blog findById(int id);
}
