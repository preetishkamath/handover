package com.programmingfree.model;

public class ChangeTrackerCompleted {
	private int idchangetracker;
	private String changeticket;
	private String changedate;
	private String affectedsystem;
	private String affectedsoftware;
	private String starttime;
	private String endtime;
	private String actionforbridge;
	private String oots;
	private String status;
	public int getIdchangetracker() {
		return idchangetracker;
	}
	public void setIdchangetracker(int idchangetracker) {
		this.idchangetracker = idchangetracker;
	}
	public String getChangeticket() {
		return changeticket;
	}
	public void setChangeticket(String changeticket) {
		this.changeticket = changeticket;
	}
	public String getChangedate() {
		return changedate;
	}
	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}
	public String getAffectedsystem() {
		return affectedsystem;
	}
	public void setAffectedsystem(String affectedsystem) {
		this.affectedsystem = affectedsystem;
	}
	public String getAffectedsoftware() {
		return affectedsoftware;
	}
	public void setAffectedsoftware(String affectedsoftware) {
		this.affectedsoftware = affectedsoftware;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getActionforbridge() {
		return actionforbridge;
	}
	public void setActionforbridge(String actionforbridge) {
		this.actionforbridge = actionforbridge;
	}
	public String getOots() {
		return oots;
	}
	public void setOots(String oots) {
		this.oots = oots;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ChangeTrackerCompleted [idchangetracker=" + idchangetracker
				+ ", changeticket=" + changeticket + ", changedate="
				+ changedate + ", affectedsystem=" + affectedsystem
				+ ", affectedsoftware=" + affectedsoftware + ", starttime="
				+ starttime + ", endtime=" + endtime + ", actionforbridge="
				+ actionforbridge + ", oots=" + oots + ", status=" + status
				+ "]";
	}
	
	
	
	
	
}
