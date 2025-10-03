package org.example.blogproject.controller;

import org.example.blogproject.entity.Blog;
import org.example.blogproject.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blog/list";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("detail/{id}")
    public String showDetail(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(name = "searchName") String searchname) {
        ModelAndView mav = new ModelAndView("blog/list");
        if (searchname == null || searchname.trim().isEmpty()) {
            mav.addObject("blogs", blogService.findAll());
        } else {
            mav.addObject("blogs", blogService.findAllByAuthorContaining(searchname));
        }
        return mav;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "id") int id) {
        blogService.delete(blogService.findById(id));
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id , Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute(name = "blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }


}
