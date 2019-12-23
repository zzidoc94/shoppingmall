<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
<style>
	#list{width: 300PX; height:200px; float:left;position:relative;right:-3%;top:20px;}
	#detail.open{display: black; color: black;}
	#detail{
		display:none;
	}
</style>
</head>
<body>
<div id="detail">
</div>

${pList}




<script>
	function detail(pCode) {
		
		$('#detail').toggle('open');
		
		$.ajax({
			url:'ajaxDetail',
			type:'get',
			data:{pCode:pCode},
			dataType:'json',
			
			success:function(data){
				console.log(data);
				var pcode=data.p_code;
				var cnt=1;
				$('#detail').html('상품코드:'+data.p_code+'<br>'
						+'상품명:'+data.p_name+'<br>'
						+'상품설명:'+data.p_contents+'<br>'
						+'가격:'+data.p_price+'원<br>'
						+'재고량:'+data.p_qty+'개<br>'
						+'등록자:'+data.p_id+'<br>'
						+'등록일:'+data.p_date+'<br>'
						+"<input id='test' name='"+data.p_code+"' type='button' value='장바구니담기' onclick=\"cart('"+pcode+"','"+cnt+"')\">"
						//+"<input id='test2' type='button' value='바로구매' onclick='cart("+data.p_code+")'>"
						);
				
			},
			error:function(error){
				console.log(error);
			}
			
			

	
	
// 	$(document).off('click',"#test").on("click","#test",function(){
// 		alert($('#test').attr('name')+"장바구니에 담습니다.");
//	})
		})
/* 		$(document).off("click","#test",function(){
			alert($('#test').attr('name')+"장바구니에 담습니다.");
		}); */
		/* $(document).on("click","input #test",function(){
			alert($('#test').attr('name')+"장바구니에 담습니다.");
		}); */
		
	}
	function cart(pcode,cnt){
		$.ajax({
			url:"cartinsert",
			data:{pcode:pcode, cnt:cnt},
			dataType:'json',
			success:function(data){
				alert("성공!");
			},
			error:function(error){
				console.log(error);
			}
		})
		//location.href="cartinsert?pcode="+pcode+"&cnt="+1;
	}
	
</script>
</body>
</html>