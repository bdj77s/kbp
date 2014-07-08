<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- 아래 스타일은 전자정부 프레임워크의 샘플 CSS를 이용한다는 것입니다. -->
<link type="text/css" rel="stylesheet" href="/KnowledgeBank/css/egovframework/sample.css;jsessionid=5D98BFB8E6ECEB0969759AD8461FBD0C"/>

<script type="text/javascript">
<!--
	function searchItem() {

		var frm = document.forms.searchForm;

		if(frm.fromTrdDt.value.length < 8) {
			 frm.fromTrdDt.focus();
			 return;
		}
		if(frm.toTrdDt.value.length < 8) {
			frm.toTrdDt.focus();
			return;
		}
	
	   
		if(frm.patternType[0].checked == true) {
			if(frm.returnType[0].checked == true) {
				frm.action = '<c:url value="/chartpattern/sp/1" />';
			}
			else {
				frm.action = '<c:url value="chartpattern/sp/1" />';
			}
		}
		else {
			if(frm.returnType[0].checked == true) {
				frm.action = '<c:url value="chartpattern/sp/1" />';
			}
			else {
				frm.action = '<c:url value="chartpattern/sp/1" />';
			}
		}

		frm.submit();
	}
//-->
</script>

<form name='searchForm' method='post'>

<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>"> 급등주 패턴 조회 </li>
		</ul>
	</div>

	<div id="table" style='text-align:center;'>
		<br/>
		<table width="500px" border="1" cellpadding="0" cellspacing="0">
			<colgroup>
				<col width="150" />
				<col width="" />
			</colgroup>
			<tr>
				<th>날짜</th>
				<td>
					<input type="text" name='fromTrdDt' /> ~ <input type="text" name='toTrdDt' />
				</td>
			</tr>
			<tr>
				<th>패턴</th>
				<td>
					<input type="radio" name="patternType" value="upTailSbs" checked>윗꼬리 나란히
					<input type="radio" name="patternType" value="frontSbs"> 앞으로 나란히
				</td>
			</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value='조회' onClick='searchItem();'/>
				<input type="radio" name="returnType" value="jsp" checked>JSP
				<input type="radio" name="returnType" value="json">JSON
			</td>
		</tr>
		</table>
		<br/>
	</div>
</div>
</form>