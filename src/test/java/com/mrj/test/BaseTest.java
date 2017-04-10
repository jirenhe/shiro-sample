package com.mrj.test;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {
		"classpath:test/spring/spring.xml"})
//@TransactionConfiguration(defaultRollback = true)  
//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTest {

}
