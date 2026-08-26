package com.ai.request;

import java.util.List;

import com.ai.message.Message;

public record OllamaChatRequest(
		 String model,
	        List<Message> messages,
	        boolean stream
		) {

}
