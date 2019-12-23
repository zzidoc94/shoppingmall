<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	#m{float:left;height:10%;width:20%;background-color:white;color:#380B61;font-size:50px;margin:auto;}
	html,body{height:96%; margin:10px;}
	#r{font-size:20px;text-align:center;height:45px;float:left;position:fixed;right:31.5%}
	#keyword{border:1px solid #6A0888;width:30%;height:40px;float:left;position:fixed;right:35%}
	div{ border:1px solid #6A0888;margin:5px;}
	#header{width:98%;height:2%;border:none;text-align:right;}
	 #middle{width:98%;height:80%;
			overflow:hidden;
			border:1px solid #6A0888;margin:5px;
			display:flex;
			/*position:relative; 공식2
			  display:inline-flex;*/
			}
			
			
	#menu{width:18%;height:98%;
		  text-align:center;
		  float:left;
		}
	#main{
		float:left;
		margin:5px;
		width:83%;height:98%;
		text-align:center;
		
		overflow:auto;
		 /*상품이 많을시 스크롤생성*/
	} 
	#footer{
		width:98%;height:20%;
		text-align:center;
		overflow:auto;
		float:none;
	}
	
	#topMenu {width:95%;height:50px;margin:0 auto;background-color:#380B61;}
    #topMenu ul li { list-style: none;color: white;
                        background-color:#380B61;  
                        float:left;               
                        line-height:50px;          
                        vertical-align: middle;    
                        text-align: center;             
                    }
    #topMenu li ul{ display:none;
    				height:auto;
					width:350px;
					/* z-index:200; */
					text-align:center;
    				}
    #topMenu .menuLink {
    					position:relative;
                        text-decoration:none;                     
                        color: white;                             
                        display:block;                            
                        width: 300px;
                        font-size: 20px;                           
                        font-weight: bold;                        
                        font-family: "Trebuchet MS", Dotum, Arial;
                		}
   #topMenu .menuLink:hover { 
                        color:#FF0040; 
                        background-color:#6A0888; 
                        }
   #topMenu li:hover ul {display:block;
   						  width: auto;
   						  text-align:center;
   						  font-size:30px;
   						  color:#FF0040;
   						 }

</style>

</head>
<body onload="window.open('./img/ss.gif','sul','top=100px, left=800px,width=360px,height=360px',
		'toolbar=no,location=no,status=no, menubar=no,scrollbars=yes,resizable=yes,width=SomeSize,height=SomeSize')" >
		
		<div id="header">
			
			<input id="keyword" type="text">
			<button id="r">검색</button>
			<jsp:include page="header.jsp"/>
		</div>
	
		<h1 id=m onClick="location.href='index.jsp'">Alcoholr Bank</h1><br>
		
		<nav id="topMenu" >
              <ul>
                   <li><a class="menuLink" href="#">Company Us</a>
                   	<ul>
                   		<li >김성준</li><br>
                   		<li>평민호</li><br>
                   		<li>김지영</li><br>
                   		<li>이예상</li>
                   	</ul>
                   </li>
                   <!--마우스 가져가면 이름이 뜸 -->
                   <li><a class="menuLink" href="#">Category</a>
                   <ul>
                   		<li>Wine</li><br>
                   		<li>Sake</li><br>
                   		<li>Whisky</li><br>
                   		<li>Vodka</li><br>
                   		<li>Brandy</li>
                   	</ul>
                   </li>
                   <li><a class="menuLink" href="javascript:Aj('newItem','#main')">Best Item</a></li>
                   <li><a class="menuLink" href="javascript:Aj('bestItem','#main')">New Item</a></li>
                   <li><a class="menuLink" href="#">Order menu</a>
                   	 <ul>
                   		<li>비회원 주문</li><br>
                   		<li>비회원 주문조회</li><br>
                   	</ul>
                   </li>
             </ul>
        </nav>
		
		
		<div id=middle>
			<div id="menu">
			<img alt="차은우" src="./img/chaa.jpg" width="95%" height="97%" >
			</div>
			<div  id="main">
			<%-- ${pList} --%>
			</div>
		</div>
		
	<footer>
		<div id="footer">
			<jsp:include page="footer.jsp"/>
		</div>
	</footer>
	
<script>
	/* if(${id==null}){ //로그인 안된 경유 */
		/* Aj("menu","#menu"); */
	
		//if(${id!=null}){
		if(${page==null}){
			Aj("newItem","#main");//newitem.jsp
		}else{					 //bestitem.jsp
			Aj("${page}","#main");
		}
		//}
	function Aj(url,position){
		$.ajax({
			url:url,
			type:"get",
			dataType:"html",
			success:function(page){
				$(position).html(page);
			},
			error:function(error){
				console.log(error);
			}
		}); //ajax End`
	
	} /* Aj End*/
</script>
</body>
</html>