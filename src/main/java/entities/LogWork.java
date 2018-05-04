package com.softserver.todolist.entities;

import java.util.Date;

public class LogWork {
	private long id;
	private String logDescription;
	private Date createdDate;
	private long userId;
	private int commitLog;
	private long estimationId;
	
	public LogWork() {
	}

	public LogWork(long id, String logDescription, Date createdDate, long userId, int commitLog, long estimationId) {
		super();
		this.id = id;
		this.logDescription = logDescription;
		this.createdDate = createdDate;
		this.userId = userId;
		this.commitLog = commitLog;
		this.estimationId = estimationId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogDescription() {
		return logDescription;
	}

	public void setLogDescription(String logDescription) {
		this.logDescription = logDescription;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getCommitLog() {
		return commitLog;
	}

	public void setCommitLog(int commitLog) {
		this.commitLog = commitLog;
	}

	public long getEstimationId() {
		return estimationId;
	}

	public void setEstimationId(long estimationId) {
		this.estimationId = estimationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commitLog;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (int) (estimationId ^ (estimationId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((logDescription == null) ? 0 : logDescription.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogWork other = (LogWork) obj;
		if (commitLog != other.commitLog)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (estimationId != other.estimationId)
			return false;
		if (id != other.id)
			return false;
		if (logDescription == null) {
			if (other.logDescription != null)
				return false;
		} else if (!logDescription.equals(other.logDescription))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}
