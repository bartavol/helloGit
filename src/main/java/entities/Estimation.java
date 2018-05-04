package com.softserver.todolist.entities;

import java.util.List;

public class Estimation {
	private long id;
	private int estimation;
	private int remaining;
	private List<LogWork> logWork;
	
	public Estimation() {
	}

	public Estimation(long id, int estimation, int remaining, List<LogWork> logWork) {
		super();
		this.id = id;
		this.estimation = estimation;
		this.remaining = remaining;
		this.logWork = logWork;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getEstimation() {
		return estimation;
	}

	public void setEstimation(int estimation) {
		this.estimation = estimation;
	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	public List<LogWork> getLogWork() {
		return logWork;
	}

	public void setLogWork(List<LogWork> logWork) {
		this.logWork = logWork;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + estimation;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((logWork == null) ? 0 : logWork.hashCode());
		result = prime * result + remaining;
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
		Estimation other = (Estimation) obj;
		if (estimation != other.estimation)
			return false;
		if (id != other.id)
			return false;
		if (logWork == null) {
			if (other.logWork != null)
				return false;
		} else if (!logWork.equals(other.logWork))
			return false;
		if (remaining != other.remaining)
			return false;
		return true;
	}
	
	
}
