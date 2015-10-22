package org.kitri.app.domains.course.detail;
/**
 * 1일 시간표
 * @author 김희택
 *
 */
public class CourseDailySchedule {
	public CourseDailySchedule() {}
	int lectureTimes; // 몇 교시가 배정되는가
	String teacherNames[]; // 1교시부터 N교시까지 강사 이름
	String lectureTitle[]; // 수업 이름
	String lectureDescription[]; // 수업 내용
	public int getLectureTimes() {
		return lectureTimes;
	}
	public void setLectureTimes(int lectureTimes) {
		this.lectureTimes = lectureTimes;
	}
	public String[] getTeacherNames() {
		return teacherNames;
	}
	public void setTeacherNames(String[] teacherNames) {
		this.teacherNames = teacherNames;
	}
	public String[] getLectureTitle() {
		return lectureTitle;
	}
	public void setLectureTitle(String[] lectureTitle) {
		this.lectureTitle = lectureTitle;
	}
	public String[] getLectureDescription() {
		return lectureDescription;
	}
	public void setLectureDescription(String[] lectureDescription) {
		this.lectureDescription = lectureDescription;
	}
	
	
}