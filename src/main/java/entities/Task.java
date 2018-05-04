package com.softserver.todolist.entities;

import java.util.List;

public class Task {
	private long id;
	private String name;
	private Status status;
	private long parentId;
	private long ownerId;
	private Priorety priorety;
	private List<Comment> comment;
	private long workerId;
	private Estimation estimation;
	
	
	
	public Task() {
	}

	public Task(long id, String name, Status status, long parentId, long ownerId, Priorety priorety,
			List<Comment> comment, long workerId, Estimation estimation) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.parentId = parentId;
		this.ownerId = ownerId;
		this.priorety = priorety;
		this.comment = comment;
		this.workerId = workerId;
		this.estimation = estimation;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public Priorety getPriorety() {
		return priorety;
	}
	public void setPriorety(Priorety priorety) {
		this.priorety = priorety;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(long workerId) {
		this.workerId = workerId;
	}
	public Estimation getEstimation() {
		return estimation;
	}
	public void setEstimation(Estimation estimation) {
		this.estimation = estimation;
	}
	
	
}
