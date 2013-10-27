

<div class="container-fluid">
	
	
	
	<h3>Top Gifts for CategoryOne</h3>
    <div class="well well-small">
	<div class="carousel slide" id="MenSlider">
		<div class="carousel-inner">
			<li class="item active"> <!-- first item is to be set active -->
				<h4>Sub-category#1 for CategoryOne </h4>
				<ul class="row-fluid thumbnails">
					<%for (int i=0; i<5; i++){%> <!-- at max 5 items can be added to one category -->
					<li class="span2">
						<div class="square thumbnail">
							<div class="inner"
								 style="background:url('http://placehold.it/260x180');background-size:contain;background-position:center; background-repeat:no-repeat;"></div>
							<div class="caption text-center">
								<p>
									${entry.title}<small> (${entry.price})</small>
								</p>
							</div>
						</div>
					</li>
					<%}%>
				</ul>
			</li>

			<% for (int subcategory=2; subcategory<4; subcategory++){ %>
			<div class="item">
				<h4>Sub-category#<%= subcategory %> for Category#1</h4>
				<ul class="row-fluid thumbnails">
					<%for (int i=0; i<5; i++){ /* DO NOT ADD MORE THAN 5 Products is one item*/ %>
					<li class="span2">
						<div class="square thumbnail">
							<div class="inner"
								 style="background:url('http://placehold.it/260x180');background-size:contain;background-position:center; background-repeat:no-repeat;"></div>
							<div class="caption text-center">
								<p>
									${entry.title}<small> (${entry.price})</small>
								</p>
							</div>
						</div>
					</li>
					<%}%>
				</ul>
			</div>
			<%}%>
		</div>
		<a data-slide="prev" href="#MenSlider" class="left carousel-control">&lsaquo;</a>
		<a data-slide="next" href="#MenSlider" class="right carousel-control">&rsaquo;</a>
    </div>
	</div>
		<hr/>
		
		
		
		
	<h3>Top Gifts for CategoryTwo</h3>
    <div class="well well-small">
	<div class="carousel slide" id="WomenSlider">
		<div class="carousel-inner">
			<li class="item active"> <!-- first item is to be set active -->
				<h4>Sub-category#1 for CategoryTwo </h4>
				<ul class="row-fluid thumbnails">
					<%for (int i=0; i<5; i++){%> <!-- at max 5 items can be added to one subcategory -->
					<li class="span2">
						<div class="square thumbnail">
							<div class="inner"
								 style="background:url('http://placehold.it/260x180');background-size:contain;background-position:center; background-repeat:no-repeat;"></div>
							<div class="caption text-center">
								<p>
									${entry.title}<small> (${entry.price})</small>
								</p>
							</div>
						</div>
					</li>
					<%}%>
				</ul>
			</li>

			<% for (int subcategory=2; subcategory<4; subcategory++){ %>
			<div class="item">
				<h4>Sub-category#<%= subcategory %> for CategoryTwo</h4>
				<ul class="row-fluid thumbnails">
					<%for (int product=0; product<5; product++){ /* DO NOT ADD MORE THAN 5 Products in one subcategory*/ %>
					<li class="span2">
						<div class="square thumbnail">
							<div class="inner"
								 style="background:url('http://placehold.it/260x180');background-size:contain;background-position:center; background-repeat:no-repeat;"></div>
							<div class="caption text-center">
								<p>
									${entry.title}<small> (${entry.price})</small>
								</p>
							</div>
						</div>
					</li>
					<%}%>
				</ul>
			</div>
			<%}%>
		</div>
		<a data-slide="prev" href="#WomenSlider" class="left carousel-control">&lsaquo;</a>
		<a data-slide="next" href="#WomenSlider" class="right carousel-control">&rsaquo;</a>
    </div>
	</div>
</div>