package com.example.blog_app.repository;

import com.example.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findBlogByAuthorContaining(String author, Pageable pageable);


    // tự định nghĩa bằng câu truy vấn:
    @Query(value = "select * from blog join ecommerce where blog.e_commerce_id = ecommerce.id and ecommerce.id = :id",nativeQuery = true)
    Page<Blog> findAllBlogByECommerceId(@Param("id") int id, Pageable pageable);

}
