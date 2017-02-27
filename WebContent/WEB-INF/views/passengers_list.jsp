<%@page import="java.util.*, com.airline.models.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/jpa.css" />
<title>Passengers List</title>
</head>
<body>
	<h1>List of Passengers</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Date of birth</th>
			<th>Gender</th>
		</tr>

		<%
			List<Passenger> pList = (List<Passenger>) request.getAttribute("passengers_list");

			for (Integer i = 0; i < pList.size(); i++) { 
		%>
		<tr>
			<td><%=pList.get(i).getId()%></td>
			<td><%=pList.get(i).getFirst_name()%></td>
			<td><%=pList.get(i).getLast_name()%></td>
			<td><%=pList.get(i).getDob()%></td>
			<td><%=pList.get(i).getGender()%></td>
		</tr>
		<tr>
			<td colspan="5" >
				<%
					if(pList.get(i).getFlights().size() > 0){
						
						List<Flight> fList = (List<Flight>) pList.get(i).getFlights();
						
						for (Integer k=0; k < fList.size(); k++){
							
						
				%>
						<%= k+1 %>) <%= fList.get(k).getFlightOrigin() %> to <%= fList.get(k).getFlightDestination()%> @ <%= fList.get(k).getFlightTime() %> <br />
				<%
						}//for
					
					} else {
				%>
					No flight tickets yet.
				<%
					}
				%>
								
			</td>
		</tr> 
		<%
			}
		%>

	</table>

</body>
</html>