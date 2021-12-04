<?php
require "conn.php";

$userName=$_POST['userName'];
$travelName=$_POST["travelName"];
$busNo=$_POST["busNo"];
$price=$_POST["price"];
$seatNo=$_POST["seatNo"];
$source=$_POST["source"];
$destination=$_POST["destination"];
$date=$_POST["date"];
$departureTime=$_POST["departureTime"];


$mysql_qry="INSERT INTO `seats`(`userName`, `travelName`, `busNo`, `price`, `seatNo`, `source`, `destination`, `date`, `departureTime`) VALUES ('$userName','$travelName','$busNo','$price','$seatNo','$source','$destination','$date','$departureTime')";

if(mysqli_query($conn,$mysql_qry)){
	
	echo "Your Seat has Booked Successfully.";
	
}else{
		echo "Seat Booked is failed.";
}
?>