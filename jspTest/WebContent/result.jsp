<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Success URL</title>
</head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<body>
	<%
		String pageHeading = "Successfull";
		switch (Integer.parseInt(request
				.getParameter("LITE_PAYMENT_CARD_STATUS"))) {
		case 0:
			break;
		case 1:
		case 2:
		case 5:
		case 9:
			pageHeading = "Trylater";
			break;
		case 255:
			pageHeading = "Error";
			break;
		default:
			pageHeading = "Fail";
			break;
		}
	%>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="invoice-title">
					<h2>Invoice</h2>
					<h3 class="pull-right">
						MERCHANT REFERENCE
						<nobr><%=request.getParameter("MERCHANTREFERENCE")%></nobr>
					</h3>
				</div>
				<hr>
				<div class="row">
					<div class="col-xs-6">
						<address>
							<strong>Billed To:</strong><br> John Smith<br> 1234
							Main<br> Apt. 4B<br> Springfield, ST 54321
						</address>
					</div>
			
						<tr>
							<td align="center" class="clsQueryHeading"><nobr>LITE_TRANSACTIONINDEX</nobr></td>
							<td align="center" class="clsQuery"><nobr><%=request.getParameter("LITE_TRANSACTIONINDEX")%></nobr></td>
						</tr>
					
				</div>
				<div class="row">
					<div class="col-xs-6">
						<address>
							<tr>
								<td align="center" class="clsQueryHeading"><nobr>PAYMENT_CARD_NUMBER</nobr></td>
								<td align="center" class="clsQuery"><nobr><%=request.getParameter("ECOM_PAYMENT_CARD_NUMBER")%></nobr></td>
							</tr>
						</address>
					</div>
					
					<tr>
								<td align="center" class="thick-line"><nobr>LITE_ORDER_AMOUNT</nobr></td>
								<td align="center" class="clsQuery"><nobr><%=request.getParameter("LITE_ORDER_AMOUNT")%></nobr></td>
							</tr>
					
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<strong>Order summary</strong>
						</h3>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-condensed">
								<thead>
									<tr>
										<td><strong>Item</strong></td>
										<td class="text-center"><strong>Price</strong></td>
										<td class="text-center"><strong>Quantity</strong></td>
										<td class="text-right"><strong>Totals</strong></td>
									</tr>
								</thead>
								<tbody>
									<!-- foreach ($order->lineItems as $line) or some such thing here -->
									<tr>
										<td>BS-200</td>
										<td class="text-center">$10.99</td>
										<td class="text-center">1</td>
										<td class="text-right">$10.99</td>
									</tr>

									<tr>
										<td class="thick-line"></td>
										<td class="thick-line"></td>
										<td class="thick-line text-center"><strong>Subtotal</strong></td>
										<td class="thick-line text-right">$10.99</td>
									</tr>
									<tr>
										<td class="no-line"></td>
										<td class="no-line"></td>
										<td class="no-line text-center"><strong>Shipping</strong></td>
										<td class="no-line text-right">$15</td>
									</tr>
									<tr>
										<td class="no-line"></td>
										<td class="no-line"></td>
										<td class="no-line text-center"><strong>Total</strong></td>
										<td class="no-line text-right">$685.99</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>