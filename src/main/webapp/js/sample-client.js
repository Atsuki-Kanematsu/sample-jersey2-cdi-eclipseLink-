// need scripts
//  - sample-path.js
//  - jquery-1.11.3.min.js
jQuery.support.cors = true;

var sampleClient;
$(document).ready(function(){
	sampleClient = new SampleClient();
	sampleClient.init();
});

var SampleClient = function() {
	init : function() {
		$.ajaxSetup({
			contentType : 'application.json'
		});
	}
	get : function(apiName, parameters, foundHandler) {
		$.getJSON(SAMPLE.URL(apiName), parameters, function(data){
			if (data.returnCode == "0000" && foundHandler) {
				foundHandler(data.value);
				return;
			};
			sampleClient.raiseSystemError(data.returnCode, data.message);
		});
	},
	search : function(apiName, parameters, foundHandler, notfoundHandler) {

	},
	validate : function(apiName, parameters, invalidHandler, validHandler) {

	},
	save : function(apiName, parameters, invalidHandler, registeredHandler) {

	},
	remove : function(apiName, parameters, registeredHandler) {

	},
	raiseSystemError : function(errorCode, message) {

	}

}