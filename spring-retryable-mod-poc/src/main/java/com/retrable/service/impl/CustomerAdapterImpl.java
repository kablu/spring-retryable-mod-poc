package com.retrable.service.impl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.retrable.controller.exception.ServiceNotAvailableException;
import com.retrable.iservice.ICustomerAdapter;

@Service
public class CustomerAdapterImpl implements ICustomerAdapter{

	Logger log = LoggerFactory.getLogger(CustomerAdapterImpl.class);
	
	@Override
	public String getFallBackResponse(RuntimeException re) {
		 log.info("All retries completed, so Fallback method called!!!");
		 log.info("Exception Is:" + re.getMessage());
	        return "All retries completed, so Fallback method called!!!";
	}

	@Override
	public String getProductResponse(boolean retrySimulate, boolean retryFallbackSimulate) {
		if(retrySimulate) {
			System.out.println("Simulate Retry is true,trying to simulate exception scenario");
			
			if(retryFallbackSimulate) {
				throw new ServiceNotAvailableException("Fallback is simulated");
			}
			
			int random = new Random().nextInt(4);
			 
            System.out.println("Random Number : " + random);
            if (random % 2 == 0) {
                throw new ServiceNotAvailableException("Don't worry!! Just Simulated for Spring-retry..");
            }
		}
		return "Hello From Product Service! I am up..";
	}
	
	
}
