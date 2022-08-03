package com.example.myBlogII.appBlog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAllByIsPublished(Boolean isPublished);

}
