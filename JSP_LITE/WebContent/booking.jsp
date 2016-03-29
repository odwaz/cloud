<!--
Author: W3Layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html>
<head>
<title>Hotel Booking Widget A Flat Lure widget Template :: w3layouts</title>

<!-- For-Mobile-Apps -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Hotel Booking Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps -->

<!-- Style --> <link href="../css/StyleSheet.css" rel="stylesheet"  media="all" />
<link href="../css/jquery-ui.css"  rel="stylesheet" />
<!-- JavaScript --> <script type="text/javascript" src="js/jquery.min.js"></script>

</head>
<body>

<h1 class="book">HOTEL BOOKING ONLINE</h1>

<form METHOD="POST" ACTION="https://backoffice.iveri.co.za/Lite/Transactions/New/Authorise.aspx" id=aForm name=aForm>

<div class="reg">

		<h1>Book Your Suite!</h1>

		<div class="members">
			<div class="adult">
				<h2>No. of Adults</h2>
					<div class="dropdown-button">           			
				    	<select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"flat"}'>
								<option value="">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select>
					</div>
			</div>

			<div class="child">
				<h2>No. of Children</h2>
					<div class="dropdown-button">         			
			    		<select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"flat"}'>
							<option value="">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
			</div>
		<div class="clear"></div>
		</div>

		<div class="suite">
			<div class="dropdown-button">
				<h2>Suite</h2>           			
    			<select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"flat"}'>
					<option value="1">-</option>
					<option value="1">Single Room</option>
					<option value="2">Premium Single Room</option>
					<option value="2">Double Room</option>
					<option value="2">Premium Double Room</option>
					<option value="3">Deluxe Suite</option>
					<option value="4">Executive Suite</option>
					<option value="4">Ocean View Suite</option>
					<option value="4">Presidential Suite</option>
					<option value="3">The Penthouse</option>
				</select>
			</div>
		</div>

		<div class="book-pag">
			<h2>Select Date</h2>
			<div class="book-pag-frm1">
				<label>Check In</label>
				<input class="date" id="datepicker1" type="text" value="Date" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required="">
			</div>
			<div class="book-pag-frm2">
				<label>Check Out</label>
				<input class="date" id="datepicker2" type="text" value="Date" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required="">
			</div>
		<div class="clear"></div>
		</div>	

		<!--Date Picker-->
			
			<script src="js/jquery-ui.js"></script>
					  <script>
							  $(function() {
							    $( "#datepicker,#datepicker1,#datepicker2" ).datepicker();
							  });
					  </script>
		<!--//Date Picker-->

		<div class="rs">					
				<div class="check_box"> <div class="radio"> <label><input type="checkbox" name="radio" checked=""><i></i>Enable Room Service</label> </div></div>
		</div>

		<div class="food">
			<h2>Choose Cuisine</h2>
				<div class="radio-btns">						
					<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>Local</label> </div></div>
		            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Multi</label> </div></div>    
				</div>
		</div>

		<div class="submit">
				<input type="submit" class="book" value="BOOK NOW">
		</div>

</div>

<div class="reg-footer">
     <p>Copyright &copy; 2015 Hotel Booking Widget. All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
</div>
</form>
</body>
</html>