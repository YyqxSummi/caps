package sg.iss.caps.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.caps.model.Course;
import sg.iss.caps.repo.CourseRepository;

@Service
public class CourseImpl implements CourseService {

	@Resource
	private CourseRepository courseRepository;
	
	@Override
	@Transactional
	public ArrayList<Course> findAllCourses() {
		// TODO Auto-generated method stub
		ArrayList<Course> l = (ArrayList<Course>) courseRepository.findAll();
		return l;
	}

	@Override
	@Transactional
	public Course findCourse(Integer cid) {
		// TODO Auto-generated method stub
		return courseRepository.findOne(cid);
	}

	@Override
	@Transactional
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.saveAndFlush(course);
	}

	@Override
	@Transactional
	public Course changeCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.saveAndFlush(course);
	}

	@Override
	@Transactional
	public void removeCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.delete(course);

	}

	@Override
	@Transactional
	public ArrayList<Course> findCoursesByCID(String cid) {
		// TODO Auto-generated method stub
		return courseRepository.findCoursesByCID(cid);
	}

	@Override
	@Transactional
	public ArrayList<Course> findCoursesByCNAME(String cname) {
		// TODO Auto-generated method stub
		return courseRepository.findCoursesByCNAME(cname);
	}

	@Override
	@Transactional
	public ArrayList<Course> findCoursesByFACULTY(String faculty) {
		// TODO Auto-generated method stub
		return courseRepository.findCoursesByFACULTY(faculty);
	}

	@Override
	@Transactional
	public ArrayList<Course> findCoursesByCREDITS(String credits) {
		// TODO Auto-generated method stub
		return courseRepository.findCoursesByCREDITS(credits);
	}

	@Override
	@Transactional
	public ArrayList<Course> findCoursesByCSIZE(String csize) {
		// TODO Auto-generated method stub
		return courseRepository.findCoursesByCSIZE(csize);
	}

	@Override
	@Transactional	
	public ArrayList<Course> findCoursesByLSCH(String lsch) {
		// TODO Auto-generated method stub
		return courseRepository.findCoursesByLSCH(lsch);
	}

	@Override
	@Transactional
	public ArrayList<Course> findCoursesBySDATE(String sdate) {
		// TODO Auto-generated method stub
		return courseRepository.findCoursesBySDATE(sdate);
	}

	@Override
	@Transactional
	public ArrayList<Course> findCoursesByEDATE(String edate) {
		// TODO Auto-generated method stub
		return courseRepository.findCoursesByEDATE(edate);
	}

}
