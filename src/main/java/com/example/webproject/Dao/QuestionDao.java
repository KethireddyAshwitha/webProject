package com.example.webproject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.webproject.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>
{
	List<Question>findQuestionsBycategory(String category);
	
	//@Query(value="select *from question s where s.id=:id ", nativeQuery=true)
	
	@Query(value = "select * from question q where q.category=:category ORDER By RANDOM() Limit :numq ",nativeQuery=true)
	
	List<Question>findRandomQuestionsBycategory(String category,int numq);

	@Query(value ="select *from question q where q.id=:id ",nativeQuery=true)
	String findrightansById(int id);
	
	
}
