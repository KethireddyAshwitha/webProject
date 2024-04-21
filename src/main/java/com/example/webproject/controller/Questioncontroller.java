package com.example.webproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webproject.model.Question;
import com.example.webproject.service.Questionservice;




@RestController
public class Questioncontroller 
{
	@Autowired
	Questionservice qservice;
	
	
	
	@GetMapping("the")
	public String method()
	{
		System.out.println("hlooo");
		return "hlo world java";
	}
	
	@GetMapping("questions")
	public ResponseEntity<List<Question>>getallquestions()
	{
		System.out.println("allquestions");
		return qservice.allquestions();
	}

	
	
	@GetMapping("category/{cat}")
	public ResponseEntity<List<Question>>category(@PathVariable("cat") String category)
	{
		return qservice.category(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<Question> add(@RequestBody Question question)
	{
		System.out.println("add method");
		return qservice.add(question);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity <String>delete(@PathVariable int id )
	{
		 return  qservice.delete(id);
		 
	}
	
	@PutMapping("update")
	public String updatedata(@RequestBody Question question)
	{
		 qservice.change(question);
		 return "success";
		
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Question>> getbyid(@PathVariable int id)
	{
		return qservice.allbyid(id);
	}
	
	
}


