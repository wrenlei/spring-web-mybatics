package com.sl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sl.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/get")
	@ResponseBody
	public void get() {
		 testService.addA();
	}
	
	@RequestMapping("/get2")
	@ResponseBody
	public void get2() throws Exception {
		testService.addB();
	}
}
