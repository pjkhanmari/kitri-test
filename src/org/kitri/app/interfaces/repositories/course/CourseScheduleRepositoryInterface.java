package org.kitri.app.interfaces.repositories.course;

import org.kitri.app.domains.course.CourseSchedule;

/**
 * 과정 수업 세부 일정
 * @author kitri
 *
 */
public interface CourseScheduleRepositoryInterface {
	public CourseSchedule selectCourseSchedule(String courseId);
	public void insertCourseSchedule(String courseId);
}