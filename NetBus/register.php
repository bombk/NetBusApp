<?php
require "conn.php";

$userName=$_POST["userName"];
$email=$_POST["email"];
$phoneNumber=$_POST["phoneNumber"];
$password=$_POST["password"];


$mysql_qry="insert into register(userName,email,phoneNumber,password) values('$userName','$email','$phoneNumber','$password')";

if(mysqli_query($conn,$mysql_qry)){
	
	echo "Register Successfully.";
	
}else{
		echo "Data not Registered.";
}
?>