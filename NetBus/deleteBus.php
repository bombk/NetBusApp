
<?php
require "conn.php";

$busNo=$_POST['busNo'];
		$sql="DELETE FROM `busdetails` WHERE busNo='$busNo'";
		if($result =$conn->query($sql)){
			echo "Bus Details delete sucessfully.";
		}else
		{
			echo "Bus Details delete is failed!.";
		}
	
?>