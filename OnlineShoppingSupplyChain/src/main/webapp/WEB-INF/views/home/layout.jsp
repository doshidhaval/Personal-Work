<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style type="text/css" >
#innerContainer {
  -webkit-border-radius: 20px 20px 20px 20px;
  -moz-border-radius: 20px 20px 20px 20px;
  border-radius: 20px 20px 20px 20px;
}
</style>

</head>
<body>

<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<div id="container" style="width:100%; height:100%; background-color: rgba(0,0,0,.2	)">
<div id="innerContainer" style="background-color:white;margin: 0px auto;width: 1100px;top:5pt;">
<div id="header" style="height:100px">
<tiles:insertAttribute name="header" /></div>

<div id="menu" style="height:200px;width:15%;float:left;">
<tiles:insertAttribute name="menu" /></div>
<div id="content" style="background-color:#EEEEEE;height:800px;width:70%;float:left;margin:10pt;border-radius: 10px;">
<tiles:insertAttribute name="body" /></div>

<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
<tiles:insertAttribute name="footer" /></div>
</div>
</div>

</body>
</html>
