<%@ page import="java.util.List" %>
<%@ page import="com.wipro.parking.bean.ParkingBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Parking Records</title>
</head>
<body>

<h3>All Parking Records</h3>

<%
List<ParkingBean> list = (List<ParkingBean>) request.getAttribute("parkingList");

if (list == null || list.size() == 0) {
%>
    <h4>No records available!</h4>
<%
} else {
%>

<table border="1" cellpadding="5" cellspacing="0">
<tr>
    <th>Record ID</th>
    <th>Vehicle Number</th>
    <th>Slot Number</th>
    <th>Entry Date</th>
    <th>Charges</th>
    <th>Remarks</th>
</tr>

<%
for (ParkingBean bean : list) {
%>
<tr>
    <td><%= bean.getRecordId() %></td>
    <td><%= bean.getVehicleNumber() %></td>
    <td><%= bean.getSlotNumber() %></td>
    <td><%= bean.getEntryDateTime() %></td>
    <td><%= bean.getCharges() %></td>
    <td><%= bean.getRemarks() == null ? "" : bean.getRemarks() %></td>
</tr>
<%
}
%>

</table>

<%
}
%>

<br><br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
