<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
</head> 
<body> 
	<s:if test="result != null">
		<div style="padding:4px 10px;">
			<h2><s:property value="result.readYear"/>年<s:if test='result.readMonth < 10'>0</s:if><s:property value="result.readMonth"/>月 抄表详情</h2>
			<table width="100%">
				<tbody>
					<tr>
						<td>上月表码</td>
						<td><input readonly="readonly" value="<s:property value="result.preValue"/>" /></td>
						<td>本月表码</td>
						<td><input readonly="readonly" value="<s:property value="result.curValue"/>" /></td>
					</tr>
					<tr>
						<td>用水量</td>
						<td><input readonly="readonly" value="<s:property value="result.Amount"/> 吨"/></td>
						<td>提比提量</td>
						<td><input readonly="readonly" value="<s:if test="result.user != null"><s:if test="result.user.formulas != null"><s:iterator var="formula" value="result.user.formulas" status="st">[<s:property value="#formula.costType.code"/>:<s:property value="#formula.allotValue"/><s:if test="#formula.allotType == 2">%</s:if>]</s:iterator></s:if></s:if>" /></td>
					</tr>
				</tbody>
			</table>
			
			<table class="data display">
				<thead>
					<tr>
						<th width="40">编码</th>
						<th width="80" style="text-align:center;">类型</th>
						<th width="80" style="text-align:center;">占比</th>
						<th width="80" style="text-align:right;">分类水量</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<s:if test="result.user != null">
						<s:if test="result.user.formulas != null">
							<s:iterator var="formula" value="result.user.formulas" status="st">
								<tr class="<s:if test='#st.odd == true'>odd</s:if><s:elseif test='#st.even == true'>even</s:elseif>">
									<td class="center"><s:property value="#formula.costType.code"/></td>
									<td class="center"><s:property value="#formula.costType.costTypeName"/></td>
									<td class="center"><s:property value="#formula.allotValue"/><s:if test="#formula.allotType == 2">%</s:if></td>
									<td class="right"><s:if test='(#formula.allotType == 2 && #formula.allotValue == 100) || (#formula.allotType == 1 && #formula.allotValue == result.Amount)'>
															<s:property value="result.Amount"/>
													  </s:if><s:elseif test="#formula.allotType == 1">
													  			<s:property value="#formula.allotValue"/>
													  </s:elseif><s:elseif test="#formula.allotType == 2">
													  			<s:property value="result.Amount * (#formula.allotValue / 100.00)"/>
													  </s:elseif> 吨
									</td>
								</tr>
							</s:iterator>
						</s:if>
					</s:if>
				</tbody>
			</table>
		</div>
	</s:if>
	<s:else>
		<h1 align="center">无此记录详情</h1>
	</s:else>
</body> 
</html>