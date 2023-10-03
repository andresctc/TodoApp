package com.hardsoft.todoapp.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.hardsoft.todoapp.entity.Task;
import com.hardsoft.todoapp.enums.TaskStatus;
import com.hardsoft.todoapp.model.TaskInDTO;

@Component
public class TaskInDTO2Task implements IMapper<TaskInDTO, Task> {

	@Override
	public Task map(TaskInDTO in) {
		Task task = new Task();
		task.setTitle(in.getTitle());
		task.setDescription(in.getDescription());
		task.setEta(in.getEta());
		task.setCreatedDate(LocalDateTime.now());
		task.setFinished(false);
		task.setTaskStatus(TaskStatus.ON_TIME);
		return task;
	}
	
}
