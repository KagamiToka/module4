package org.example.blogproject.repository;

import org.example.blogproject.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByAuthorContaining(String name);
}
