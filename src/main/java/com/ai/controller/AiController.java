package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ai.message.Message;
import com.ai.service.AiServices;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/ai")
@Slf4j
public class AiController {

	@Autowired
	private AiServices services;
	
//	@Autowired
//	private Logger logger;

	@GetMapping
	public ResponseEntity<?> chatModel(@RequestParam String prompt) {
		try {
			
//			logger.info("The prompt is ::::::::::::: "+ prompt);
			String out = services.chat(prompt);
			return ResponseEntity.accepted().body(out);
		} catch (RuntimeException e) {
//			logger.error("AI request failed", e);
			    return ResponseEntity
			            .internalServerError()
			            .body("AI request failed: " + e.getMessage());		}
	}
	
	@GetMapping("/chat")
	public ResponseEntity<?>  chatWithRestTemplate(@RequestParam String prompt) {
		
		
		try {
//			System.out.println("the hit prompt is ::::::::::: "+prompt);
			Message responseAi = services.ollamaChat(prompt);
//			System.out.println("ai was replyed ::::::: "+ responseAi);
			return ResponseEntity.accepted().body(responseAi);
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e);
		}
	}
	
	@GetMapping(value = "/chats", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter chatWithSteams(@RequestParam String prompt) {

	    SseEmitter emitter = new SseEmitter(0L); // no timeout

	    services.ollamaChatStreams(prompt, emitter);

	    return emitter;
	}
	

}
