package com.example.webproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.webproject.Dao.QuestionDao;
import com.example.webproject.Dao.QuizDao;

import com.example.webproject.model.Question;
import com.example.webproject.model.QuestionWrapper;
import com.example.webproject.model.Quiz;
import com.example.webproject.model.Response;


@Service
public class QuizService {

	@Autowired
	QuestionDao questiondao;
	
	@Autowired
	QuizDao quizdao;
	
	
	public ResponseEntity<String> createquiz(String category, int numq, String title)
	{
		List<Question> questions =  questiondao.findRandomQuestionsBycategory(category,numq);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		
		quizdao.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.OK);
	 
	}

	public List<QuestionWrapper> displayans(int id) 
	{
		Optional<Quiz> quiz = quizdao.findById(id);
		List<Question> qfromdb = quiz.get().getQuestion();
		List<QuestionWrapper> qforuser= new ArrayList<>();
		for(Question q:qfromdb)
		{
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2());
			qforuser.add(qw);
		}
		
		return qforuser;
	}

	

	public Integer submitquiz(Integer id, List<Response> responses) 
	{
		Quiz quiz = quizdao.findById(id).get();
		List<Question> qf = quiz.getQuestion();
		int right =0;
		int i =0;
		for(Response response : responses)
		{
			if( response.getRightans().equals(qf.get(i).getRightans()))
			{
				right++;
				i++;
			}
		}
		return right;
	}

	

	

	

}
