package com.news.rec.event;

public class ObserverDemo {
	public static void main(String[] args) {
		System.out.println("1");
		BeingWatched beingWatched = new BeingWatched();// 受查者
		Watcher watcher = new Watcher();// 观察者
		beingWatched.addObserver(watcher);
		beingWatched.counter(10);
		System.out.println("2");
	}
}