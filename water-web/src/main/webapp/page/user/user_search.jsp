<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
	<%@ include file="/common/head.jsp"%>
	
	<script type="text/javascript">
		//查询用户
		function searchUser(){	
			//显示选择用户的界面
			showWindow({url:'action/user/user/findFreetext', callback: function(val){
				//alert(val.addr);  //回调处理
			}});
		}
		
		//显示抄表详情
		function showReadingDetail(id){
			showWindow({url:'action/rd/read/getById?id='+id, width:600, height:400});
		}
		
		//显示水费单详情
		function showBillDetail(billNo){
			showWindow({url:"action/py/bill/getById?billNo="+billNo, width:800, height:600});
		}

	</script>
</head> 
<body> 
<div id="wrapper">
	
	<%@ include file="/common/top.jsp"%>

	<div id="content" class="xgrid">
		<div class="x12">
			<h2>用户查询</h2>
			<div class="searchUserDiv">
				<form action="action/user/user/findFreetext" method="post">
					用户编码 <input name="userNo" value="<s:property value='#session.user.userNo'/>" />
					用户简码 <input name="abc" value="<s:property value='#session.user.abc'/>" />
					用户姓名 <input name="userName" value="<s:property value='#session.user.userName'/>" />
					联系电话 <input name="phone" value="<s:property value='#session.user.phone'/>" />
					家庭住址 <input name="address" value="<s:property value='#session.user.address'/>" />
							 <input type="hidden" name="forward" value="user_search" />
					<button class="btn btn-small btn-icon btn-person" 
						onclick="javascript:$('.searchUserDiv').submit();">
						<span></span>
						查询用户
					</button>
				</form>
			</div>
			
			<div class="tab_container">
				<ul class="tabs"> 
					<li><a href="#tab1">基本信息</a></li> 
					<li><a href="#tab2">水价信息</a></li> 
					<li><a href="#tab3">抄表信息</a></li> 
					<li><a href="#tab4">水费单记录</a></li> 
					<li><a href="#tab5">收费单记录</a></li> 
				</ul> 
				
				<s:if test="result == null">
					<div class="tab_content_container"> 
						<div id="tab1" class="tab_content">
							<div class="center">请先查询</div>
						</div>
						<div id="tab2" class="tab_content"> 
							<div class="center">请先查询</div>
						</div>
						<div id="tab3" class="tab_content"> 
							<div class="center">请先查询</div>
						</div>
						<div id="tab4" class="tab_content"> 
							<div class="center">请先查询</div>
						</div>
						<div id="tab5" class="tab_content"> 
							<div class="center">请先查询</div>
						</div>
					</div>
				</s:if>
				<s:else>
					<div class="tab_content_container"> 
						<div id="tab1" class="tab_content">
							<!-- 基本信息 -->
							<div class="x12">	
								<h3>用户基本信息</h3>
								
								<table width="100%">
									<thead>
										<tr>
											<th width="60"></th>
											<th width="220"></th>
											<th width="60"></th>
											<th width="220"></th>
											<th width="60"></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>用户编码</td>
											<td><input readonly="readonly" value="<s:property value="result.userNo"/>" /></td>
											<td>用户类型</td>
											<td><input readonly="readonly" value="<s:property value="findByDictNameAndValue('用户类型',result.userType)"/>" /></td>
											<td>所属辖区</td>
											<td><input readonly="readonly" value="<s:property value='findByDictNameAndValue("抄表辖区",result.areaId)'/>" /></td>
										</tr>
										<tr>
											<td>用户名称</td>
											<td><input readonly="readonly" value="<s:property value="result.userName"/>" /></td>
											<td>开户时间</td>
											<td><input readonly="readonly" value="<s:date name="result.createDate" format="yyyy年MM月dd日"/>" /></td>
											<td>收款方式</td>
											<td><input readonly="readonly" value="<s:property value='findByDictNameAndValue("收款方式",result.payType)'/>" /></td>
										</tr>
										<tr>
											<td>联系电话</td>
											<td><input readonly="readonly" value="<s:property value='result.phone'/>" /></td>
											<td>开户银行</td>
											<td><input readonly="readonly" value="<s:property value='result.bankName'/>" /></td>
											<td>银行账号</td>
											<td><input readonly="readonly" value="<s:property value='result.bankNum'/>" /></td>
										</tr>
										<tr>
											<td>短信电话</td>
											<td><input readonly="readonly" value="<s:property value='result.smsphone'/>" /></td>
											<td>用户地址</td>
											<td colspan="3"><input size="64" readonly="readonly" 
																value="<s:property value='result.address'/>" /></td>
										</tr>
										<tr>
											<td>档案编号</td>
											<td><input readonly="readonly" value="<s:property value='result.docNum'/>" /></td>
											<td>合同编号</td>
											<td><input readonly="readonly" value="<s:property value='result.contractNum'/>" /></td>
											<td>签订日期</td>
											<td><input readonly="readonly" value='<s:date name="result.contractDate" format="yyyy年MM月dd日" />' /></td>
										</tr>
										<tr>
											<td>提比提量</td>
											<td><input readonly="readonly" value="<s:property value='result.formula'/>" /></td>
											<s:if test="result.userMoney >= 0">
												<td>用户余额</td>
												<td><input readonly="readonly" class="right" value="<s:property value='result.userMoney'/>" />元</td>
												<td>用户欠款</td>
												<td><input readonly="readonly" class="right" value="0.00" />元</td>
											</s:if>
											<s:else>
												<td>用户余额</td>
												<td><input readonly="readonly" class="right" value="0.00" />元</td>
												<td>用户欠款</td><s:number name="result.userMoney" />
												<td><input readonly="readonly" class="right" value="<s:property value='@java.lang.Math@abs(result.userMoney)'/>" />元</td>
											</s:else>
										</tr>
									</tbody>
								</table>
								
								<br/><br/><br/>
								<h3>用户表册信息</h3>
								
								<table width="100%">
									<thead>
										<tr>
											<th width="60"></th>
											<th width="220"></th>
											<th width="60"></th>
											<th width="220"></th>
											<th width="60"></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>表册编号</td>
											<td><input readonly="readonly" value="<s:property value='result.volume.id'/>" /></td>
											<td>表册名称</td>
											<td><input readonly="readonly" value="<s:property value='result.volume.volumeName'/>" /></td>
											<td>所在序号</td>
											<td><input readonly="readonly" value="<s:property value='result.volume.orderIndex'/>" /></td>
										</tr>
									</tbody>
									</table>
									
									<br/><br/><br/>
									<h3>用户水表信息</h3>
									
									<table width="100%">
									<thead>
										<tr>
											<th width="60"></th>
											<th width="220"></th>
											<th width="60"></th>
											<th width="220"></th>
											<th width="60"></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>水表编号</td>
											<td><input readonly="readonly" value="<s:property value='result.meter.meterNo'/>" /></td>
											<td>表身码</td>
											<td><input readonly="readonly" value="<s:property value='result.meter.meterName'/>" /></td>
											<td>起始底码</td>
											<td><input readonly="readonly" value="<s:property value='result.meter.meterType.minValue'/>" /></td>
										</tr>
										<tr>
											<td>水表类型</td>
											<td><input readonly="readonly" value="<s:property value='result.meter.meterType.meterTypeName'/>" /></td>
											<td>水表口径</td>
											<td><input readonly="readonly" value="<s:property value='result.meter.meterType.aperture'/>" /></td>
											<td>最大码值</td>
											<td><input readonly="readonly" value="<s:property value='result.meter.meterType.mavValue'/>" /></td>
										</tr>
										<tr>
											<td>装表日期</td>
											<td><input readonly="readonly" value="<s:date name="result.meter.setupDate" format="yyyy年MM月dd日"/>" /></td>
											<td>水表厂家</td>
											<td colspan="3"><input size="64" readonly="readonly" value="<s:property value='result.meter.factory'/>" /></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div id="tab2" class="tab_content"> 
							<!-- 水价信息 -->
							<s:if test="result.formulas.size() == 0">
								<div class="center">暂无信息</div>
							</s:if>
							<s:else>
								<table class="data display">
									<thead>
										<tr>
											<th width="40">编码</th>
											<th width="70">类型</th>
											<th wdith="70">占比</th>
											<th width="70">价格</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<s:iterator var="formula" value="result.formulas" status="st">
											<tr class="<s:if test='#st.odd == true'>odd</s:if><s:elseif test='#st.even == true'>even</s:elseif>">
												<td><s:property value="#formula.costType.code"/></td>
												<td><s:property value="#formula.costType.costTypeName"/></td>
												<td><s:property value="#formula.allotValue"/><s:if test="#formula.allotType == 2">%</s:if></td>
												<script type="text/javascript">
													var price = parseFloat('<s:property value="#formula.costType.price"/>');
												</script>
												<td><span class="costTypePrice"></span> 元/吨</td>
												<td> = <s:property value="#formula.costType.costTypeName"/>费(<s:property value="#formula.costType.price"/> 元)
													<s:iterator var="costType" value="#formula.costType.costTypes">
														+<s:property value="#costType.costTypeName"/>(<s:property value="#costType.price"/> 元)
														<script type="text/javascript">
															price = price + parseFloat('<s:property value="#costType.price"/>');
														</script>
													</s:iterator>
												</td>
												<script type="text/javascript">
													$(".costTypePrice:last").html(parseFloat(price).toFixed(2));
												</script>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</s:else>
						</div>
						<div id="tab3" class="tab_content"> 
							<!-- 抄表记录 -->
							<s:if test="result.reads.size() == 0">
								<div class="center">暂无信息</div>
							</s:if>
							<s:else>
								<table class="data display">
									<thead>
										<tr>
											<th width="80">抄表年月</th>
											<th width="40">复核</th>
											<th width="80">上次表码</th>
											<th width="80">本次表码</th>
											<th width="80">实用水量</th>
											<th width="100">操作日期</th>
											<th width="80">操作人</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<s:iterator var="read" value="result.reads" status="st">
											<tr class="<s:if test='#st.odd == true'>odd</s:if><s:elseif test='#st.even == true'>even</s:elseif>">
												<td class="center"><s:property value="#read.readYear"/><s:if test='#read.readMonth < 10'>0</s:if><s:property value="#read.readMonth"/></td>
												<td class="center"><s:if test='#read.Audit'>是</s:if><s:else>否</s:else></td>
												<td class="right"><s:property value="#read.preValue"/></td>
												<td class="right"><s:property value="#read.curValue"/></td>
												<td class="right"><s:property value="#read.Amount"/> 吨</td>
												<td class="center"><s:date name="#read.readDate" format="yyyy-MM-dd"/></td>
												<td class="center"><s:property value="#read.readEmp.empName"/></td>
												<td class="left"><button class="btn btn-small btn-blue" onClick="showReadingDetail(<s:property value="#read.id"/>);">详情</button></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</s:else>
						</div>
						<div id="tab4" class="tab_content"> 
							<!-- 水费单记录 -->
							<s:if test="result.reads.size() == 0">
								<div class="center">暂无信息</div>
							</s:if>
							<s:else>
								<table class="data display">
									<thead>
										<tr>
											<th width="200">水费单号</th>
											<th width="100">应收金额</th>
											<th width="100">已收金额</th>
											<th width="100">未收金额</th>
											<th width="80">创建日期</th>
											<th width="80">是否结清</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<s:iterator var="read" value="result.reads">
											<s:if test="#read.bills.size() != 0">
												<s:iterator var="bill" value="#read.bills" status="st">
													<tr class="<s:if test='#st.odd == true'>odd</s:if><s:elseif test='#st.even == true'>even</s:elseif>">
														<td class="center"><s:property value="#bill.billNo"/></td>
														<td class="right"><s:property value="#bill.billMoney"/> 元</td>
														<td class="right"><s:property value="#bill.realMoney"/> 元</td>
														<td class="right"><s:property value="#bill.billMoney - #bill.realMoney"/> 元</td>
														<td class="center"><s:date name="#bill.createDate" format="yyyy-MM-dd"/></td>
														<td class="center"><s:if test='#bill.balance'>是</s:if><s:else>否</s:else></td>
														<td class="left"><button class="btn btn-small btn-blue" onClick="showBillDetail('<s:property value="#bill.billNo"/>');">详情</button></td>
													</tr>
												</s:iterator>
											</s:if>
										</s:iterator>
									</tbody>
								</table>
							</s:else>
						</div>
						<div id="tab5" class="tab_content"> 
							<!-- 收费单记录 -->
							<s:if test="result.pays.size() == 0">
								<div class="center">暂无信息</div>
							</s:if>
							<s:else>
								<table class="data display">
									<thead>
										<tr>
											<th width="200">交费单号</th>
											<th width="100">交费金额</th>
											<th width="100">剩余金额</th>
											<th width="100">发票号</th>
											<th width="80">交费日期</th>
											<th width="80">收费员</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<s:iterator var="pay" value="result.pays" status="st">
											<tr class="<s:if test='#st.odd == true'>odd</s:if><s:elseif test='#st.even == true'>even</s:elseif>">
												<td class="center"><s:property value="#pay.payNo"/></td>
												<td class="right"><s:property value="#pay.payMoney"/> 元</td>
												<td class="right"><s:property value="#pay.useMoney"/> 元</td>
												<td class="center"><s:property value="#pay.invoice.invoiceNo"/></td>
												<td class="center"><s:date name="#pay.payDate" format="yyyy-MM-dd"/></td>
												<td class="center"><s:property value="#pay.emp.empName"/></td>
												<td class="left"></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</s:else>
						</div>
					</div>
				</s:else>
			</div>
			
		</div> <!-- .x12 -->
		
		
	</div> <!-- #content -->
	
	<%@ include file="/common/bottom.jsp"%>	
	
	<c:remove var="user" scope="session"/>
</div> <!-- #wrapper -->

</body> 
</html>