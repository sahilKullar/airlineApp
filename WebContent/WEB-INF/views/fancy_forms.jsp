<!DOCTYPE html>
<html>
<head>

<title>Java EE</title>

<style type="text/css">
.form-style-2{
	max-width: 500px;
	padding: 20px 12px 10px 20px;
	font: 13px Arial, Helvetica, sans-serif;
}
.form-style-2-heading{
	font-weight: bold;
	font-style: italic;
	border-bottom: 2px solid #ddd;
	margin-bottom: 20px;
	font-size: 20px;
	padding-top: 25px;
        padding-bottom: 5px;
}
.form-style-2 label{
	display: block;
	margin: 0px 0px 15px 0px;
}
.form-style-2 label > span{
	width: 100px;
	font-weight: bold;
	float: left;
	padding-top: 8px;
	padding-right: 5px;
}
.form-style-2 span.required{
	color:red;
}
.form-style-2 .tel-number-field{
	width: 40px;
	text-align: center;
}
.form-style-2 input.input-field{
	width: 38%;
	
}
.form-style-2 input.input-field1{
	width: 11%;
	
}

.form-style-2 input.input-field,
.form-style-2 input.input-field1,
.form-style-2 .tel-number-field, 
.form-style-2 .textarea-field, 
 .form-style-2 .select-field
 {
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	border: 1px solid #C2C2C2;
	box-shadow: 1px 1px 4px #EBEBEB;
	-moz-box-shadow: 1px 1px 4px #EBEBEB;
	-webkit-box-shadow: 1px 1px 4px #EBEBEB;
	border-radius: 3px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	padding: 7px;
	outline: none;
}
.form-style-2 .input-field:focus,
.form-style-2 .input-field1:focus,
.form-style-2 .tel-number-field:focus, 
.form-style-2 .textarea-field:focus,  
.form-style-2 .select-field:focus{
	border: 1px solid #0C0;
}
.form-style-2 .textarea-field{
	height:100px;
	width: 55%;
}
.form-style-2 button, input[type=submit],
.form-style-2 button, input[type=button]{
	border: none;
	padding: 8px 15px 8px 15px;
	background: #FF8500;
	color: #fff;
	box-shadow: 1px 1px 4px #DADADA;
	-moz-box-shadow: 1px 1px 4px #DADADA;
	-webkit-box-shadow: 1px 1px 4px #DADADA;
	border-radius: 3px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
}
.form-style-2 button, input[type=submit]:hover,
.form-style-2 button, input[type=button]:hover{
	background: #EA7B00;
	color: #fff;
}

</style>
</head>

