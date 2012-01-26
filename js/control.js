window.onload = function() {
	document.onselectstart = function() {
		// return false;
	} // ie
	document.onmousedown = function() {
		// return false;
	} // mozilla
}

jQuery.fn.noSelect = function() {
	function f() {
		return false;
	}
	return this.each(function() {
		// Since the string 'none' is used three times, storing it in a variable
		// gives better results after minification
		var none = 'none';
		this.onselectstart = this.ondragstart = f; // WebKit & IE
		jQuery(this).mousedown(f) // WebKit & Opera
		.css({
			MozUserSelect : none,
			WebkitUserSelect : none,
			userSelect : none
		});
	});
};
function rotateMovable(){
$('#container').noSelect();
	$('#box').noSelect();

	$('#box').bind('mousewheel', function(event, delta) {
		if (delta > 0) {
			lastRad = lastRad + 10;
			rotateBy(lastRad);

		} else {
			lastRad = lastRad - 10;
			rotateBy(lastRad);
		}
		return false;

	});

	var bPos = $("#box").offset();
	var bWidth = $("#box").width();
	var bHeight = $("#box").height();

	var center_top = (bHeight + bPos.top) - (bHeight / 2) - 16;
	var center_left = (bWidth + bPos.left) - (bWidth / 2) - 16;

	$(document).mousemove(function(e) {
		window.mouseXPos = e.pageX;
		window.mouseYPos = e.pageY;
	});
	var oldrad;
	var lastRad = 0;
	var intervalId;
	$("#box").mousedown(function(e) {
		var bPos = $("#box").offset();
		var bWidth = $("#box").width();
		var bHeight = $("#box").height();
		var center_top = (bHeight + bPos.top) - (bHeight / 2);
		var center_left = (bWidth + bPos.left) - (bWidth / 2);
		y = center_top - window.mouseYPos;
		x = window.mouseXPos - center_left;

		clickrad = 360 - (180 / Math.PI) * Math.atan2(y, x);

		oldrad = lastRad;
		// alert(oldrad);
		clearInterval(intervalId);

		intervalId = setInterval(function() {
			y = center_top - window.mouseYPos;
			x = window.mouseXPos - center_left;

			rad = 360 - (180 / Math.PI) * Math.atan2(y, x);
			diff = clickrad - rad;
			rad = oldrad - diff;
			lastRad = rad;
			rotateBy(rad);

		}, 50);
	}).mouseup(function() {
		// alert(intervalId);
		clearInterval(intervalId);
	});
	function rotateBy(rad) {

		$("#box").css("transform", "rotate(" + rad + "deg)");
		$("#box").css("-moz-transform", "rotate(" + rad + "deg)");
		$("#box").css("-webkit-transform", "rotate(" + rad + "deg)");
		$("#box").css("-o-transform", "rotate(" + rad + "deg)");
	}


}
$(document).ready(function() {
		rotateMovable();

});
