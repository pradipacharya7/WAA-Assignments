package com.lab3.data;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface DataFacade {
	public String findPassword(String name);
	public List<String> getAdvice(String roast);
}
