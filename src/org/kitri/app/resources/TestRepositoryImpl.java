package org.kitri.app.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.kitri.app.domains.benefits.AttendanceSheet;
import org.kitri.app.domains.benefits.StudentBenefitSheet;
import org.kitri.app.domains.benefits.TeacherBenefitSheet;
import org.kitri.app.domains.course.Course;
import org.kitri.app.domains.course.detail.CourseScheduleSheet;
import org.kitri.app.domains.dailynote.DailyNote;
import org.kitri.app.domains.finance.FinanceDetail;
import org.kitri.app.domains.users.Employee;
import org.kitri.app.domains.users.Student;
import org.kitri.app.domains.users.User;
import org.kitri.app.interfaces.Repository;
import org.kitri.app.message.ExceptionMessages;

public class TestRepositoryImpl extends Repository{
	// 초기화
	public static Map<String,User> users; // id, user 
	public static Map<String,Course> courses;
	static{
		users = new HashMap<String, User>();
		courses = new HashMap<String, Course>();
	}
	public TestRepositoryImpl() {
		super();
	}
	
	/**
	 * UserRepository
	 */
	@Override
	public void insertUser(User user) throws Exception{
		if(users.containsKey(user.getId()))
			throw new Exception(ExceptionMessages.USER_EXISTS_ALREADY);
		else users.put(user.getId(), new User(user.getId(), user.getPw()));
	}
	/**
	 * UserRepository
	 */
	@Override
	public User selectUser(String id, String pw) {
		User user = users.get(id);
		if(user.getPw().equals(pw))
			return user;
		else return null;
	}
	/**
	 * UserRepository
	 */
	@Override
	public void updateUser(User user) throws Exception{
		User temp = users.get(user.getId());
		if(temp != null){
			users.remove(temp);
			users.put(temp.getId(), user);
		}else{
			throw new Exception(ExceptionMessages.USER_NOT_EXISTS);
		}
	}

	/**
	 * AuthorizationRepository
	 */
	@Override
	public Employee addAuth(String id, int auth) throws Exception{
		User user = users.get(id);
		if(user == null)
			throw new Exception(ExceptionMessages.USER_NOT_EXISTS);
		if(user.getType() != User.TYPE_EMPLOYEE){
			throw new Exception(ExceptionMessages.IS_NOT_EMPLOYEE);
		}
		Employee temp = (Employee)user;
		temp.setAuths(temp.getAuths() | auth);
		return temp;
	}
	
	/**
	 * AuthorizationRepository
	 */
	@Override
	public int selectAuth(String id) throws Exception {
		User user = users.get(id);
		if(user == null)
			throw new Exception(ExceptionMessages.USER_NOT_EXISTS);
		if(user.getType() != User.TYPE_EMPLOYEE){
			throw new Exception(ExceptionMessages.IS_NOT_EMPLOYEE);
		}
		return ((Employee)user).getAuths();
	}

	/**
	 * AuthorizationRepository
	 */
	@Override
	public Employee removeAuth(String id, int auth) throws Exception {
		User user = users.get(id);
		if(user == null)
			throw new Exception(ExceptionMessages.USER_NOT_EXISTS);
		if(user.getType() != User.TYPE_EMPLOYEE){
			throw new Exception(ExceptionMessages.IS_NOT_EMPLOYEE);
		}
		Employee temp = (Employee)user;
		temp.setAuths(temp.getAuths() ^ auth);
		return temp;
	}

	/**
	 * CourseScheduleRepository
	 */
	@Override
	public CourseScheduleSheet selectCourseSchedule(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * CourseScheduleRepository
	 */
	@Override
	public void insertCourseSchedule(String courseId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * CourseDailyNoteRepository
	 */
	@Override
	public ArrayList<DailyNote> selectDailyNotes(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ICourseDailyNoteRepository
	 */
	@Override
	public DailyNote selectDailyNote(String courseId, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ICourseDailyNoteRepository
	 */
	@Override
	public void insertDailyNotes(String courseId, Date date) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ICourseDailyNoteRepository
	 */
	@Override
	public void updateDailyNotes(String courseId, Date date) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ICourseBenefitRepository
	 */
	@Override
	public ArrayList<StudentBenefitSheet> selectStudentsBenefitSheet(
			String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ICourseBenefitRepository
	 */
	@Override
	public ArrayList<TeacherBenefitSheet> selectTeachersBenefitSheet(
			String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ICourseBenefitRepository
	 */
	@Override
	public StudentBenefitSheet selectStudentBenefitSheet(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ICourseBenefitRepository
	 */
	@Override
	public TeacherBenefitSheet selectTeacherBenefitSheet(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ICourseMemberRepository
	 */
	@Override
	public void addCourseMemberStudent(String courseId, Student student) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ICourseMemberRepository
	 */
	@Override
	public void addCourseMemberStudents(String courseId, Student[] student) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ICourseMemberRepository
	 */
	@Override
	public void removeCourseMemberStudent(String courseId, String studentId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ICourseMemberRepository
	 */
	@Override
	public void removeCourseMemberStudents(String courseId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ICourseMemberRepository
	 */
	@Override
	public ArrayList<Student> selectCourseMemberStudents(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ICourseAttendanceRepository
	 */
	@Override
	public AttendanceSheet selectStudentAttendanceSheet(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ICourseAttendanceRepository
	 */
	@Override
	public void updateStudentAttendanceSheet(String courseId,
			AttendanceSheet sheet) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ICourseFinanceRepository
	 */
	@Override
	public void addFinance(String courseid, FinanceDetail financeDetail) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ICourseFinanceRepository
	 */
	@Override
	public void removeFinance(String courseid, String financeId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ICourseFinanceRepository
	 */
	@Override
	public ArrayList<FinanceDetail> selectFinanceLists(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}
}
