<hr/>

      <footer>
        <p>&copy; nemaji-guptaji 2013</p>
      </footer>

    </div><!--/.fluid-container-->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./js/jquery.js"></script>
    <script src="./js/bootstrap-transition.js"></script>
    <script src="./js/bootstrap-alert.js"></script>
    <script src="./js/bootstrap-modal.js"></script>
    <script src="./js/bootstrap-dropdown.js"></script>
    <script src="./js/bootstrap-scrollspy.js"></script>
    <script src="./js/bootstrap-tab.js"></script>
    <script src="./js/bootstrap-tooltip.js"></script>
    <script src="./js/bootstrap-popover.js"></script>
    <script src="./js/bootstrap-button.js"></script>
    <script src="./js/bootstrap-collapse.js"></script>
    <script src="./js/bootstrap-carousel.js"></script>
    <script src="./js/bootstrap-typeahead.js"></script>
    <script src="./js/drophover.js"></script>

	<script>
    $(document).ready(function() {
		$('.js-activated').dropdownHover().dropdown();
		$menu = $('.dropdown-menu');
		$menu.css('min-width', ($('body').width()*0.2)+'px');
    });
	$(window).resize(function() {
		$menu = $('.dropdown-menu');
		$menu.css('min-width', ($('body').width()*0.3)+'px');
    });
  </script>
	

  </body>
</html>
