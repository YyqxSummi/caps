package sg.iss.caps.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.caps.model.Course;
import sg.iss.caps.model.Student;
import sg.iss.caps.model.Studentcourse;
import sg.iss.caps.services.CourseService;
import sg.iss.caps.services.StudentCourseService;

@Controller
@RequestMapping(value = "/CourseAll")

public class CourseController {

	@Autowired
	private CourseService cService;
	@Autowired
	private StudentCourseService scService;

	/**
	 * 选课
	 * 
	 * @param request
	 * @param va
	 * @param course
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "save")
	public String save(HttpServletRequest request, String cid, ArrayList<Course> course,ArrayList<Studentcourse> scourse) throws Exception {
		Integer csize;
		course = cService.findCoursesByCID(cid);
		scourse= scService.findEnrolledCoursesByStatus(cid);
        
		/*have bug 目的：如果选了超过容量的课，给提示+appeal*/
		if ((course.findCoursesByCSIZE(csize)- scourse.size())<= 0) {
			request.setAttribute("message", "The number of students in the course has reached the upper limit, you can appeal with the admin or choose other available courses");
		    //return scourse;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Student student = (Student) request.getSession().getAttribute("student");
		String id1 = student.getStudentID();
		map.put("id", id1);
		List<Studentcourse> findlist = (List<Studentcourse>) cService.findCourse(map);
		
		for (Studentcourse course2 : findlist) {
			if (course2.getCourseIndex().equals(((StudentCourseService) scourse).getCourseIndex())
					&& course2.getEnrollTime().equals(((StudentCourseService) scourse).getEnrollTime())) {
				request.setAttribute("message","You have selected course and no need to select again.");

				//return allcourse(request, coursetype);
			}
		}
		
		cService.updateCourse(course);
		Student s = (Student) request.getSession().getAttribute("student");
		scourse.getStudents().add(s);
//courseService.save(course);//插入课程到数据库（要先将外键表插入）
		request.setAttribute("message", "添加信息成功");
		//return allcourse(request, coursetype);
	}

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		// binder.setValidator(studentValidator);
	}

	/* list all courses */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("CourseOperation");
		ArrayList<Course> courses = cService.findAllCourses();
		mav.addObject("courses", courses);
		return mav;
	}

}
