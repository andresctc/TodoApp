package com.hardsoft.todoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hardsoft.todoapp.entity.Task;
import com.hardsoft.todoapp.enums.TaskStatus;


public interface TaskRepository extends JpaRepository<Task, Long>{
	
    /**
     * Consulta tipo SpringDataJPA
     * */
	public List<Task> findAllByTaskStatus(TaskStatus taskStatus); 

	/**
	 *Consulta nativa
	 */
	@Modifying
	@Query(value = "UPDATE TASK SET FINISHED=true WHERE ID=id", nativeQuery = true)
	public void markTaskAsFinished(@Param("id") Long id);
}
