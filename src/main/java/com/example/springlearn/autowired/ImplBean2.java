package com.example.springlearn.autowired;

import org.springframework.stereotype.Component;

@Component
public class ImplBean2 implements MyInterface {
	@Override
	public void doSomething() {
		System.out.println("ImplBean2 is doing something");
	}
}