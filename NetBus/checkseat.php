<?php
require "conn.php";

$busNo=$_POST["busNo"];
$seatNo=$_POST["seatNo"];

$mysql_qry="select * from seats where busNo='$busNo' and seatNo='$seatNo'";

$result=mysqli_query($conn,$mysql_qry);

if(mysqli_num_rows($result)>0){
echo "Seat ".$seatNo." is booked";
}
else{
	echo"Seat ".$seatNo." is available";
}
?>