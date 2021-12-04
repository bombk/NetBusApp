<?php
require "conn.php";

$travelName=$_POST["travelName"];
$busNo=$_POST["busNo"];
$totalSeat=$_POST["totalSeat"];
$source=$_POST["source"];
$destination=$_POST["destination"];
$price=$_POST["price"];
$date=$_POST["date"];
$departureTime=$_POST["departureTime"];


$mysql_qry="INSERT INTO `busdetails`(`travelName`, `busNo`, `totalSeat`, `source`, `destination`, `price`, `date`, `departureTime`) VALUES ('$travelName','$busNo','$totalSeat','$source','$destination','$price','$date','$departureTime')";

if(mysqli_query($conn,$mysql_qry)){
	
	echo "Register Successfully.";
	
}else{
		echo "Data not Registered.";
}
?>