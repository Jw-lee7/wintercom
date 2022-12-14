<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Wintercome 회원가입</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="../resources/signUp/fonts/icomoon/style.css">
<link rel="stylesheet" href="../resources/signUp/css/owl.carousel.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../resources/signUp/css/bootstrap.min.css">
<!-- Style -->
<link rel="stylesheet" href="../resources/signUp/css/style.css">
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js" type="text/javascript"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- 구글폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">

</head>
<body>
	<section class="ftco-section" style="background-image: url('../resources/signUp/images/wintercom_signUp.jpg')">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Wintercom 회원가입 성공!</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-7 col-lg-6 col-xl-5">
					<div class="login-wrap p-4 p-md-5">
					<div class="icon d-flex align-items-center justify-content-center" style="background-image: url('../resources/signUp/images/sign_success.png');">
							<span class="fa fa-edit"></span>
						</div>
						<input type="hidden" value="${userId}" id="userId">
						<h3 class="text-center mb-4">${userId}님 Wintercom 회원가입을 축하드립니다!</h3>

						<p>
							Wintercom을 이용하기 위해서는 이메일 인증이 필요합니다.<br> 등록된 이메일의 메일함에서
							확인해주세요.<br> <a data-toggle="tab" href="/user/login">Login</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>

<script src="../resources/signUp/js/jquery-3.3.1.min.js"></script>
<script src="../resources/signUp/js/popper.min.js"></script>
<script src="../resources/signUp/js/bootstrap.min.js"></script>
<script src="../resources/signUp/js/main.js"></script>
<script src="../resources/signUp/js/signUp/signUp.js"></script>
</body>
</html>