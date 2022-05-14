package com.example.myBlogII;

import java.util.List;
import java.util.Map;

public interface BlogService {

    List<Blog> findBogs();

    Blog findBlog(Long blogId);

    Blog createBlog(Map<String, Object> map);

    Blog editBlog(Long blogId, Map<String, Object> map);
}
