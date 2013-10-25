

<ul class=" container-fluid thumbnails">

		<c:forEach var="entry" items="${asinDetailList}">
			<li class="span3">
				<div class="square thumbnail">
					<div class="inner" style="background:url('${entry.image}');background-size:contain;background-position:center; background-repeat:no-repeat;">
					</div>
					<div style="position:absolute; bottom:0;" >
						<p class="pull-left">${entry.title}<small>${entry.price}</small></p>
					</div>
				</div>
			</li>
   		</c:forEach>	
</ul>
