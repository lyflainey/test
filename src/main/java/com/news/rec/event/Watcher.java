package com.news.rec.event;

import java.util.Observable;

public class Watcher implements java.util.Observer{

	public void update(Observable o, Object arg) {
		System.out.println("Update() called, count is "      
                + ((Integer) arg).intValue());
	}

}
