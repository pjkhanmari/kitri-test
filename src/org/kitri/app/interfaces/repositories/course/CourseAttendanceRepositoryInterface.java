package org.kitri.app.interfaces.repositories.course;

import org.kitri.app.domains.benefits.AttendanceSheet;

/**
 * 과정 출결
 * @author kitri
 *
 */
public interface CourseAttendanceRepositoryInterface {
	public AttendanceSheet selectStudentAttendanceSheet(String courseId);
	public void updateStudentAttendanceSheet(String courseId, AttendanceSheet sheet);
}
