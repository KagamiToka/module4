package org.example.blogproject.controller;

import org.example.blogproject.dto.BlogDto;
import org.example.blogproject.entity.Blog;
import org.example.blogproject.service.IBlogService;
import org.example.blogproject.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);//200
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createBlog(@RequestBody BlogDto blogDto, BindingResult result) {
        Map<String, String> map = new LinkedHashMap<>();
        if (result.hasErrors()) {
            map.put("title","Title not null");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST); //400
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED); //201
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteBlogById(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(blog);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateBlog(@PathVariable("id") int id,
                                        @RequestBody BlogDto blogDto) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
