package com.mastek.training.hrapp;

public class EmailAnnouncment extends Announcement {

	@Override
	public void sendAnnouncement() {
		System.out.println("Sending Email TO: "+getForGroup()+"By "+getFrom()+
				"with Title:"+getSubject()+"and Text:"+getContentText());
		

	}

}
