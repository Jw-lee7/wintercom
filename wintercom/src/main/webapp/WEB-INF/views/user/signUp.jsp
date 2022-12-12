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
	<section class="ftco-section" style="background-image: url('../resources/signUp/images/wintercom_signUp.jpg');">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">WINTERCOME SIGN UP</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-7 col-lg-6 col-xl-5">
					<div class="login-wrap p-4 p-md-5">
						<div class="icon d-flex align-items-center justify-content-center" style="background-image: url('../resources/signUp/images/mini_wintercom.png');">
							<span class="fa fa-edit"></span>
						</div>
						<h3 class="text-center mb-4">Create Your Account</h3> 
						<form action="/user/signUpProc" class="signup-form" method="post"
							name="signUpForm">

							<div class="form-group mb-3">
								<span style="color: #ff0018;">*</span>
								<label class="label" for="id">ID <span style="color: #ff0018;">(5 ~ 15길이의 영문자 또는 숫자)</span></label><br> 
								<input type="text" class="form-control" name="id" maxlength="15"
									required="required" style="float: left; width: 196px;">
								<input type="button" class="btn btn-primary" value="ID Check"
									onclick="fn_idCk();"
									style="margin-left: 15px; margin-top: 7px;">
							</div>

							<div class="form-group mb-3">
								<span style="color: #ff0018;">*</span>
								<label class="label" for="password">Password <span style="color: #ff0018;">(영문,숫자,특수문자를 포함한 8~15자리)</span></label><br> <input
									type="password" class="form-control" name="pw" id="pw"
									maxlength="15" required="required">
							</div>

							<div class="form-group mb-3">
								<span style="color: #ff0018;">*</span>
								<label class="label" for="re-password">Re-Password</label><br>
								<input type="password" class="form-control" name="pw2" id="pw2"
									maxlength="15" required="required"> <font id="pwCk"
									size="2"></font><br>
							</div>

							<div class="form-group mb-3">
								<span style="color: #ff0018;">*</span>
								<label class="label" for="name">Name</label><br> <input
									type="text" class="form-control" name="name" id="name"
									required="required">
							</div>

							<div class="form-group mb-3">
								<span style="color: #ff0018;">*</span>
								<label class="label" for="email">Email</label><br> <input
									type="email" class="form-control" name="email" id="email"
									required="required"> <font id="emailCk" size="2"></font><br>
							</div>

							<div class="form-group mb-3">
								<span style="color: #ff0018;">*</span>
								<label class="label" for="tel">Tel <span style="color: #ff0018;">('-'를 제외하고 입력해주세요.)</span></label><br> <input
									type="tel" class="form-control" name="tel" id="tel"
									required="required"
									maxlength="11" pattern="[0-9]{3}[0-9]{4}[0-9]{4}">
							</div>

							<div class="form-group mb-3">
								<label class="label" for="postcode">Postcode<span style="color: #28a745;"> (선택)</span></label><br>
								<input type="text" class="form-control" name="postcode"
									id="postcode" style="float: left; width: 196px;"> <input
									type="button" class="btn btn-primary" value="Search"
									onclick="sample6_execDaumPostcode()"
									style="margin-left: 15px; margin-top: 7px;">
							</div>

							<div class="form-group mb-3">
								<label class="label" for="addr">Addr<span style="color: #28a745;"> (선택)</span></label><br> <input
									type="text" class="form-control" name="addr" id="addr">
							</div>

							<div class="form-group mb-3">
								<label class="label" for="detailAddr">DetailAddr<span style="color: #28a745;"> (선택)</span></label><br>
								<input type="text" class="form-control" name="detailAddr"
									id="detailAddr">
							</div>


							<!-- <div class="form-group d-md-flex">
	            	<div class="w-100 text-left">
		            	<label class="checkbox-wrap checkbox-primary">I agree all statements in terms of service
									  <input type="checkbox" checked>
									  <span class="checkmark"></span>
									</label>
								</div>
	            </div> -->
							<div class="form-group">
								<input type="button"
									class="form-control btn btn-primary rounded submit px-3"
									value="Sign Up" onclick="signUpProc()" id="btn_submit">
							</div>
						</form>
						<p>
							I'm already a member! <a data-toggle="tab" href="/user/login">Login</a>
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