package com.example.myBlogII.appBlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> getBlogs(){
        return blogService.findBogs();
    }

    @GetMapping("/{id}")
    public Blog getBlog (@PathVariable Long blogId){
        return blogService.findBlog(blogId);
    }

    @PostMapping("/blog")
    public Blog postBlog (@RequestBody Map<String, Object> map){
        return blogService.createBlog(map);
    }

    @PutMapping("/{id}")
    public Blog putBlog (@PathVariable Long blogId, @RequestBody Map<String, Object> map){
        return blogService.editBlog(blogId, map);
    }


}
