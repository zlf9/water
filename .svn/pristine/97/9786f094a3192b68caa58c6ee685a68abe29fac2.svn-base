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
			
		<!-- 水费单详情 -->
		
			<h2><s:property value="result.billNo"/> 水费单详情</h2>
			<table width="100%">
				<tbody>
					<tr>
						<td>应收金额</td>
						<td><input readonly="readonly" value="<s:property value="result.billMoney"/> 元" /></td>
						<td>状态</td>
						<td><input readonly="readonly" value="<s:if test='result.balance'>已</s:if><s:else>未</s:else>结清" /></td>
					</tr>
					<tr>
						<td>实收金额</td>
						<td><input readonly="readonly" value="<s:property value="result.realMoney"/> 元"/></td>
						<td>未收金额</td>
						<td><input readonly="readonly" value="<s:property value="result.billMoney - result.realMoney"/> 元" /></td>
					</tr>
				</tbody>
			</table>
			
			<table class="data display">
				<thead>
					<tr>
						<th width="80" style="text-align:center;">费用类型</th>
						<th width="60" style="text-align:right;">水量</th>
						<th width="80" style="text-align:right;">单价</th>
						<th width="80" style="text-align:right;">小计</th>
						<th width="80" style="text-align:right;">实收</th>
						<th width="80" style="text-align:right;">未收</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<s:if test="result.billDetails != null">
						<s:iterator var="billDetail" value="result.billDetails" status="st">
							<tr class="<s:if test='#st.odd == true'>odd</s:if><s:elseif test='#st.even == true'>even</s:elseif>">
								<td class="center"><s:property value="#billDetail.costType.costTypeName"/></td>
								<td class="right"><s:property value="#billDetail.amount"/> 吨</td>
								<td class="right"><s:property value="#billDetail.price"/> 元</td>
								<td class="right"><s:property value="#billDetail.detailMoney"/> 元</td>
								<td class="right"><s:property value="#billDetail.realMoney"/> 元</td>
								<td class="right"><s:property value="#billDetail.detailMoney - #billDetail.realMoney"/> 元</td>
								<td></td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
				</table>
				
				<s:if test="result.read != null">
				<!-- 抄表详情 -->
					<br/><br/>
					<h2><s:property value="result.read.readYear"/><s:if test='result.read.readMonth < 10'>0</s:if><s:property value="result.read.readMonth"/> 抄表详情</h2>
					<table width="100%">
					<tbody>
						<tr>
							<td>上月表码</td>
							<td><input readonly="readonly" value="<s:property value="result.read.preValue"/>" /></td>
							<td>本月表码</td>
							<td><input readonly="readonly" value="<s:property value="result.read.curValue"/>" /></td>
						</tr>
						<tr>
							<td>用水量</td>
							<td><input readonly="readonly" value="<s:property value="result.read.amount"/> 吨"/></td>
							<td>提比提量</td>
							<td><input readonly="readonly" value="<s:property value="result.read.formula"/>" /></td>
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
						<s:if test="result.read.user != null">
							<s:if test="result.read.user.formulas != null">
								<s:iterator var="formula" value="result.read.user.formulas" status="st">
									<tr class="<s:if test='#st.odd == true'>odd</s:if><s:elseif test='#st.even == true'>even</s:elseif>">
										<td class="center"><s:property value="#formula.costType.code"/></td>
										<td class="center"><s:property value="#formula.costType.costTypeName"/></td>
										<td class="center"><s:property value="#formula.allotValue"/><s:if test="#formula.allotType == 2">%</s:if></td>
										<td class="right"><s:if test='(#formula.allotType == 2 && #formula.allotValue == 100) || (#formula.allotType == 1 && #formula.allotValue == result.read.amount)'>
																<s:property value="result.read.amount"/>
														  </s:if><s:elseif test="#formula.allotType == 1">
														  			<s:property value="#formula.allotValue"/>
														  </s:elseif><s:elseif test="#formula.allotType == 2">
														  			<s:property value="result.read.amount * (#formula.allotValue / 100.00)"/>
														  </s:elseif> 吨
										</td>
									</tr>
								</s:iterator>
							</s:if>
						</s:if>
					</tbody>
				</table>
			</s:if>
		</div>
	</s:if>
	<s:else>
		<h1 align="center">无此记录详情</h1>
	</s:else>
</body> 
</html>