<body>

	<div class="form-style-2">

	<h1 style= "text-decoration: underline;">Java EE</h1>
	
	<div class="form-style-2-heading">Add flight and airplane</div>
	
	<form method="POST" action="AddFlight">
	
	From:
	<select name="from_destination" class="select-field">
		<option value= "San_Francisco">San Francisco</option>
		<option value= "Los_Angeles">Los Angeles</option>
		<option value= "New_York">New York</option>
		<option value= "London">London</option>
		<option value= "Paris">Paris</option>
		<option value= "Rome">Rome</option>
		<option value= "Amsterdam">Amsterdam</option>
	</select>
	
	<br /><br />
	
	To:
	
	<select name= "to_destination" class="select-field">
		<option value= "San_Francisco">San Francisco</option>
		<option value= "Los_Angeles">Los Angeles</option>
		<option value= "New_York">New York</option>
		<option value= "London">London</option>
		<option value= "Paris">Paris</option>
		<option value= "Rome">Rome</option>
		<option value= "Amsterdam">Amsterdam</option>
	</select>
	
	<h4>Time of flight<span class="required">*</span></h4>
	<hr />

	Year:

	<select name= "year" class="select-field">
		<option value= "2015">2015</option>
		<option value= "2016">2016</option>
		<option value= "2017">2017</option>
		<option value= "2018">2018</option>
		<option value= "2019">2019</option>
		<option value= "2020">2020</option>
	</select>
	
	<br /><br />
	
	Month:
		
	<select name= "month" class="select-field">
		<option value= "0">January</option>
		<option value= "1">February</option>
		<option value= "2">March</option>
		<option value= "3">April</option>
		<option value= "4">May</option>
		<option value= "5">June</option>
		<option value= "6">July</option>
		<option value= "7">August</option>
		<option value= "8">September</option>
		<option value= "9">October</option>
		<option value= "10">November</option>
		<option value= "11">December</option>
		
	</select>
	<br /><br />
	
	Day of month:
	
	<input name="day" type="text" class="input-field"></input>
	
	<br /><br />
	
	Hour of day (0 - 23):

	<input name="hour" type="text" class="input-field"></input>
	
	<br /><br />
	
	Minute (0 - 59):
	
	<input name="minute" type="text" class="input-field"></input>
	
	<br /><br />
	
	Price:
	
	<input name="price" type="text" class="input-field"></input>
	
	<hr />
	
	<h4>Airplane<span class="required">*</span></h4>
	
	Plane make:
	
	<input name="airplane_make" type="text" class="input-field"></input>
	
	<br /><br />
	
	Model name:
	
	<input name="airplane_model" type="text" class="input-field"></input>
	
	<br /><br />
	
	Seating:
	
	<input name="airplane_seating" type="text" class="input-field"></input>
	
	<hr />
	
	<button type="submit">Add flight and airplane</button>
	
	<hr />
	
</form>

<div class="form-style-2-heading">Add pilot to flight</div>

<form method="POST" action="CreatePilotAndAddToFlight">
	
	First name:
	
	<input name="first_name" type="text" class="input-field"></input>
	
	<br /><br />
	
	Last name:
	
	<input name="last_name" type="text" class="input-field"></input>
	
	<br /><br />
	
	License:
	
	<input name="license" type="text" class="input-field"></input>
	
	<br /><br />
	
	Pilot rank:
	
	<select name= "pilot_rank" class="select-field">
		<option value="Captain">Captain</option>
		<option value="First_Officer">First Officer</option>
		<option value="Junior_Officer">Junior Officer</option>
	</select>
	
	<br /><br />
	
	Flight Id:
	
	<input name="fid" type="text" class="input-field"></input>
	
	<hr />
	
	<button type= "submit">Add pilot to flight</button>

	<hr />
	
</form>

<div class="form-style-2-heading">Add Passenger</div>

<form method="POST" action="AddPassenger">

	First name:
	
	<input name="first_name" type="text" class="input-field"></input>
	
	<br /><br />
	
	Last name:
	
	<input name="last_name" type="text" class="input-field"></input>
	
	<br /><br />
	
	Date of birth:
	
	<input name="dob" type="text" class="input-field"></input>
	
	<br /><br />
	
	Gender:
	
	<select name= "gender" class="select-field">
		<option value="Female">Female</option>
		<option value="Male">Male</option>
	</select>	
	 
	<hr />
	 
	<button type="submit">Add Passenger</button>
	
	<hr />
	
</form>

<div class="form-style-2-heading">Add passenger to flight</div>

<form method="POST" action="AddPassengerToFlight">
	
	Add a passenger with an id of
	
	<input name="pid" type="text" class="input-field1"></input>
	
	to a flight with an id of
	
	<input name="fid" type="text" class="input-field1"></input>
	
	<hr />
	
	<button type="submit">Add passenger to flight</button>
	
	<hr />
	
</form>

<div class="form-style-2-heading">Add flight to passenger</div>

<form method="POST" action="AddFlightTicketToPassenger">
	
	Add a ticket for a flight with an id of
	
	<input name= "fid" type="text" class="input-field1"></input>
	
	to a passenger with an id of
	
	<input name="pid" type="text" class="input-field1"></input>
	
	<br /><br />
	
	<span style="font-weight: bold;"></span>
	
	<hr />

	<button type="submit">Add flight to passenger's flight tickets</button>

	<hr />
</form>
</div>
</body>
</html>