package com.example.webproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webproject.model.QuestionWrapper;
import com.example.webproject.model.Response;
import com.example.webproject.service.QuizService;

@RestController
@RequestMapping("Quiz")
public class QuizController
{
	@Autowired
	QuizService qservice;
	
	@PostMapping("create")
	public ResponseEntity<String>createquiz(@RequestParam String category,
			Integer numq, String title)
	{
		return qservice.createquiz(category,numq,title);
		
	}
	
	
	
	@GetMapping("get")
	public List<QuestionWrapper> displayquestion(@RequestParam Integer id)
	{
		System.out.println("questionwrapper");
		return qservice.displayans(id);
	}
	
	
	
	@PostMapping("submit")
	public Integer submitquiz(@RequestParam Integer id,@RequestBody List<Response> responses)
	{
		return qservice.submitquiz(id,responses);
		
	}
}
