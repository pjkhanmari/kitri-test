package org.kitri.app.interfaces.repositories.course;

import java.util.ArrayList;
import java.util.Date;

import org.kitri.app.domains.course.detail.CourseDailyNote;

/**
 * 과정 일지
 * @author 김희택
 *
 */
public interface ICourseDailyNoteRepository {
	public ArrayList<CourseDailyNote> selectCourseDailyNotes(String courseId) throws Exception;
	public CourseDailyNote selectCourseDailyNote(String courseId, Date date) throws Exception;
	public void insertCourseDailyNotes(String courseId, Date date);
	public void updateCourseDailyNotes(String courseId, Date date);
}