package com.retrable.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retrable.iservice.ICustomerAdapter;

@RestController
public class CustomerController {

	Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	ICustomerAdapter iCustomerAdapter;
	
	@GetMapping("/retry")
	@ExceptionHandler({Exception.class})
	public String validateSpringRetry(@RequestParam boolean retrySimulate,
			@RequestParam boolean retrySimulateFallback) {
		
		log.info("======================================");
		log.info("validateSpringRetry");
		return iCustomerAdapter.getProductResponse(retrySimulate, retrySimulateFallback);
	}
}
