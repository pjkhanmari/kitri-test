package org.kitri.app.interfaces.repositories.course;

import java.util.ArrayList;
import java.util.Date;

import org.kitri.app.domains.dailynote.DailyNote;

/**
 * 과정 일지
 * @author kitri
 *
 */
public interface CourseDailyNoteRepositoryInterface {
	public ArrayList<DailyNote> selectDailyNotes(String courseId);
	public DailyNote selectDailyNote(String courseId, Date date);
	public void insertDailyNotes(String courseId, Date date);
	public void updateDailyNotes(String courseId, Date date);
}