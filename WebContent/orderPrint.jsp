<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
#deli{float:right; width:200px; height:200px;left:-15%; position: relative;}
#son{float:right; width:50px; height:50px;left:-15%; position: relative; margin: 65px;}
#ses{float:right;left:-8%; position: relative;}
h1{ background-color: #380B61; color: white;
}
.list{
	display:inline-block;
	margin:5px;
}
#A{border:1px solid white; background-color: #ceecf5; text-align: center;
height: 20px;s width: 730px;
  border-radius: 5px;
  margin: 5px 5px 5px 5px;  }

/* #aaa{border: 1px solid purple;} */

#mid{border-bottom: 1px solid purple; border-top: 1px solid purple; }
</style>
</head>
<body>
<h1 >주문상세내역</h1>
<hr>

<header>
<div id="A"><span><%= request.getSession().getAttribute("id") %></span> 님의 주문 조회</div>
</header>




<middle >
<h3>주문 상품 </h3>
<div id="mid"></div>

</middle>
<pre>





</pre>


<!-- <footer>
<div id="mid">ggg</div>
<div id="mid">sdfsdf</div>
</footer> -->

<div id="new"><img id="deli" alt="출발" src="./img/전달.jpg">
<img id="son" alt="손가락" src="./img/손가락.jpg">
<img id="deli" alt="출발" src="./img/노크.jpg">
<img id="son" alt="손가락" src="./img/손가락.jpg">
<img id="deli" alt="출발" src="./img/카트.jpg">
<img id="son" alt="손가락" src="./img/손가락.jpg">
<img id="deli" alt="출발" src="./img/출발.jpg"></div>
<pre>











</pre>
<div id="ses"><h2>배송준비중</h2></div>

<script>
	
	for(var idx in ${data}){
		var tmp=${data}[idx];
		//console.log(tmp.o_paydate);
		$('#mid').append($('<div>').attr('class','list').text(tmp.o_paydate)).append($('<div>').attr('class','list').text(tmp.o_totalcost)).append($('<div>').attr('class','list').text(tmp.o_payment)).append($('<div>').attr('class','list').text(tmp.od_item)).append($('<div>').attr('class','list').text(tmp.od_itemcost)).append($('<div>').attr('class','list').text(tmp.od_itemcnt+"개")).append("<br>");	
	}
	
		
</script>
</body>
</html>