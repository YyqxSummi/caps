package sg.iss.caps.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.caps.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("SELECT c from Course WHERE c.CourseID=:cid")
	ArrayList<Course> findCoursesByCID(@Param("cid") String cid);
	
	@Query("SELECT c from Course WHERE c.CourseName=:cname")
	ArrayList<Course> findCoursesByCNAME(@Param("cname") String cname);
	
	@Query("SELECT c from Course WHERE c.Faculty=:faculty")
	ArrayList<Course> findCoursesByFACULTY(@Param("faculty") String faculty);
	
	@Query("SELECT c from Course WHERE c.Credits=:credits")
	ArrayList<Course> findCoursesByCREDITS(@Param("credits") String credits);
	
	@Query("SELECT c from Course WHERE c.ClassSize=:csize")
	ArrayList<Course> findCoursesByCSIZE(@Param("csize") String csize);
	
	@Query("SELECT c from Course WHERE c.LectureSchedule=:lsch")
	ArrayList<Course> findCoursesByLSCH(@Param("lsch") String lsch);
	
	@Query("SELECT c from Course WHERE c.StartDate=:sdate")
	ArrayList<Course> findCoursesBySDATE(@Param("sdate") String sdate);
	
	@Query("SELECT c from Course WHERE c.EndDate=:edate")
	ArrayList<Course> findCoursesByEDATE(@Param("edate") String edate);

	Course findOne(Integer cid);

}
