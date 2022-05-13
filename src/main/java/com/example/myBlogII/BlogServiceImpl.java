package com.example.myBlogII;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> findBogs(){
        return blogRepository.findAllByIsPublished(true);
    }

    @Override
    public Blog findBlog(Long blogId){
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        Blog blog = optionalBlog.orElseThrow(()-> new RuntimeException("Not found"));
        return blog;
    }

    @Override
    public Blog createBlog(Map<String, Object> map){
        Blog blog = new Blog();
        blog.setTitle(map.get("title").toString());
        blog.setDescription(map.get("description").toString());

        blog.setTimePublished(Date.valueOf(LocalDate.now()));
        blog.setPublished(true);
        return blog;
    }

    @Override
    public Blog editBlog(Long blogId, Map<String, Object> map){
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        Blog blog = optionalBlog.orElseThrow(()-> new RuntimeException("Not found"));
        blog.setTitle(map.get("title").toString());
        blog.setDescription(map.get("description").toString());
        return blog;
    }
}
