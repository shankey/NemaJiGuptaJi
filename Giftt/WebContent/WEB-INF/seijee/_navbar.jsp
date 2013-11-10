<div class="col-xs-12" style="height: 200px; background-color: transparent;">
			<div class="navbar navbar-inverse" data-spy="affix" data-offset-top="88">
				<div class="inner">
					<div class="container text-center" style="height: 90px; ">
						
					</div>
					<div id="main-nav" class="row">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">TheGift.com</a>
						</div>
						<div class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<c:forEach var="entry" items="${topNav}">
								<li class="dropdown">
									<a href="" class="dropdown-toggle js-activated" data-toggle="dropdown">${entry.categoryName} <b class="caret"></b></a>
									<div class="dropdown-menu">
										<c:forEach var="subEntry" items="${entry.subCategory}">
										<ul class="col-xs-4">
											<li class="dropdown-header">Heading</li>
											<c:forEach var="value" items="${subEntry}">
											<li><a href="result.jsp"><c:out value="${value}"></c:out></a></li>
											</c:foreach>
										</ul>
										</c:foreach>
									</div>
								</li>
								</c:foreach>
								
								<li onclick="search() "><a>Custom Search</a></li>

							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li class="active"><a href="./">FB</a></li>
							</ul>
						</div><!--/.nav-collapse -->
					</div>
				</div>
				<div id="search" class="col-xs-12 closed">
					<!--div class="container">
						<input type="number" class="pull-left" />
						<select>
							<optgroup>
								<option value="christmas">Christmas</option>
								<option value="newYear">New Year</option>
								<option value="birthday">BirthDay</option>
								<option value="anniversary">anniversary</option>
								<option value="wedding">Wedding</option>
								<option value="promotion">Promotion</option>
								<option value="babyShower">Baby shower</option>
							</optgroup>
						</select>
						<input type="range" />
					
					</div-->
					<form class="container form" role="form">
						<div class="col-xs-3 form-group">
							<label class="" for="">Occasion</label>
							<select class="form-control" size="5" >
							
								<option value="christmas">Christmas</option>
								<option value="newYear">New Year</option>
								<option value="birthday">BirthDay</option>
								<option value="anniversary">anniversary</option>
								<option value="wedding">Wedding</option>
								<option value="promotion">Promotion</option>
								<option value="babyShower">Baby shower</option>
							
							</select>
						</div>
						<div class="col-xs-3 form-group">
							<label class="" for="">Age</label>
							<select class="form-control" size="5">
								<option value="">0-10</option>
								<option value="">11-17</option>
								<option value="">18-22</option>
								<option value="">22-30</option>
								<option value="">31-60</option>
								<option value="">>60</option>
							</select>
						</div>
						<div class="col-xs-3 form-group">
							<label class="" for="">Relation</label>
							<select class="form-control" size="5">
								<option value="">Dad</option>
								<option value="">Mom</option>
								<option value="">Brother</option>
								<option value="">Sister</option>
								<option value="">Friend</option>
								<option value="">Boy Friend</option>
								<option value="">Girl Friend</option>
								<option value="">Boss</option>
								<option value="">Colleague</option>
							</select>
						</div>
						<div class="col-xs-3 form-group">
							<label class="" for="">Price</label>
							<input type="number" class="form-control" />
							<div class="checkbox">
							<label>
								<input type="checkbox"> Remember me
							</label>
								<button type="submit" class="btn btn-success pull-right">Search</button>
						</div>
						</div>
						<!--div class="form-group">
							<label class="" for="exampleInputPassword2">Password</label>
							<input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password">
						</div-->
						
						
					</form>
				</div>
			</div>
		</div>