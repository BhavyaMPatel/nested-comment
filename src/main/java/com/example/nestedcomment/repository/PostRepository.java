package com.example.nestedcomment.repository;

import com.example.nestedcomment.entity.Post;
import com.example.nestedcomment.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findPostsByCreatedBy_Id(int createdById);
}
