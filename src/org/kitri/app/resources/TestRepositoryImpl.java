package org.kitri.app.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.kitri.app.domains.benefits.AttendanceSheet;
import org.kitri.app.domains.benefits.StudentBenefitSheet;
import org.kitri.app.domains.benefits.TeacherBenefitSheet;
import org.kitri.app.domains.course.Course;
import org.kitri.app.domains.course.detail.CourseDailyNote;
import org.kitri.app.domains.course.detail.CourseDailySchedule;
import org.kitri.app.domains.course.detail.CourseScheduleSheet;
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
		// add course
		Course course = new Course();
		course.setTitle("빅데이터 응용시스템 1기");
		course.setId("100");
		// add course schedule
		CourseScheduleSheet sheet = new CourseScheduleSheet(course.getId());
		ArrayList<CourseDailySchedule> dailySchedule = new ArrayList<CourseDailySchedule>();
		for(int i=0; i<30; i++){ // 30일 수업
			CourseDailySchedule temp = new CourseDailySchedule();
			String[] lectureTitle = new String[8];
			String[] lectureDescription = new String[8];
			for(int j=0; j<8; j++){ // 8교시까지
				temp.setLectureTimes(8); // 8교시
				lectureTitle[i] = "자바";
				lectureDescription[i] = i+1 + "번째 자바 강의 ";
			}
			temp.setLectureTitle(lectureTitle);
			temp.setLectureDescription(lectureDescription);
		}
		sheet.setDailySchedule(dailySchedule);
		course.setCourseScheduleSheet(sheet);
		
		ArrayList<CourseDailyNote> notes = new ArrayList<CourseDailyNote>();
		for(int i=0; i<10; i++){
			CourseDailyNote courseDailyNote = new CourseDailyNote();
			courseDailyNote.setDescription("blah blah .... ");
			courseDailyNote.setWriten(new Date(System.currentTimeMillis()));
			notes.add(courseDailyNote);
		}
		course.setCourseDailyNote(notes);
		//
		
	}
	public TestRepositoryImpl() {
		super();
	}
	
	/**
	 * IUserRepository
	 */
	@Override
	public void insertUser(User user) throws Exception{
		if(users.containsKey(user.getId()))
			throw new Exception(ExceptionMessages.USER_EXISTS_ALREADY);
		else users.put(user.getId(), new User(user.getId(), user.getPw()));
	}
	/**
	 * IUserRepository
	 */
	@Override
	public User selectUser(String id, String pw) {
		User user = users.get(id);
		if(user.getPw().equals(pw))
			return user;
		else return null;
	}
	/**
	 * IUserRepository
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
	 * IAuthorizationRepository
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
	 * IAuthorizationRepository
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
	 * IAuthorizationRepository
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
	 * ICourseScheduleRepository
	 * @throws Exception 
	 */
	@Override
	public CourseScheduleSheet selectCourseSchedule(String courseId) throws Exception {
		Course course = courses.get(courseId);
		if(course == null)
			throw new Exception(ExceptionMessages.COURSE_NOT_EXISTS);
		return course.getSchedule();
	}

	/**
	 * ICourseScheduleRepository
	 * @throws Exception 
	 */
	@Override
	public void insertCourseSchedule(String courseId, CourseScheduleSheet scheduleSheet) throws Exception {
		Course course = courses.get(courseId);
		if(course == null)
			throw new Exception(ExceptionMessages.COURSE_NOT_EXISTS);
		course.setCourseScheduleSheet(scheduleSheet);
	}

	/**
	 * 
	 * ICourseDailyNoteRepository
	 * @throws Exception 
	 */
	@Override
	public ArrayList<CourseDailyNote> selectCourseDailyNotes(String courseId) throws Exception {
		Course course = courses.get(courseId);
		if(course == null)
			throw new Exception(ExceptionMessages.COURSE_NOT_EXISTS);
		return course.getCourseDailyNote();
	}

	/**
	 * ICourseDailyNoteRepository
	 * Test시에는 날짜 계산을 아래와 같이 했다.하지만
	 * DB로 구현할 때에는 query를 통해서 간단하게 구현
	 * @throws Exception 
	 */
	@Override
	public CourseDailyNote selectCourseDailyNote(String courseId, Date date) throws Exception {
		Course course = courses.get(courseId);
		if(course == null)
			throw new Exception(ExceptionMessages.COURSE_NOT_EXISTS);
		ArrayList<CourseDailyNote> courseDailyNote = course.getCourseDailyNote();
		long diff = date.getTime() - courseDailyNote.get(0).getWriten().getTime();
		long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		if(days <0 || days >= courseDailyNote.size())
			throw new Exception(ExceptionMessages.DATE_OUT_OF_RANGE);
		return courseDailyNote.get((int)days);
	}

	/**
	 * ICourseDailyNoteRepository
	 */
	@Override
	public void insertCourseDailyNotes(String courseId, Date date) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ICourseDailyNoteRepository
	 */
	@Override
	public void updateCourseDailyNotes(String courseId, Date date) {
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
