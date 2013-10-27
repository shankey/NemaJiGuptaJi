

<div class="container-fluid" style="padding: 0px 10%;">
	<ul class="row-fluid thumbnails">
		<c:forEach var="entry" items="${asinDetailList}">
			<li class="span3">
				<div class="square thumbnail">
					<div class="inner"
						style="background:url('${entry.image}');background-size:contain;background-position:center; background-repeat:no-repeat;"></div>
					<div class="caption text-center">
						<p>
							${entry.title}<small> (${entry.price})</small>
						</p>
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>
