package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

import com.example.demo.model.Task;

@Repository
public interface TaskRepo extends MongoRepository<Task, String>{
    void deleteByTitle(String title);
    Optional<List<Task>> findByCompleted(boolean completed);
}
