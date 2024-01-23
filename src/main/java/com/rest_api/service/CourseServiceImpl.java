package com.rest_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api.entity.Course;
import com.rest_api.repo.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;   // yha humne course repository ko autowired krdia to hum ab jpa k methods use krlenge

	@Override
	public String upsert(Course course) {
		courseRepo.save(course);
		return "success";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course> findById = courseRepo.findById(cid);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		if(courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Delete Success";
		}else {
			return "No Record Found";			
		}
		
	}



}
