<?php
require "conn.php";

$source  = $_GET['source'];
$destination  = $_GET['destination'];
 


$stmt=$conn->prepare("SELECT Id,travelName,busNo,totalSeat,source,destination,price,date,departureTime from busdetails where source='$source' and destination='$destination';");


$stmt->execute();
$stmt->bind_result($Id,$travelName,$busNo,$totalSeat,$source,$destination,$price,$date,$departureTime);

$bus=array();
while($stmt->fetch()){
	
	$temp=array();
	$temp['travelName']=$travelName;
	$temp['busNo']=$busNo;
	$temp['totalSeat']=$totalSeat;
	$temp['price']=$price;
	$temp['source']=$source;
	$temp['destination']=$destination;
	$temp['date']=$date;
	$temp['departureTime']=$departureTime;
	array_push($bus,$temp);
}
echo json_encode($bus)

?>