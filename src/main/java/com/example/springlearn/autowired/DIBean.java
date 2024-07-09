package com.example.springlearn.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // Bean으로 만들기
public class DIBean {
	@Qualifier("implBean1")
	@Autowired
	private final MyInterface myInterface;

	@Autowired
	// 오토와이어링할 수 없습니다. 'MyInterface' 타입의 bean을 찾을 수 없습니다. 뜨는 이유?
	public DIBean(MyInterface myInterface) {
		this.myInterface = myInterface;
	}

	public void executeTask() {
		myInterface.doSomething();
	}

	public static void main(String[] args) {
		DIBean diBean = new DIBean(new ImplBean1());
		diBean.executeTask();
	}
}