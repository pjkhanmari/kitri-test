package org.kitri.app.interfaces.repositories.course;

import java.util.ArrayList;

import org.kitri.app.domains.finance.FinanceDetail;

/**
 * 과정 재무
 * @author 김희택
 *
 */
public interface ICourseFinanceRepository {
	public void addFinance(String courseid, FinanceDetail financeDetail);
	public void removeFinance(String courseid, String financeId);
	public ArrayList<FinanceDetail> selectFinanceLists(String courseId);
}
