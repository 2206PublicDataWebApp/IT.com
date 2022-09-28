<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>IT.com : 상담후기 게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	<div id="wrap">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<h1 align="center">상담후기 게시판</h1>
		<img src="/img/consult.png" class="img-fluid" alt="...">
		<table  class="table table-sm" align="center" border="2">
			<tr>
				<th>제목</th>
				<th>등록일</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
			<c:if test="${!empty cList }">
				<c:forEach items="${cList }" var="cBoard" varStatus="i">
					<tr>
						<td>
							<a href="#" onclick="detailView('${userId}','${sessionScope.loginAdmin.adminId}', ${cBoard.cBoardNo },${currentPage },'${level }','${point }','${viewable }');">${cBoard.cBoardTitle }</a>
						</td>
						<td>${cBoard.cBoardCreateDate }</td>
						<td>${cBoard.cBoardCount }</td>
						<td>${cBoard.cBoardUpCount }</td>
					</tr>
				</c:forEach>
				<tr align="center" height="20">
					<td align="center">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item">
									<c:if test="${currentPage > 5}">
						 				<a class="page-link" href="/consult/${urlVal }.do?page=${startNavi - 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}"" aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
				      					</a>
				      				</c:if>
			    				</li>
								<c:forEach var="p" begin="${startNavi }" end="${endNavi }">	
								    <li class="page-item"><a class="page-link" href="/consult/${urlVal }.do?page=${p }&searchCondition=${searchCondition}&searchValue=${searchValue}">${p }</a></li>
			    				</c:forEach>
			    				<c:if test="${maxPage-4 > currentPage }">
								    <li class="page-item">
								    	<a class="page-link" href="/consult/${urlVal }.do?page=${endNavi + 1 }&searchCondition=${searchCondition}&searchValue=${searchValue}" aria-label="Next">
					        				<span aria-hidden="true">&raquo;</span>
					      				</a>
				    				</li>
				    			</c:if>
							</ul>
						</nav>
					</td>
				</tr>
			</c:if>
			<c:if test="${empty cList }">
				<tr>
					<td colspan="6">게시글이 존재하지 않습니다</td>
				</tr>
			</c:if>
			<tr>
				<td colspan="5" align="center">
					<form action="/consult/consultSearch.do" method="get">
						<select class="form-select" aria-label="Default select example" name="searchCondition">
							<option value="all"
								<c:if test="${searchCondition == 'all' }">selected</c:if>>전체
							</option>
							<option value="title"
								<c:if test="${searchCondition == 'title' }">selected</c:if>>제목
							</option>
							<option value="contents"
								<c:if test="${searchCondition == 'contents' }">selected</c:if>>내용
							</option>
							<option value="center"
								<c:if test="${searchCondition == 'center' }">selected</c:if>>교육원명
							</option>
							<option value="local"
								<c:if test="${searchCondition == 'local' }">selected</c:if>>지역명
							</option>
						</select>
						<input type="text" name="searchValue" value="${searchValue }">
						<input type="submit" value="검색" class="btn btn-outline-primary">
					</form>
				</td>
				<c:if test="${empty sessionScope.loginAdmin }">
					<td>
						<button type="button" class="btn btn-primary" href="#" onclick="writeForm('${userId}');">글쓰기</button>
					</td>
				</c:if>
			</tr>
		</table>
	</div>
	<script>
		function detailView(userId, adminId, cBoardNo, currentPage,level, point, viewable) {
			event.preventDefault();
			var userLevel = '일반회원';
			var viewableNo = 'N';
			if(userId == "" && adminId == "") {
				if(confirm("로그인이 필요한 서비스입니다. 로그인하시겠습니까?")){
					location.href='/user/loginView.do';
				}
			}else{
				if(level == userLevel && viewable == viewableNo){
					if(confirm("100포인트를 사용하여 열람하시겠습니까?")) {
						if(point >= 100){
		 					location.href='/consult/consultDetailView.do?cBoardNo='+cBoardNo+'&page='+currentPage;
						}else {
							alert("포인트가 부족합니다");
						}
					}
				}else{
					location.href='/consult/consultDetailView.do?cBoardNo='+cBoardNo+'&page='+currentPage;
				}
			}
		}
		function writeForm(userId) {
			if(userId == ""){
				if(confirm("로그인이 필요한 서비스입니다 로그인하시겠습니까?")){
					location.href='/user/loginView.do';
				}
			}else {
				location.href='/consult/consultWriteFormView.do';
		}
	}
	</script>
</body>
</html>