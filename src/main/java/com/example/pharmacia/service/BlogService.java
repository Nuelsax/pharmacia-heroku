package com.example.pharmacia.service;

import com.example.pharmacia.model.Blog;
import com.example.pharmacia.model.User;

import java.util.List;

public interface BlogService {
    Blog saveBlog(Blog blog);
    List<Blog> getAllBlogPosts();
}
