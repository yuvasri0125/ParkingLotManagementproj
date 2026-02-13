<%@ page import="com.wipro.parking.bean.ParkingBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parking Record Details</title>
</head>
<body>

<h3>Parking Record Details</h3>

<%
ParkingBean bean = (ParkingBean) request.getAttribute("parkingBean");

if (bean == null) {
%>
    <h4>No matching records exists! Please try again!</h4>
<%
} else {
%>

<table border="1" cellpadding="5" cellspacing="0">
<tr>
    <th>Record ID</th>
    <td><%= bean.getRecordId() %></td>
</tr>
<tr>
    <th>Vehicle Number</th>
    <td><%= bean.getVehicleNumber() %></td>
</tr>
<tr>
    <th>Slot Number</th>
    <td><%= bean.getSlotNumber() %></td>
</tr>
<tr>
    <th>Entry Date</th>
    <td><%= bean.getEntryDateTime() %></td>
</tr>
<tr>
    <th>Charges</th>
    <td><%= bean.getCharges() %></td>
</tr>
<tr>
    <th>Remarks</th>
    <td><%= bean.getRemarks() == null ? "" : bean.getRemarks() %></td>
</tr>
</table>

<%
}
%>

<br><br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
