package com.example.pharmacia.service.impl;

import com.example.pharmacia.model.Blog;
import com.example.pharmacia.repository.BlogRepository;
import com.example.pharmacia.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogPosts() {
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
