describe("the vending machine page", function() {
	var subject;

	beforeEach(function() {
		$("body").append(
			'<div id="fragment">' +
			'</div>'
		);

		subject = MainPage;
		subject.init();
	});

	afterEach(function() {
		$("#fragment").remove();
		subject = null;
	});
});
