<?php
	header('Content-type: application/json');
	$status = array(
		'type'=>'success',
		'message'=>'Email sent!'
	);

    $name = @trim(stripslashes($_POST['uname'])); 
    $email = @trim(stripslashes($_POST['pass'])); 
    $subject = "User name Password for handover app"; 
    $message = "sfagasgg"; 

    $email_from = 'preetish.kamath@gmail.com';
    $email_to = $email;

    $body = 'Name: ' . $name . "\n\n" . 'Email: ' . $email . "\n\n" . 'Subject: ' . $subject . "\n\n" . 'Message: ' . $message;

    $success = @mail($email_to, $subject, $body, 'From: <'.$email_from.'>');

    echo json_encode($status);
    die; 
	?>