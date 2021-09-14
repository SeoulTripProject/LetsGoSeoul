<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Hero Start-->
        <div class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center pt-50">
                            <h2>FreeBoard</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<!--Hero End -->
<!--================Blog Area =================-->
        <section class="blog_area section-padding">
            <div class="container">
                <div class="row">
                  <div class="button-group-area mt-40">
				    <a href="../board/freeboard_insert.do" class="genric-btn primary circle">New</a>
				    
                    <div class="col-lg-8 mb-5 mb-lg-0">
                        <div class="blog_left_sidebar">
                            <article class="blog_item">

                                <div class="blog_details">
                                  <c:forEach var="vo" items="${list }">
                                    <a class="d-inline-block" href="../board/freeboard_detail.do?no=${vo.no }">
                                        <h2>${vo.subject }</h2>
                                    </a>
                                    <p>${vo.content }</p>
                                    <ul class="blog-info-link">
                                        <li><i class="fa fa-user"></i>${vo.name }</li>
                                        <li><i class="fa fa-comments"></i>${vo.regdate }</a></li>
                                        <li><i class="fa fa-comments"></i>${vo.hit }</a></li>
                                    </ul>
                                  </c:forEach>
                                </div>
                            </article>
                            <nav class="blog-pagination justify-content-center d-flex">
                                <ul class="pagination">
                                   <c:if test="${curpage>BLOCK }">
						          <li class="page-item"><a href="../board/freeboard.do?page=${startPage-1 }" class="page-link"><span class="ti-angle-left"></span></a></li>
						          </c:if>
						            <c:forEach var="i" begin="${startPage }" end="${ endPage}">
						               <c:if test="${curpage==i }">
						                 <c:set var="ss" value="class=current"/>
						               </c:if>
						               <c:if test="${curpage!=i }">
						                 <c:set var="ss" value=""/>
						               </c:if>
						              <li class="page-item" ${ss }><a class="page-link" href="../board/freeboard.do?page=${i }">${i }</a></li>
						            </c:forEach>  
						            <c:if test="${endPage<totalpage }">
						             <li class="page-item"><a href="../board/freeboard.do?page=${endPage+1 }" class="page-link"><span class="ti-angle-right"></span></a></li>
						            </c:if>
                                    
                                </ul>
                            </nav>
                        </div>
                    </div>
                    
<!--                     <div class="col-lg-4">
                        <div class="blog_right_sidebar">
                            <aside class="single_sidebar_widget search_widget">
                                <form action="#">
                                    <div class="form-group">
                                        <div class="input-group mb-3">
                                            <input type="text" class="form-control" placeholder='Search Keyword'
                                                onfocus="this.placeholder = ''"
                                                onblur="this.placeholder = 'Search Keyword'">
                                            <div class="input-group-append">
                                                <button class="btns" type="button"><i class="ti-search"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                    <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                                        type="submit">Search</button>
                                </form>
                            </aside>

                            <aside class="single_sidebar_widget post_category_widget">
                                <h4 class="widget_title">Category</h4>
                                <ul class="list cat-list">
                                    <li>
                                        <a href="#" class="d-flex">
                                            <p>Resaurant food</p>
                                            <p>(37)</p>
                                        </a>
                                    </li>
                                </ul>
                            </aside>

                            <aside class="single_sidebar_widget newsletter_widget">
                                <h4 class="widget_title">Newsletter</h4>

                                <form action="#">
                                    <div class="form-group">
                                        <input type="email" class="form-control" onfocus="this.placeholder = ''"
                                            onblur="this.placeholder = 'Enter email'" placeholder='Enter email' required>
                                    </div>
                                    <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                                        type="submit">Subscribe</button>
                                </form>
                            </aside>
                        </div>
                    </div> -->
                    </div>
                </div>
            </div>
        </section>
<!--================Blog Area =================-->

</body>
</html>