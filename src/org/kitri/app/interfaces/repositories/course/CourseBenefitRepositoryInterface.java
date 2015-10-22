package org.kitri.app.interfaces.repositories.course;

import java.util.ArrayList;

import org.kitri.app.domains.benefits.StudentBenefitSheet;
import org.kitri.app.domains.benefits.TeacherBenefitSheet;

/**
 * 과정 수당 및 산출식
 * @author kitri
 *
 * sheet에 수당, 산출식 포함
 *
 */
public interface CourseBenefitRepositoryInterface {
	public ArrayList<StudentBenefitSheet> selectStudentsBenefitSheet(String courseId);
	public ArrayList<TeacherBenefitSheet> selectTeachersBenefitSheet(String courseId);
	public StudentBenefitSheet selectStudentBenefitSheet(String courseId);
	public TeacherBenefitSheet selectTeacherBenefitSheet(String courseId);
}