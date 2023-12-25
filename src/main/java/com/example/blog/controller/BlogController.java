package com.example.blog.controller;

import com.example.blog.model.Todo;
import com.example.blog.repo.BlogRepo;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogRepo blogRepo;

    @Autowired
    public BlogController(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    @PostMapping("/save")
    public Todo save(@RequestBody Todo blog){
        return blogRepo.save(blog);
    }

    @GetMapping("/{id}")
    public Todo get(@PathVariable int id){
        return blogRepo.findById(id).get();
    }




    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        blogRepo.deleteById(id);
        return "deleted";
    }
}
