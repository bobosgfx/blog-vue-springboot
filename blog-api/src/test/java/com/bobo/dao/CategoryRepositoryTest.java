package com.bobo.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bobo.BlogApiApplicationTests;
import com.bobo.repository.CategoryRepository;

public class CategoryRepositoryTest extends BlogApiApplicationTests{

	@Autowired
	private CategoryRepository	categoryRepository;

	@Test
	public void test() {
	}
}
