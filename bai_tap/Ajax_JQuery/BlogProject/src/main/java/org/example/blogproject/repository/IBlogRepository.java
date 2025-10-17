package org.example.blogproject.repository;

import org.example.blogproject.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByAuthorContaining(String name);
    Page<Blog> findAllByAuthorContaining(String name, Pageable pageable);
}
