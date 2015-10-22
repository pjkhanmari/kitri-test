package org.kitri.app.interfaces.repositories.course;

import java.util.ArrayList;

import org.kitri.app.domains.users.Student;

/**
 * 과정 관련 인원
 * @author kitri
 *
 */
public interface CourseMemberRepositoryInterface {
	public void addCourseMemberStudent(String courseId, Student student);
	public void addCourseMemberStudents(String courseId, Student student[]);
	public void removeCourseMemberStudent(String courseId, String studentId);
	public void removeCourseMemberStudents(String courseId);
	public ArrayList<Student> selectCourseMemberStudents(String courseId);
}
