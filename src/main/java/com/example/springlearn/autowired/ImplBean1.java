package com.example.springlearn.autowired;

import org.springframework.stereotype.Component;

@Component
public class ImplBean1 implements MyInterface {
	@Override
	public void doSomething() {
		System.out.println("ImplBean1 is doing something");
	}
}