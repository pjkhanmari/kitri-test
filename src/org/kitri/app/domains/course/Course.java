package org.kitri.app.domains.course;

import java.util.ArrayList;
import java.util.Date;

import org.kitri.app.domains.course.detail.CourseDailyNote;
import org.kitri.app.domains.course.detail.CourseScheduleSheet;
import org.kitri.app.domains.users.Student;
import org.kitri.app.domains.users.Teacher;

public class Course {
	private String id = null;
	private String title = null;
	private Date createdDate = null;
	private Date startDate = null;
	private Date endDate = null;
	private CourseScheduleSheet schedule = null; // 전체 과정 일일 시간표
	private Teacher mainTeacher = null; // 담임 강사
	private ArrayList<Student> students = null; // 학생
	private ArrayList<CourseDailyNote> courseDailyNote = null;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public CourseScheduleSheet getSchedule() {
		return schedule;
	}
	public void setCourseScheduleSheet(CourseScheduleSheet schedule) {
		this.schedule = schedule;
	}
	public Teacher getMainTeacher() {
		return mainTeacher;
	}
	public void setMainTeacher(Teacher mainTeacher) {
		this.mainTeacher = mainTeacher;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<CourseDailyNote> getCourseDailyNote() {
		return courseDailyNote;
	}
	public void setCourseDailyNote(ArrayList<CourseDailyNote> courseDailyNote) {
		this.courseDailyNote = courseDailyNote;
	}
}
