package com.programmingfree.model;

	public class User {

		private int hid;
		private String datere;
		private String mailfrom;	
		private String subject;
		private String summary;
		private String response;
		private String oots;
		private String status;
		
		public int getHid() {
			return hid;
		}
		public void setHid(int hid) {
			this.hid = hid;
		}
		public String getDatere() {
			return datere;
		}
		public void setDatere(String datere) {
			this.datere = datere;
		}
		public String getMailfrom() {
			return mailfrom;
		}
		public void setMailfrom(String mailfrom) {
			this.mailfrom = mailfrom;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
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
			return "User [hid=" + hid + ", datere=" + datere + ", mailfrom="
					+ mailfrom + ", subject=" + subject + ", summary="
					+ summary + ", response=" + response + ", oots=" + oots
					+ ", status=" + status + "]";
		}
		
	
		
		
	}

