<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String p = request.getParameter("lang");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>周边检索</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <style type="text/css">
        #panel {
            position: fixed;
            background-color: white;
            max-height: 90%;
            overflow-y: auto;
            top: 10px;
            right: 10px;
            width: 280px;
            border-bottom: solid 1px silver;
        }
    </style>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=3f9bc1d537596690d1cdd74ac18e3b7d"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.0.0/jquery.js"></script>
</head>
<body>
<div id="container"></div>
<div id="panel"></div>
<script type="text/javascript">
var map = new AMap.Map("container", {
    resizeEnable: true
});
var ok = true;
var count= 0;
while(ok){
	if (count == 20)
		break;
	count++;
	console.log(count);
	AMap.service(["AMap.PlaceSearch"], function() {
	    var placeSearch = new AMap.PlaceSearch({ //构造地点查询类
	        pageSize: 60,
	        pageIndex: count,
	        city: "海口", //城市
	        map: map,
	        panel: "panel"
	    });
	    //关键字查询
	    placeSearch.search('公交站', function(status, result) {
	            if (status === 'complete' && result.info === 'OK') {
	                stationSearch_CallBack(result);
	                ok = true;
	            } else {
	            	ok =  false;
	                //alert(result);
	            }
		});
	});
	var t=setTimeout(1000);
	}
    function stationSearch_CallBack(searchResult) {
        var stationArr = searchResult.poiList;
        for (var i = 0;i < stationArr.pois.length;i++){
        //console.log(searchResult.poiList.pois[i].name+":"+searchResult.poiList.pois[i].location.toString());
		    $.ajax({
				type:"POST",
				aysnc:false,
				url:"Servlet",
				data:{
					"name":searchResult.poiList.pois[i].name.toString(),
					"lng":searchResult.poiList.pois[i].location.lng.toString(),
					"lat":searchResult.poiList.pois[i].location.lat.toString(),
				},
			    dataType:'text',
			    success:function(msg){
			    	/*var message = eval(msg);*/
			    	//alert(msg);
			    }
				
			});
        }
    }
</script>
</body>
</html>