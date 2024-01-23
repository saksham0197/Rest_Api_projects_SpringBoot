package com.rest_api.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest_api.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Serializable> {  
	
	     

}
