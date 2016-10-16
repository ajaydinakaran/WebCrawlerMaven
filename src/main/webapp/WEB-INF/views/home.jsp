
<!DOCTYPE html>
<html>
<head>
<script src="/webcrawler/resources/static/js/jquery-3.1.1.min.js"> </script>
<script type="text/javascript">
			$( document ).ready(function() {  
				
				$("#getButton").on('click',function(){
					
					getLinkList();
				});
			});
			
			function getLinkList(){
				
				$.get("/webcrawler/getLinks").done(function(data) {
					renderList(data);
				}).fail(function() {
					alert("Error occured !! Please try again");
				});	
				
				
			}
			
			function renderList(json){
				var html = "";
				for (var i in json) {
					html += "<br/><b> Parent Url is "+i+"</b>";
					html += "<br/>&nbsp;&nbsp; Links are :<br/>";
				   for (var j in json[i]) {
					   html += json[i][j] +"<br/>";
				   }
				   
				}
				$('#result').html(html);
			}
				
				
			
			
   </script>
<title>Web Crawler</title>


</head>
<body>
	<a href="#" id="getButton">Link here to Crawl your application</a><br/><br/><br/><br/>
	<a href="http://localhost:8080/webcrawler/link1" id="getButton">link1</a><br/>
	<a href="http://localhost:8080/webcrawler/link2" id="getButton">link2</a>
	
	<div id="result">
	
	</div>
</body>

</html>