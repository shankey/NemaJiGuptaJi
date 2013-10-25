<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">theGifts.com</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Logged in as <a href="#" class="navbar-link">Username</a>
            </p>
            <ul class="nav">
            
            	<c:forEach var="entry" items="${topNav}">
        			<li class="dropdown">
					<a href="#" class="dropdown-toggle js-activated" data-toggle="${entry.categoryName}">${entry.categoryName}</a>
					<ul class="dropdown-menu span5">
					
						<div class="row-fluid" style="padding:15px;">
						
							<c:forEach var="subEntry" items="${entry.subCategory}">
								<div class="span4">
									<c:forEach var="value" items="${subEntry}">
										<a> <c:out value="${value}"> </c:out> </a> <br/>
									</c:forEach>
								</div>	
							</c:forEach>
						</div>
					</ul>
				</li>
        		</c:forEach>
				
			</ul>
			
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
