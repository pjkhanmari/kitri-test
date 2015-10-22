package org.kitri.app.interfaces.repositories.course;

import org.kitri.app.domains.course.detail.CourseScheduleSheet;

/**
 * 과정 수업 세부 일정
 * @author 김희택
 *
 */
public interface ICourseScheduleRepository {
	public CourseScheduleSheet selectCourseSchedule(String courseId) throws Exception;
	public void insertCourseSchedule(String courseId, CourseScheduleSheet scheduleSheet) throws Exception;
}