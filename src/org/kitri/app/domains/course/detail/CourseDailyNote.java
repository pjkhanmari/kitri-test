package org.kitri.app.domains.course.detail;

import java.util.Date;
import java.util.HashMap;

import org.kitri.app.domains.users.Student;
/**
 * 과정 일지
 * @author 김희택
 *
 */
public class CourseDailyNote {
	private Date writen;
	private String description = null;
	private HashMap<Student, String> consulted = null; // 학생, 상담내용
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public Date getWriten() {
		return writen;
	}
	public void setWriten(Date writen) {
		this.writen = writen;
	}
	public HashMap<Student, String> getConsulted() {
		return consulted;
	}
	public void setConsulted(HashMap<Student, String> consulted) {
		this.consulted = consulted;
	}
}
