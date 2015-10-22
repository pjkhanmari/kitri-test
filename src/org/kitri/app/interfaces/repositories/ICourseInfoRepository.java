package org.kitri.app.interfaces.repositories;

import org.kitri.app.interfaces.repositories.course.ICourseAttendanceRepository;
import org.kitri.app.interfaces.repositories.course.ICourseBenefitRepository;
import org.kitri.app.interfaces.repositories.course.ICourseDailyNoteRepository;
import org.kitri.app.interfaces.repositories.course.ICourseFinanceRepository;
import org.kitri.app.interfaces.repositories.course.ICourseMemberRepository;
import org.kitri.app.interfaces.repositories.course.ICourseScheduleRepository;

public interface ICourseInfoRepository extends ICourseScheduleRepository,
ICourseDailyNoteRepository, ICourseBenefitRepository, ICourseMemberRepository, ICourseAttendanceRepository, ICourseFinanceRepository{

}
