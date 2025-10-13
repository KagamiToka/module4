package org.example.cartproject.controller;

import org.example.cartproject.entity.Cart;
import org.example.cartproject.entity.Product;
import org.example.cartproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView shop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id,
                                  @ModelAttribute Cart cart,
                                  @RequestParam(name = "action") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product.get());
        return "redirect:/shop";
    }

    @GetMapping(value = "")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/product/list";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error";
        } else  {
            model.addAttribute("product", product.get());
            return "/product/detail";
        }
    }
}
