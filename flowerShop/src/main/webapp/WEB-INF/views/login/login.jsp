<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ page session="true"%>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						Kakao.init("b4aa7ea6c69e8dd0aa83bf5f8fdc89c0");
						function getKakaotalkUserProfile() {
							Kakao.API
									.request({
										url : '/v1/user/me',
										success : function(res) {
											$("#kakao-profile").append(
													res.properties.nickname);
											$("#kakao-profile")
													.append(
															$(
																	"<img/>",
																	{
																		"src" : res.properties.profile_image,
																		"alt" : res.properties.nickname
																				+ "님의 프로필 사진"
																	}));
										},
										fail : function(error) {
											console.log(error);
										}
									});
						}
						function createKakaotalkLogin() {
							$(
									"#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn")
									.remove();
							var loginBtn = $("<a/>", {
								"class" : "kakao-login-btn",
								"text" : "로그인"
							});
							loginBtn.click(function() {
								Kakao.Auth.login({
									persistAccessToken : true,
									persistRefreshToken : true,
									success : function(authObj) {
										getKakaotalkUserProfile();
										createKakaotalkLogout();
									},
									fail : function(err) {
										console.log(err);
									}
								});
							});
							$("#kakao-logged-group").prepend(loginBtn)
						}
						function createKakaotalkLogout() {
							$(
									"#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn")
									.remove();
							var logoutBtn = $("<a/>", {
								"class" : "kakao-logout-btn",
								"text" : "로그아웃"
							});
							logoutBtn.click(function() {
								Kakao.Auth.logout();
								createKakaotalkLogin();
								$("#kakao-profile").text("");
							});
							$("#kakao-logged-group").prepend(logoutBtn);
						}
						if (Kakao.Auth.getRefreshToken() != undefined
								&& Kakao.Auth.getRefreshToken().replace(/ /gi,
										"") != "") {
							createKakaotalkLogout();
							getKakaotalkUserProfile();
						} else {
							createKakaotalkLogin();
						}
					});
</script>
	<div class="product-big-title-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-bit-title text-center">
						<h2>Login</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Page title area -->

	<div class="single-product-area">
		<div class="row m-n">
			<div class="col-md-4 col-md-offset-4 m-t-lg">
					<form class="form-signin" method="POST" action="${pageContext.request.contextPath }/loginPost">
						<label>아이디</label> 
						<input type="text" name="user_id" class="form-control" placeholder="ID" required autofocus> <br />
						<label>비밀번호</label>
						<input type="password" name="user_pw" class="form-control" placeholder="Password" required>
						<p>${msg}</p>
						<div class="checkbox">
							<label> 
								<input type="checkbox" name="useCookie">
								아이디 저장
							</label>
						</div><br />
						<!--input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"-->
						<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
						<input type="button" class="btn btn-lg btn-primary btn-block" value="메인으로 가기" onclick="location.href='${pageContext.request.contextPath }/main';">
					</form>

					<br>
					<!-- 카카오 로그인 -->
					<a id="kakao-login-btn"></a> 
					<a href="http://developers.kakao.com/logout"></a>
					<a href="${pageContext.request.contextPath }/mailFormId">아이디</a> / <a href="#">비밀번호 찾기</a>
				</div>
			</div>
		</div>

<script type='text/javascript'>
	//<![CDATA[
	// 사용할 앱의 JavaScript 키를 설정해 주세요.
	Kakao.init('b4aa7ea6c69e8dd0aa83bf5f8fdc89c0');
	// 카카오 로그인 버튼을 생성합니다.
	Kakao.Auth.createLoginButton({
		container : '#kakao-login-btn',
		success : function(authObj) {
			//location.href="${pageContext.request.contextPath }/kakaoLogin?code="+authObj.access_token;
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath }/kakaoLogin',
				data : "access_token=" + authObj.access_token,
				success : function() {
				}
			});
		},
		fail : function(err) {
			alert("잠시 후에 다시 시도해주세요.");
		}
	});
	//]]>
</script>
	
	<%@ include file="/WEB-INF/include/footer.jsp" %>