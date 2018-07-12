package com.news.rec.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import com.news.rec.task.Calculator;

public class TestTask {

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Future<Integer> result = forkJoinPool.submit(new Calculator(1,100));
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
