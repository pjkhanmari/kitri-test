package org.kitri.app.domains.course.detail;
/**
 * 과정 일지
 * @author 김희택
 *
 */
public class CourseScheduleSheet {
	public CourseScheduleSheet(String courseId) {this.courseId = courseId;}
	String courseId; // 과정 ID
	int days; // 총 수업 일 수
	CourseDailyScheduleNode nodes[]; // 1일 시간표
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public CourseDailyScheduleNode[] getNodes() {
		return nodes;
	}
	public void setNodes(CourseDailyScheduleNode[] nodes) {
		this.nodes = nodes;
	}
	
	
}
