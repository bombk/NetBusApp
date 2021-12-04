<?php
define('HOST','localhost');
define('USER','root');
define('PASS','');
define('DB','netbus');

 
$con = mysqli_connect(HOST,USER,PASS,DB);

$busNo  = $_GET['busNo'];
 
$sql = "select * from seats where busNo='$busNo'";
 
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,array('ticketNumber'=>$row[0],
'travelName'=>$row[2],
'busNo'=>$row[3],
'price'=>$row[4],
'seatNo'=>$row[5],
'source'=>$row[6],
'destination'=>$row[7],
'date'=>$row[8],
'departureTime'=>$row[9]

));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>
