<?php
define('HOST','localhost');
define('USER','root');
define('PASS','');
define('DB','netbus');

 
$con = mysqli_connect(HOST,USER,PASS,DB);

$sql = "select * from busdetails";
 
$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
array_push($result,array(
'travelName'=>$row[1],
'busNo'=>$row[2],
'totalSeat'=>$row[3],
'source'=>$row[4],
'destination'=>$row[5],
'price'=>$row[6],
'date'=>$row[7],
'departureTime'=>$row[8]

));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);
 
?>