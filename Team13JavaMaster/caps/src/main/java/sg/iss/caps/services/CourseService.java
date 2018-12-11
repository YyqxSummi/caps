package sg.iss.caps.services;

import java.util.ArrayList;

import sg.iss.caps.model.Course;

public interface CourseService {
	ArrayList<Course> findAllCourses();

	Course findCourse(Integer cid);
	
	Course createCourse(Course course);

	Course changeCourse(Course course);

	void removeCourse(Course course);

	ArrayList<Course> findCoursesByCID(String cid);

	ArrayList<Course> findCoursesByCNAME(String cname);
	
	ArrayList<Course> findCoursesByFACULTY(String faculty);
	
	ArrayList<Course> findCoursesByCREDITS(String credits);
	
	ArrayList<Course> findCoursesByCSIZE(String csize);
	
	ArrayList<Course> findCoursesByLSCH(String lsch);
	
	ArrayList<Course> findCoursesBySDATE(String sdate);
	
	ArrayList<Course> findCoursesByEDATE(String edate);

}
