<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="jquery.serializeObject.js"></script>
    <style>
    /* 추가된 css */
       #sum { position:absolute; bottom:0px;}
      .detail{
         margin: 10px;display:inline-flex;
      }
      
      
   /* 끝 */   
        div.cartli {
            border: 1px solid black;
        }

        h1 {
            width: 98%;
            text-align: center;
            color: white;
            background-color: #380B61;
        }

        #cart {
            width: 98%;
            height: 80%;
            overflow: hidden;
            display: flex;
            margin: 5px;
        }

        #cartlist {
            font-size: 20px;
            margin: 5px;
            border: 3px solid #6A0888;
            width: 70%;
            height: 500px;
            text-align: left;
        }

        #total {
           position:relative;
            border: 3px solid #6A0888;
            width: 25%;
            height: 500px;
            margin: 5px;
        }

        #aaa {
            position: fixed;
            font-size: 50px;
            float: left;
            text-align: center;
            bottom: 250px;
            margin-left: 20px;
        }

        #Conf {
            position: fixed;
            font-size: 50px;
            text-align: center;
            bottom: 250px;
            margin-left: 20px;
            left: 84%;
        }

    </style>
</head>

<body>
    <h1>장바구니</h1>


    <div id="cart">
        <div id="cartlist"></div>

        <div id="total">
            <!--선택 상품 리스트 및 총 가격-->
            <div id="sum"></div>
        </div>

    </div>

    <div class="show1">
        <img alt="카트" src="./img/cart.JPG" width="200px" height="150px">
    </div>

    <div class="show2">
        <img alt="카트2" src="./img/장바.png" width="200px" height="150px" style="float: right; left: -5%; position: relative;">
    </div>



    <div id="aaa">
        <input style="width: 100px; height: 50px" id="select" type="button" value="선택구매"> <input style="width: 100px; height: 50px" id="reset" type="button" value="선택리셋">
    </div>



    <div id="Conf">
        <button id="conBtn" style="width: 200px; height: 50px;">구매 확정</button>
    </div>


    <script>
        $(document).ready(function() {
            $('.show1').show();
            $('.show2').hide();

            $('#select').click(function() {
                $('.show1').hide();
                $('.show2').show();

                $('#reset').click(function() {
                    $('.show2').hide();
                    $('.show1').show();
                    return false;
                });
            });
        });

    </script>





    <script>
        console.log(${data});
        //for(var idx in ${data})
          //카트에서 넘어온 데이터
        for (var idx in ${data}) {
            var $checkbox = $('<input>').attr('type', 'checkbox').attr('class', 'check');
            var $div = $('<div>').attr('class', 'cartli');



            $checkbox.appendTo($div);
            
            
            var obj = ${data}[idx].p_sysFileName;
            var $con=$('<div>').attr("class","detail").append('<img src=upload/' + obj + ' width=50px>');
            //console.log(obj);
            $div.append($con);

            var $con=$('<div>').attr("class","detail").append("상품 : "+${data}[idx].p_name);
            $div.append($con);
         
            var $con=$('<div>').attr("class","detail").append("상세 : "+${data}[idx].p_contents);
            $div.append($con);

            var $con=$('<div>').attr("class","detail").append("가격 : "+${data}[idx].p_price);
            $div.append($con);

            var $con=$('<div>').attr("class","detail").append("갯수 : "+${data}[idx].p_cnt);
            $div.append($con);


            $div.append('<br>');
            
            $div.appendTo("#cartlist");
            
            var $pcode = $('<input>').attr('type', 'hidden').attr('class', 'pcode').val(${data}[idx].p_code);
            var $cnt = $('<input>').attr('type', 'hidden').attr('class', 'pcnt').val(${data}[idx].p_cnt);
            var $name = $('<input>').attr('type', 'hidden').attr('class', 'pname').val(${data}[idx].p_name);
            var $price = $('<input>').attr('type', 'hidden').attr('class', 'pprice').val(${data}[idx].p_price);

            $div.append($pcode).append($cnt).append($name).append($price);


        }

    </script>
    <script>
        //div 내의 폼태그를 생성하는 함수
        function makefrm() {
            //var total=0;
            console.log("폼을 만드는 함수");
            var $form = $("<form></form>");
            $form.attr("action", "orderinsert");
            var $divs = $("div .cartli");

            $divs.each(function() {
                if ($(this).children(".check").is(":checked")) {
               
                    $("<input>").attr("name", "pcode").val(
                        $(this).children(".pcode").val()).attr("readonly",true).appendTo($form);
                    console.log("sssss");
                    console.log($(this).children(".pcode").val());
                    console.log("sssss");
                    $("<input>").attr("name", "odcnt").val(
                        $(this).children(".pcnt").val()).attr("readonly",true).appendTo($form);
                    $("<input>").attr("name", "oditem").val(
                        $(this).children(".pname").val()).attr("readonly",true).appendTo($form);
                    $("<input>").attr("name", "oditemcost").val(
                        $(this).children(".pprice").val()).attr("readonly",true).appendTo($form);

                    //total+=Number($(this).children(".pprice").val());
                }
            });
            return $form;
        }
        //divs 내의 자식들의 pprice 클래스의 합을 구하는 함수
        function sum() {
            var $divs = $("div .cartli");
            var total = 0;
            $divs.each(function() {
                if ($(this).children(".check").is(":checked")) {
                    total += Number($(this).children(".pprice").val());
                }
            });
            return "합계:"+total;
        }
        $(function() {
            //구매 확정 버튼
            $('#conBtn').on("click", function() {
                    var jsonData = JSON.stringify(makefrm().serializeObject());

                    $.ajax({
                        url: "orderinsert",
                        type: "post", //get가능
                        data: {
                            data: jsonData
                        },
                        //스프링에서 data:jsonStr 이렇게 보내면 스프링이 json을 까보기 때문에 아래처럼 설정해야됨..
                        //contentType:'application/json; charset=UTF-8',  
                        dataType: "html", //생략가능
                        success: function(data) {
                        	location.href="success.jsp";
                            console.log(data);
                        },
                        error: function(error) {
                            console.log(error);
                        }
                    }); //ajax End 
                    //$("<button>").text("전송").appendTo($form);
                    console.log(makefrm());
                    console.log(jsonData);
                });
           
                //선택 버튼
                $('#select').on("click", function() {
                    makefrm().appendTo("#total");
                    $("#sum").append($('<h3>').append(sum()));
                });
            });

    </script>
</body>

</html>