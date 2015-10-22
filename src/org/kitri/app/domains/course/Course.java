package org.kitri.app.domains.course;

import java.util.ArrayList;
import java.util.Date;

import org.kitri.app.domains.course.detail.CourseScheduleSheet;
import org.kitri.app.domains.users.Student;
import org.kitri.app.domains.users.Teacher;

public class Course {
	private String title;
	private Date createdDate;
	private Date startDate;
	private Date endDate;
	private CourseScheduleSheet schedule; // 전체 과정 일일 시간표
	private Teacher mainTeacher; // 담임 강사
	private ArrayList<Student> students; // 학생
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
	public void setSchedule(CourseScheduleSheet schedule) {
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
}
