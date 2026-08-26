package com.ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ai.message.Message;
import com.ai.request.OllamaChatRequest;
import com.ai.response.OllamaChatResponse;

@Service
public class AiServices {

	private final RestClient restClient;
	
    private final WebClient webClient;
	
	public AiServices(RestClient restClient, WebClient webClient) {
		this.restClient = restClient;
		this.webClient = webClient;
	}


	public String chat(String prompt) {

		OllamaChatRequest request = new OllamaChatRequest("qwen3", List.of(new Message("user", prompt)), false

		);

		OllamaChatResponse response = restClient.post().uri("/api/chat").body(request).retrieve()
				.body(OllamaChatResponse.class);
		return response.message().content();
	}

	public Message ollamaChat(String prompt) {

		System.out.println("this is from the service to test prompt is :::::::::: " + prompt);

		OllamaChatRequest req = new OllamaChatRequest(
				"qwen3:1.7b",
				List.of(new Message("user", prompt)),
				false
				);
		
		OllamaChatResponse res = restClient
									.post()
									.uri("/api/chat")
									.body(req)
									.retrieve()
									.body(OllamaChatResponse.class);
		
		/*
		 * System.out.println("res was :::: "+ res);
		 * System.out.println("retrive only msg :::: "+ res.message().content());
		 */
		return res.message();

	}
	
	public void ollamaChatStreams(String prompt, SseEmitter emitter) {

	    OllamaChatRequest req = new OllamaChatRequest(
	            "qwen3:1.7b",
	            List.of(new Message("user", prompt)),
	            true
	    );

	    webClient.post()
	            .uri("/api/chat")
	            .bodyValue(req)
	            .retrieve()
	            .bodyToFlux(String.class)
	            .subscribe(
	                    chunk -> {
	                        try {
	                            emitter.send(
	                                    SseEmitter.event()
	                                            .name("message")
	                                            .data(chunk)
	                            );
	                        } catch (Exception e) {
	                            emitter.completeWithError(e);
	                        }
	                    },
	                    error -> emitter.completeWithError(error),
	                    emitter::complete
	            );
	}
}
