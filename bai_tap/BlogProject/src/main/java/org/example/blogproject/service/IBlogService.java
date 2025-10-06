package org.example.blogproject.service;

import org.example.blogproject.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAllByAuthorContaining(String name);
    List<Blog> findAll();
    Page<Blog> findAll(String name, Pageable pageable);
    boolean save(Blog blog);
    void delete(Blog blog);
    boolean update(Blog blog);
    Blog findById(int id);
}
