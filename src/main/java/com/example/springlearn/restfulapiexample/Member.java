package com.example.springlearn.restfulapiexample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member {
	private Long id;
	private String name;
	private String email;
}