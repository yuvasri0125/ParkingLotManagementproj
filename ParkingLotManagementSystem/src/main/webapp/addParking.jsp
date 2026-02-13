<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Parking</title>
</head>
<body>

<h3>Add Parking Record</h3>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="newRecord">

Vehicle Number:
<input type="text" name="vehicleNumber" required><br><br>

Slot Number:
<input type="text" name="slotNumber" required><br><br>

Entry Date & Time:
<input type="datetime-local" name="entryDateTime" required><br><br>

Charges:
<input type="number" name="charges" required><br><br>

Remarks:
<input type="text" name="remarks"><br><br>

<input type="submit" value="Add Record">

</form>

</body>
</html>
