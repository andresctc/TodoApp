package com.hardsoft.todoapp.model;

import java.time.LocalDateTime;

public class TaskInDTO {

	private String title;
	private String description;
	private LocalDateTime eta;

	public TaskInDTO() {
		super();
	}

	public TaskInDTO(String title, String description, LocalDateTime eta) {
		super();
		this.title = title;
		this.description = description;
		this.eta = eta;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getEta() {
		return eta;
	}

	public void setEta(LocalDateTime eta) {
		this.eta = eta;
	}

}
