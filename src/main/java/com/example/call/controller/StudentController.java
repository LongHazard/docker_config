package com.example.call.controller;

import com.example.call.entity.Student;
import com.example.call.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
  @Autowired
  private StudentRepository repository;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Student student){
    return ResponseEntity.ok().body(repository.save(student));
  }

  @GetMapping("test")
  public ResponseEntity<?> get(){
    return ResponseEntity.ok().body("Xin chào Văn Long");
  }

  @GetMapping
  public ResponseEntity<?> getAll(){
    return ResponseEntity.ok().body(repository.findAll());
  }

  @GetMapping("find/{id}")
  public ResponseEntity<?> findById(@PathVariable(name = "id") Long id){
    return ResponseEntity.ok().body(repository.findById(id));
  }
}
