var SAMPLE;
$(document).ready(function(){
	SAMPLE = new SAMPLE_CONFIG();
});

SAMPLE_CONFIG.prototype = {
	protocol : "http",
	host     : "localhost",
	port     : "8080",
	context  : "/jer2/api",
	this.URL : function(apiName) {
		var url = "";
		url += protocol + "://";
		url += host;
		if (!((protocol == "http" && port == "80") || (protocol == "https" && port == "443"))) {
			url += ":" + port;
		}
		url += context;
		return url;
	}
}