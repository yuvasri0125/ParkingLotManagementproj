<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Parking</title>
</head>
<body>

<h3>View Parking Record</h3>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="viewRecord">

Vehicle Number:
<input type="text" name="vehicleNumber" required><br><br>

Entry Date & Time:
<input type="datetime-local" name="entryDateTime" required><br><br>

<input type="submit" value="View Record">

</form>

</body>
</html>
