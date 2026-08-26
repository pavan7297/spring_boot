package com.ai.response;

import com.ai.message.Message;

public record OllamaChatResponse(
		 String model,
	        Message message,
	        boolean done
		) {

}
