package org.example.blogproject.service;

import org.example.blogproject.entity.Blog;
import org.example.blogproject.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAllByAuthorContaining(String name) {
        return blogRepository.findAllByAuthorContaining(name);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public boolean save(Blog blog) {
        return blogRepository.save(blog) != null;
    }


    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public boolean update(Blog blog) {
        if(blogRepository.existsById(blog.getId())){
            blogRepository.save(blog);
            return true;
        }
        return false;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }
}
