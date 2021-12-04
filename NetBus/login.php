<?php
require "conn.php";



$stmt=$conn->prepare("SELECT Id,userName from register;");


$stmt->execute();
$stmt->bind_result($Id,$userName);

$bus=array();
while($stmt->fetch()){
	
	$temp=array();
	$temp['Id']=$Id;
	$temp['userName']=$userName;
	array_push($bus,$temp);
}
echo json_encode($bus)


?>

   