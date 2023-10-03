package com.hardsoft.todoapp.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardsoft.todoapp.entity.Task;
import com.hardsoft.todoapp.enums.TaskStatus;
import com.hardsoft.todoapp.model.TaskInDTO;
import com.hardsoft.todoapp.service.TaskService;



@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	private final TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
	
    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
    	return this.taskService.createTask(taskInDTO);
    }
    
    @GetMapping
    public List<Task> findAll(){
    	return this.taskService.findAll();
    }
    
    @GetMapping("/status/{status}")
    public List<Task> findByStatus(@PathVariable("status") TaskStatus status){
    	return this.taskService.findTaskByStatus(status);
    }
	
    @PatchMapping("/mark_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
    	this.taskService.updateTaskAsFinished(id);
    	return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
    	this.taskService.deleteById(id);
    	return ResponseEntity.noContent().build();
    }
        
}
