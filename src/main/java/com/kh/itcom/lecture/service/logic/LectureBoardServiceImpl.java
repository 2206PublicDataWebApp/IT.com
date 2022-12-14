package com.kh.itcom.lecture.service.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.itcom.lecture.domain.LectureBoard;
import com.kh.itcom.lecture.domain.LectureBoardComment;
import com.kh.itcom.lecture.service.LectureBoardService;
import com.kh.itcom.lecture.store.LectureBoardStore;

@Service
public class LectureBoardServiceImpl implements LectureBoardService {
	// LectureBoardStore(Logic)과 CrawlingStoreLogic 2개 씀
	@Autowired
	private SqlSession session;
	@Autowired
	private LectureBoardStore lbStore;
	@Override
	public int registerLecture(LectureBoard lectureboard) {
		int result = lbStore.insertLecture(session, lectureboard);
		return result;
	}
	@Override
	public List<LectureBoard> printAllLectureBoard(int currentPage, int lboardLimit) {
		List<LectureBoard> lbList = lbStore.selectAllLectureBoard(session, currentPage, lboardLimit);
		return lbList;
	}
	@Override
	public LectureBoard printOneByNo(Integer lBoardNo) {
		LectureBoard lectureboard = lbStore.selectOneByNo(session, lBoardNo);
		
		return lectureboard;
	}
	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int totalCount = lbStore.selectTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}
	@Override
	public List<LectureBoard> printAllByValue(String searchCondition, String searchValue, int currentPage, int lboardLimit) {
		List<LectureBoard> lbList = lbStore.selectAllByValue(session, searchCondition, searchValue, currentPage, lboardLimit);
		return lbList;
	}
	@Override
	public int modifyLecture(LectureBoard lectureboard) {
		int result = lbStore.updateLectureBoard(session, lectureboard);
		return result;
	}
	
	// 댓글
	@Override
	public int registerComment(LectureBoardComment lbComment) {
		int result = lbStore.insertComment(session, lbComment);
		return result;
	}
	
	@Override
	public void modifyComment(Map<String, Object> inputMap) {
		lbStore.updateComment(session, inputMap);
	}
	
	@Override
	public int deleteComment(Integer lCommentNo) {
		int result = lbStore.deleteComment(session, lCommentNo);
		return result;
	}
	@Override
	public List<LectureBoardComment> printAllLectureBoardComment(Integer lBoardNo) {
		List<LectureBoardComment> lcList = lbStore.selectAllComment(session, lBoardNo);
		return lcList;
	}
	
}
