package com.example.webproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.webproject.Dao.QuestionDao;
import com.example.webproject.model.Question;
@Service
public class Questionservice {

	@Autowired
	QuestionDao qrepo;
	
	public ResponseEntity<List<Question>>allquestions()
	{
		try {
		return new ResponseEntity<>(qrepo.findAll(),HttpStatus.ACCEPTED);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.ACCEPTED);
		
	}
	
	public ResponseEntity< Optional<Question>>allbyid(int id)
	{
		try {
		return new ResponseEntity<>(qrepo.findById(id),HttpStatus.ACCEPTED);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>>category(String category)
	{
		try {
		return new ResponseEntity<>(qrepo.findQuestionsBycategory(category),HttpStatus.OK);																																																																																																																																																																																																																							
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Question> add(Question question)
	{
		try {
		 return new ResponseEntity<>(qrepo.save(question),HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	 
	}

	public ResponseEntity<String >delete(int id) 
	{
		qrepo.deleteById(id);
		try {
		return new ResponseEntity<>
		("happened",HttpStatus.ACCEPTED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("gotit",HttpStatus.OK);
		
	}

	public String change(Question question) 
	{
		qrepo.save(question);
		return "updated";
	}

	


	

}
