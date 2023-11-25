<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="jdbc.entity.Word"
    import ="jdbc.dao.WordDaoImpl"%>
<!DOCTYPE html>
<html lang="cn">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>user-setting</title>

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
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">用户名</span>
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
                <div class="container-fluid">

                    <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">用户设置</h6>
                                </div>
                                <div class="card-body">
                                <form id="usersetting" action="UserSettingServlet" method="post">
                                    <nav class="navbar navbar-light bg-light mb-4">
                                        <a class="navbar-brand" >用户名</a>
                                        <ul class="navbar-nav ml-auto"><input form="usersetting" name="user_id" placeholder="<%=session.getAttribute("uname") %>">
                                        </ul>
                                    </nav>
                                    <nav class="navbar navbar-light bg-light mb-4">
                                        <a class="navbar-brand" >邮箱</a>
                                        <ul class="navbar-nav ml-auto"><input form="usersetting" name="user_email"placeholder="<%=session.getAttribute("uemail") %>">
                                        </ul>
                                    </nav>
                                    <nav class="navbar navbar-light bg-light mb-4">
                                        <a class="navbar-brand" >密码</a>
                                        <ul class="navbar-nav ml-auto"><input form="usersetting" name="user_pass" placeholder="<%=session.getAttribute("upwd") %>">
                                        </ul>
                                    </nav>
                                    
                                    <div class="my-2"></div>
                                    <nav class="navbar navbar-expand navbar-light bg-light mb-4">
                                        <a class="navbar-brand" href="#">词库</a>
                                        <ul class="navbar-nav ml-auto">
                                            <li class="nav-item dropdown">
                                                <input form="usersetting" list="word_list" name="word_list" placeholder="选择词库" class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <datalist id="word_list" >
                                                    <option value="CET4luan_1" hidden="hidden">四级核心词</option>
                                                    <option value="CET6luan_1" >六级核心词</option>
                                                    <option value="KaoYanluan_1">考研必考</option>
                                                </datalist>
                                            </li>
                                        </ul>
                                    </nav>
                                    
                                    <div class="my-2"></div>
                                    <button form="usersetting" type="submit" class="btn btn-success btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-check"></i>
                                        </span>
                                        <span class="text">确认</span>
                                        
                                    </button>
                                    <button form="usersetting"  type="reset" class="btn btn-secondary btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-arrow-right"></i>
                                        </span>
                                        <span class="text">重置</span>
                                    </button>
                                </form>
                                </div>
                                
                                
                            </div>

                </div>
                <!-- /.container-fluid -->




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
						<a class="btn btn-primary" href="login.jsp">注销</a>
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