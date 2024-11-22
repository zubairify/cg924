package com.zs.exception;

public class StockNotFoundException extends RuntimeException {

	public StockNotFoundException() {
	}

	public StockNotFoundException(String message) {
		super(message);
	}
}
