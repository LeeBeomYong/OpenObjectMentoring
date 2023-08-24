<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mentoring</title>

    <!-- Custom fonts for this template-->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <c:if test="${session_id == null }">
	            <li class="nav-item active">
	                <a class="nav-link" href="main_admin">
	                    <i class="fas fa-fw fa-tachometer-alt"></i>
	                    <span>Dashboard</span></a>
	            </li>
			</c:if>
			<c:if test="${session_id != null }">
	            <li class="nav-item active">
	                <a class="nav-link" href="main_admin">
	                    <i class="fas fa-fw fa-tachometer-alt"></i>
	                    <span>Dashboard</span></a>
	            </li>
			</c:if>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Page
            </div>

			<!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Pages</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
<!--                         <h6 class="collapse-header">Login Screens:</h6> -->
<!--                         <a class="collapse-item" href="login.html">Login</a> -->
<!--                         <a class="collapse-item" href="register.html">Register</a> -->
<!--                         <a class="collapse-item" href="forgot-password.html">Forgot Password</a> -->
                        <div class="collapse-divider"></div>
                        <h6 class="collapse-header">Other Pages:</h6>
<!--                         <a class="collapse-item" href="404.html">404 Page</a> -->
                        <a class="collapse-item" href="admin_boardList">admin_Board</a>
                        <a class="dropdown-item" href="admin_userList">admin_User</a>
                    </div>
                </div>
            </li>


			
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            <!-- Sidebar Message -->
            <div class="sidebar-card d-none d-lg-flex">
                <img class="sidebar-card-illustration mb-2" src="resources/img/undraw_rocket.svg" alt="...">
                <p class="text-center mb-2"><strong>SB Admin Pro</strong> is packed with premium features, components, and more!</p>
                <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to Pro!</a>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>



                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"> <c:out value="${session_name }"/> </span>
                                <img class="img-profile rounded-circle"
                                    src="resources/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="profile">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <%-- 여기서부터 작성 --%>
                    
<!-- |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| -->

<div class="notice-board">
    <div align="center">
        <div class="notice-title">
            <h1>유저 목록</h1>
        </div>
        <%-- 검색 폼 --%>
        <div class="mb-3" style = "width: 30%;">
		    <div class="search-container">
		      <form action="<c:url value="admin_userList"/>" class="search-form" method="get">
		        <select class="form-control" name="option" style = "width: 30%; float: left;">
		          <option value="i" ${ph.sc.option=='i' ? "selected" : ""}>아이디</option>
		          <option value="e" ${ph.sc.option=='e' ? "selected" : ""}>이메일</option>
		          <option value="n" ${ph.sc.option=='n' ? "selected" : ""}>이름</option>
		        </select>
		
		        <input type="text" name="keyword" class="form-control" type="text" value="${ph.sc.keyword}" placeholder="검색어를 입력해주세요" style = "width: 50%; float: left;">
		        <input type="submit" class="btn btn-primary" value="검색" style = "float: left;">
		      </form>
<%-- 		      <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/board/write"/>'"><i class="fa fa-pencil"></i> 글쓰기</button> --%>
		    </div>
			<br><br><br>
		</div>
       
        <table id="table_font" class="table table-hover table-bordered notice-main-table" style=" text-align:center;">
            <tr class="table-light">
                <th width="10%">NO</th>
                <th width="25%">ID</th>
                <th width="25%">EMAIL</th>
                <th width="15%">NAME</th>
                <th width="10%">수정/삭제</th>
            </tr>
            <c:if test="${!empty List}">
                <c:forEach items="${List }" var="dto">
            <tr>
                <td>${dto.getUser_num()}</td>
                <td>${dto.getUser_id()}</td>
<%--                 <td><a href="board_cont?no=${dto.getBoard_id() }">${dto.getBoard_title()}</a></td> --%>
                <td>${dto.getUser_email()}</td>
                <td>${dto.getUser_name()}</td>
                <td>
                	<a href="admin_userUpdate?no=${dto.getUser_num() }"><button class="btn btn-success btn-sm">수정</button></a>
                	<a href="admin_userDelete_ok?no=${dto.getUser_num() }"><button class="btn btn-danger btn-sm" >삭제</button></a>
                </td>
            </tr>
                </c:forEach>
            </c:if>
        </table><br><br>
        <c:if test="${empty List}">
            	<h1>회원이 없습니다.</h1><br><br>
        </c:if>
        <a href="admin_userInsert"><button class="btn btn-primary btn-sm">회원 등록</button></a>
        
        <br><br><br>
        <c:if test="${totalCnt == null || totalCnt == 0 }">
        </c:if>
        <c:if test="${totalCnt != null && totalCnt != 0 }">
	        <div>
	<%--         	<c:if test="${ph.showPrev }"> --%>
	<%--         		<a href="<c:url value='/board?page=${ph.beginPage-1}&pageSize=${ph.pageSize}' />">◀</a> --%>
	<%--         	</c:if> --%>			
				<c:if test="${ph.showPrev}">
	            	<a class="page" href="<c:url value="/admin_userList${ph.sc.getQueryString(ph.beginPage-1)}"/>"><span style="font-size: 25px;">◀</span></a>
	          	</c:if>
	<%--         	<c:forEach var="i" begin="${ph.beginPage }" end="${ph.endPage }"> --%>
	<%--         		<a href="<c:url value='/board?page=${i}&pageSize=${ph.pageSize}' />">${i }</a> --%>
	<%--         	</c:forEach> --%>
				<c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
	            	<a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/admin_userList${ph.sc.getQueryString(i)}"/>"><span style="font-size: 25px;">&nbsp;&nbsp;${i}&nbsp;&nbsp;</span></a>
	          	</c:forEach>
	<%--         	<c:if test="${ph.showNext }"> --%>
	<%--         		<a href="<c:url value='/board?page=${ph.endPage+1}&pageSize=${ph.pageSize}' />">▶</a> --%>
	<%--         	</c:if> --%>
				<c:if test="${ph.showNext}">
	            	<a class="page" href="<c:url value="/admin_userList${ph.sc.getQueryString(ph.endPage+1)}"/>"><span style="font-size: 25px;">▶</span></a>
	          	</c:if>
	        </div>
        </c:if>
    </div>
    <br>
</div>


<!-- |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| -->
                    <!-- Content Row -->
                    <div class="row">

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">

                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">

                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">

                        </div>

                        <!-- Pending Requests Card Example -->

                    </div>

                    <!-- Content Row -->

                    <div class="row">

                        <!-- Area Chart -->
                        <div class="col-xl-8 col-lg-7">

                        </div>

                        <!-- Pie Chart -->
                        <div class="col-xl-4 col-lg-5">

                        </div>
                    </div>

                    <!-- Content Row -->
                    <div class="row">

                        

                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="logout">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="resources/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="resources/js/demo/chart-area-demo.js"></script>
    <script src="resources/js/demo/chart-pie-demo.js"></script>

</body>

</html>