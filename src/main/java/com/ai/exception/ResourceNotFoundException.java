package com.ai.exception;

public class ResourceNotFoundException extends RuntimeException	 {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4270400554626984563L;

	// Pass a meaningful error message to the parent RuntimeException class
    public ResourceNotFoundException(String message) {
        super(message);
    }
}