package com.retrable.iservice;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import com.retrable.controller.exception.ServiceNotAvailableException;

public interface ICustomerAdapter {

	@Retryable(value = {ServiceNotAvailableException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public String getProductResponse(boolean retrySimulate, boolean retryFallbackSimulate);
	
	@Recover
	public String getFallBackResponse(RuntimeException re);
}
