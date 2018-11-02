package com.nico;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestTheard implements Runnable {
	//代理
	Test test = AopUtil.createProxyObject(Test.class);
	public TestTheard() {
	}

	@Override
	public void run() {
		// 注：这里改成用CGLib来创建目标的代理类实例
		System.out.println("TestTheard:" + Thread.currentThread().getId() + "," + test.print("动漫一周更一集· 哎"));
	}

	public static void main(String[] args) {
		System.out.println("main thread:" + Thread.currentThread().getId());
		System.out.println();

		ExecutorService executorService = Executors.newFixedThreadPool(30);
		for (int i = 0; i < 30; i++) {
			executorService.submit(new TestTheard());
		}
		executorService.shutdown();

	}
}
