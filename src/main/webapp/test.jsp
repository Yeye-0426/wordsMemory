<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="jdbc.entity.Word"
    import ="jdbc.dao.WordDaoImpl"
    import ="jdbc.entity.Exam"
    import ="jdbc.dao.ExamDaoImpl"
%>
<!DOCTYPE html>
<html lang="cn">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>test</title>

<!-- Custom fonts for this template-->
<link href="fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.jsp">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					Words<sup>remeber</sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="index.jsp">
					<i class="fas fa-fw fa-home"></i> <span>首页</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item active"><a class="nav-link"
				href="learn.jsp"> <i class="fas fa-fw fa-book-open"></i> <span>学习</span></a>
			</li>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item active"><a class="nav-link" href="test.jsp">
					<i class="fas fa-fw fa-edit"></i> <span>测试</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item active"><a class="nav-link"
				href="word-list.jsp"> <i class="fas fa-fw fa-table"></i> <span>词库</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>
		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form action="SearchServlet" 
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
								<input type="text" name="searchword" 
								class="form-control bg-light border-0 small"
								placeholder="查找" aria-label="Search"
								aria-describedby="basic-addon2">
								<button class="btn btn-primary" type="submit">
									<i class="fas fa-search fa-sm"></i>
								</button>
						</div>
					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow">
						<a class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> 
							<%out.print(session.getAttribute("uname"));%>
							<span class="mr-2 d-none d-lg-inline text-gray-600 small"></span>
								<i class='far fa-user-circle fa-2x'></i>
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="user-setting.jsp"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									设置
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									退出登录
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->



                <!-- Begin Page Content -->
                <%  
                	if(session.getAttribute("ExamId")==null){
						response.sendRedirect("ExamServlet");
					}else{
						ExamDaoImpl ExamDao = new ExamDaoImpl();
						int examId = (int)session.getAttribute("ExamId");
						Exam exam = ExamDao.findById(examId);
						
						int ch = 0;
						int right = exam.getRightindex();
						
                %>
                <div class="container-fluid">
                    
                                <div id="myCard" class="card shadow mb-4">
                                <div id="container"  class="card-body" >
	                                <div id="face" class="card-body" >
	                                    <p><% out.print(exam.getQuestion()); %></p>
	                                </div>
	                                <div class="my-2"></div>
	                                <a id="chioce1" class="btn btn-info btn-icon-split">
                                        <span class="text"><% out.print(exam.getChoice1()); %></span>
                                    </a>
	                                <a id="chioce2" class="btn btn-info btn-icon-split">
                                        <span class="text"><%  out.print(exam.getChoice2()); %></span>
                                    </a>
	                                <a id="chioce3" class="btn btn-info btn-icon-split">
                                        <span class="text"><%  out.print(exam.getChoice3()); %></span>
                                    </a>
	                                <a id="chioce4" class="btn btn-info btn-icon-split">
                                        <span class="text"><%  out.print(exam.getChoice4()); %></span>
                                    </a>    
	                                <div id="back" class="card-body" style="backface-visibility:hidden;transform: rotateY(180deg);">
	                                <p id="myParagraph"></p>
	                                <p><%  out.print(exam.getExam_explain()); %></p>
	                                </div>
	                                <a href="ExamServlet?btn=previous" class="btn btn-success btn-icon-split">
                                        <span class="text">上一题</span>
                                    </a>
	                                <a href="ExamServlet?btn=next" class="btn btn-success btn-icon-split">
                                        <span class="text">下一题</span>
                                    </a>
                                </div>
                            </div>
                	

                </div>
                <!-- /.container-fluid -->
<script>
const cardback = document.getElementById('back');

var btn1 = document.getElementById("chioce1");
var btn2 = document.getElementById("chioce2");
var btn3 = document.getElementById("chioce3");
var btn4 = document.getElementById("chioce4");

var right = "<%=right%>";

function myFunction(ch){
	if(right==ch){
		document.getElementById("myParagraph").innerHTML = "答对啦";
	}
	else{
		document.getElementById("myParagraph").innerHTML = "答错了";
	}
}

btn1.addEventListener('click',function(ch){
	var ch = 1;
	cardback.style.transform = 'rotateY(0deg)';
	myFunction(ch);
	}, false);
btn2.addEventListener("click",function(ch){
	var ch = 2;
	cardback.style.transform = 'rotateY(0deg)';
	myFunction(ch);
	}, false);
btn3.addEventListener("click",function(ch){
	var ch = 3;
	cardback.style.transform = 'rotateY(0deg)';
	myFunction(ch);
	}, false);
btn4.addEventListener("click",function(ch){
	var ch = 4;
	cardback.style.transform = 'rotateY(0deg)';
	myFunction(ch);
	}, false);


</script>
					<% } %>


            </div>
           <!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Word Remeber 2023</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>
		
		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">真的要退出登录吗？</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">如果您确定退出登录，请单击下面的“注销”按钮。</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">取消</button>
						<a class="btn btn-primary" href ="LogoutServlet">注销</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript-->
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="js/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script src="js/Chart.min.js"></script>

		<!-- Page level custom scripts -->
		<script src="js/chart-area-demo.js"></script>
		<script src="js/chart-pie-demo.js"></script>
</body>

</html>