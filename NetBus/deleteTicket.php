<?php
require "conn.php";

$busNo=$_POST['busNo'];
		$sql="DELETE FROM `seats` WHERE busNo='$busNo'";
		if($result =$conn->query($sql)){
			echo "All the Bus Ticket delete sucessfully.";
		}else
		{
			echo "Bus Ticket delete is failed!.";
		}
	
?>