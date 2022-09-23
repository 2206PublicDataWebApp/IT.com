package com.kh.itcom.finish.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.itcom.finish.domain.FinishBoard;
import com.kh.itcom.finish.domain.FinishComment;
import com.kh.itcom.finish.store.FinishBoardStore;

@Repository
public class FinishBoardStoreLogic implements FinishBoardStore {

	// 게시글 등록
	@Override
	public int insertBoard(SqlSession session, FinishBoard fBoard) {
		int result=session.insert("FinishBoardMapper.insertBoard", fBoard);
		return result;
	}

	// 전체 게시글 수 구하기
	@Override
	public int selectTotalCount(SqlSessionTemplate session, String searchOption, String searchValue) {
		HashMap<String, String> paramMap=new HashMap<String,String>();
		paramMap.put("searchOption", searchOption);
		paramMap.put("searchValue", searchValue);
		int totalCount=session.selectOne("FinishBoardMapper.selectTotalCount",paramMap);
		return totalCount;
	}

	// 전체 게시글 리스트 조회
	@Override
	public List<FinishBoard> selectAllBoard(SqlSessionTemplate session, int currentPage, int boardLimit) {
		int offset=(currentPage-1)*boardLimit;
		RowBounds rowBounds=new RowBounds(offset, boardLimit);
		List<FinishBoard> fList=session.selectList("FinishBoardMapper.selectAllBoard", null, rowBounds);
		return fList;
	}

	@Override
	public List<FinishBoard> selectAllByValue(SqlSessionTemplate session, String searchOption, String searchValue,
			int currentPage, int boardLimit) {
		int offset=(currentPage-1)*boardLimit;
		RowBounds rowBounds=new RowBounds(offset, boardLimit);
		HashMap<String, String> paramMap=new HashMap<String,String>();
		paramMap.put("searchOption", searchOption);
		paramMap.put("searchValue", searchValue);
		List<FinishBoard> fList=session.selectList("FinishBoardMapper.selectAllByValue", paramMap, rowBounds);
		return fList;
	}

	@Override
	public FinishBoard selectOneByNo(SqlSessionTemplate session, int fBoardNo) {
		FinishBoard fBoard=session.selectOne("FinishBoardMapper.selectOneByNo",fBoardNo);
		return fBoard;
	}

	@Override
	public void updateBoardCount(SqlSessionTemplate session, int fBoardNo) {
		session.update("FinishBoardMapper.updateBoardCount", fBoardNo);
	}

	@Override
	public int updateBoard(SqlSessionTemplate session, FinishBoard fBoard) {
		int result=session.update("FinishBoardMapper.updateBoard", fBoard);
		return result;
	}

	@Override
	public int insertComment(SqlSessionTemplate session, FinishComment fComment) {
		int result=session.insert("FinishBoardMapper.insertComment", fComment);
		return result;
	}

	@Override
	public int updateUserPoint(SqlSessionTemplate session, String userId, String point) {
		HashMap<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("userId", userId);
		paramMap.put("point", point);
		int result=session.insert("FinishBoardMapper.updateUserPoint", paramMap);
		return result;
	}
	
	

}
