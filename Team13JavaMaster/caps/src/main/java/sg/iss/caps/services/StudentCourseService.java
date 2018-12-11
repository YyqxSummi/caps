package sg.iss.caps.services;

import java.util.ArrayList;

import sg.iss.caps.model.Course;
import sg.iss.caps.model.Studentcourse;

public interface StudentCourseService {
	

	Studentcourse createStudentCourse(Studentcourse studentcourse);

	Studentcourse changeStudentCourse(Studentcourse studentcourse);

	void removeCourseEvent(Studentcourse studentcourse);
	
	ArrayList<Studentcourse> findCoursesByCID(Integer cid);
	
	ArrayList<Studentcourse> getCourseIndex();
	
	ArrayList<Studentcourse> findEnrolledCoursesByStatus(String cid);
	
	ArrayList<Studentcourse> findFinishedCoursesByStatus(Integer cid);
	
	ArrayList<Studentcourse> findPendingCoursesByStatus(Integer cid);
	
	ArrayList<Studentcourse> findCancelledCoursesByStatus(Integer cid);
	
	ArrayList<Studentcourse> findEnrollTime();

	



}
