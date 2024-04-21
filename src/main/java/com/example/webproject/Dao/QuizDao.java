package com.example.webproject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webproject.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer>{

	

}
