package com.hardsoft.todoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hardsoft.todoapp.entity.Task;
import com.hardsoft.todoapp.enums.TaskStatus;
import com.hardsoft.todoapp.exceptions.ToDoExceptions;
import com.hardsoft.todoapp.mapper.TaskInDTO2Task;
import com.hardsoft.todoapp.model.TaskInDTO;
import com.hardsoft.todoapp.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskService {

	private final TaskRepository repository;
	private final TaskInDTO2Task taskMapper;

    TaskService(TaskRepository repository, TaskInDTO2Task taskMapper) {
        this.repository = repository;
		this.taskMapper = taskMapper;
    }
    
    public Task createTask(TaskInDTO taskInDTO) {
    	Task task = taskMapper.map(taskInDTO);
    	return this.repository.save(task);
    }
    
    public List<Task> findAll(){
    	return this.repository.findAll();
    }
    
    public List<Task> findTaskByStatus(TaskStatus taskStatus){
    	return this.repository.findAllByTaskStatus(taskStatus);
    }
    
    @Transactional
    public void updateTaskAsFinished(Long id) {
    	Optional<Task> optionalTask = this.repository.findById(id);
    	if(optionalTask.isEmpty()) {
    		throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
    	}
    	this.repository.markTaskAsFinished(id);
    }
    
    public void deleteById(Long id) {
    	Optional<Task> optionalTask = this.repository.findById(id);
    	if(optionalTask.isEmpty()) {
    		throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
    	}
    	this.repository.deleteById(id);
    }

}
