package com.kayamuhammet.ToDo.repository;

import com.kayamuhammet.ToDo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByCategory(String category);
    List<ToDo> findByCompletedTrue();
}
