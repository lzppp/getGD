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
    <title>公交线路查询</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript"
            src="http://webapi.amap.com/maps?v=1.3&key=3f9bc1d537596690d1cdd74ac18e3b7d&plugin=AMap.LineSearch"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.0.0/jquery.js"></script>
</head>
<body>
<div id="container"></div>
<script language="javascript">
    /*
     * 该示例主要流程分为三个步骤
     * 1. 首先调用公交路线查询服务(lineSearch)
     * 2. 根据返回结果解析，输出解析结果(lineSearch_Callback)
     * 3. 在地图上绘制公交线路()
     todo :设置            pageIndex: count,(如果length小于60，则路线数字++)
     pageSize: 60,
     */
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        zoom: 13 //地图显示的缩放级别
    });
    /*公交线路查询*/
    var count = 1; //页数
    var linecount = 0; //遍历公交线的名称编号上面的数字
    function lineSearch() {
        for (var i = 0 ; i < 200 ; i++){ 
        	setTimeout(1000);
	        var linesearch = new AMap.LineSearch({
	            pageIndex: count,
	            city: "海口",//城市
	            pageSize: 60,
	            extensions: 'all'
	        });
	        //搜索“536”相关公交线路
	        linecount = linecount + 1;
	        linesearch.search(linecount.toString(), function(status, result) {
	            if (status === 'complete' && result.info === 'OK') {
	                lineSearch_Callback(result);
	            } else {
	                alert(result);
	            }
	        });
        }
    }
    /*公交路线查询服务返回数据解析概况*/
    function lineSearch_Callback(data) {
        var lineArr = data.lineInfo;
        var lineNum = data.lineInfo.length;
        if (lineNum >= 60){
        alert("有一个线路多于60条:"+lineArr[0].name.toString());
        }
        
        if (lineNum == 0) {
        } else {
            for (var i = 0; i < lineNum; i++) {
                var pathArr = lineArr[i].path;
                var stops = lineArr[i].via_stops;
                var path = pathToString(pathArr);
                console.log(lineArr[i].name.toString());
                $.ajax({
    				type:"POST",
    				aysnc:false,
    				url:"ServletLine",
    				data:{
    					"name":lineArr[i].name.toString(),
    					"path":path,
    				},
    			    dataType:'text',
    			    success:function(msg){
    			    	/*var message = eval(msg);*/
    			    	//alert(msg);
    			    }
    				
    			});//路线ajax
    			//也可以从这里爬站点
            }
        }
    }
 
    lineSearch();
    function pathToString(pathArr){
    	var path = "";
    	for (var j = 0 ; j < pathArr.length ; j++){
    		path = path + pathArr[j].lng+","+pathArr[j].lat+";";
    	}
    	return path;
    };
</script>
</body>
</html>  