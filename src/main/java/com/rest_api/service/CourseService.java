package com.rest_api.service;

import java.util.List;

import com.rest_api.entity.Course;

public interface CourseService {  // 
	
	public String upsert(Course course);  // this method is perform update and insertion
	
	public Course getById(Integer cid); // take id as input and give the particular course
	
	public List<Course> getAllCourses();  // give you all the existing courses
	
	public String deleteById(Integer cid); // take input as id and delete that course
	

}
