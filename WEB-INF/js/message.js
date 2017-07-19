$(function(){
	$.ajax({//获取全部信息
		type:"GET",
		url:"../student/returnByStatusAndDirection",
		dataType:"json",
		data:{
			"direction":$("#sel").val(),
			"status":$("#status").val(),
		},
		success:function(data){	
			var attr="";			
			for(attr in data){
				var st=null;//状态
				var dir=null;//方向
				switch(data[attr].status){
					case '0':
					st="未面试";
					break;
					case '1':
					st="一面通过";
					break;
					case '2':
					st="二面通过";
					break;
					case '3':
					st="一面待定";
					break;
					case '4':
					st="二面待定";
					break;
					default:
					st="未通过";
				}
				switch(data[attr].direction){
					case '1':
					dir="嵌入式";
					break;
					case '2':
					dir="大数据";
					break;
					case '3':
					dir="Web前端";
					break;
					case '4':
					dir="Web后台";
					break;
					case '5':
					dir="Android开发";
					break;
					case '6':
					dir="嵌入式";
					break;
				}
				var ahref="2017-ap-status.html"+'?student_id='+data[attr].user_id;
				var tr="<tr><td>"+data[attr].user_name
				+"</td><td>"+data[attr].user_id
				+"</td><td>"+data[attr].user_class
				+"</td><td>"+data[attr].phone_number
				+"</td><td>"+dir
				+"</td><td>"+st
				+"</td><td>"+"<a href="+ahref+">评价</a>"
				+"</td></tr>";
				$("tbody").append(tr);
			}
		}
	});

	$("#sel").change(function(){
		$.ajax({//获取全部信息
		type:"GET",
		url:"../student/returnByStatusAndDirection",
		dataType:"json",
		data:{
			"direction":$("#sel").val(),
			"status":$("#status").val(),
		},
		success:function(data){	
			var attr="";
			$("tbody").html("");
			for(attr in data){
				var st=null;//状态
				var dir=null;//方向
				switch(data[attr].status){
					case '0':
					st="未面试";
					break;
					case '1':
					st="一面通过";
					break;
					case '2':
					st="二面通过";
					break;
					case '3':
					st="一面待定";
					break;
					case '4':
					st="二面待定";
					break;
					default:
					st="未通过";
				}
				switch(data[attr].direction){
					case '1':
					dir="嵌入式";
					break;
					case '2':
					dir="大数据";
					break;
					case '3':
					dir="Web前端";
					break;
					case '4':
					dir="Web后台";
					break;
					case '5':
					dir="Android开发";
					break;
					case '6':
					dir="嵌入式";
					break;
				}
				var ahref="2017-ap-status.html"+'?student_id='+data[attr].user_id;
				var tr="<tr><td>"+data[attr].user_name
				+"</td><td>"+data[attr].user_id
				+"</td><td>"+data[attr].user_class
				+"</td><td>"+data[attr].phone_number
				+"</td><td>"+dir
				+"</td><td>"+st
				+"</td><td>"+"<a href="+ahref+">评价</a>"
				+"</td></tr>";
				$("tbody").append(tr);
			}
		}
	});
	})
	$("#status").change(function(){
		$.ajax({//获取全部信息
		type:"GET",
		url:"../student/returnByStatusAndDirection",
		dataType:"json",
		data:{
			"direction":$("#sel").val(),
			"status":$("#status").val(),
		},
		success:function(data){	
			var attr="";
			$("tbody").html("");
			for(attr in data){
				var st=null;//状态
				var dir=null;//方向
				switch(data[attr].status){
					case '0':
					st="未面试";
					break;
					case '1':
					st="一面通过";
					break;
					case '2':
					st="二面通过";
					break;
					case '3':
					st="一面待定";
					break;
					case '4':
					st="二面待定";
					break;
					default:
					st="未通过";
				}
				switch(data[attr].direction){
					case '1':
					dir="嵌入式";
					break;
					case '2':
					dir="大数据";
					break;
					case '3':
					dir="Web前端";
					break;
					case '4':
					dir="Web后台";
					break;
					case '5':
					dir="Android开发";
					break;
					case '6':
					dir="嵌入式";
					break;
				}
				var ahref="2017-ap-status.html"+'?student_id='+data[attr].user_id;
				var tr="<tr><td>"+data[attr].user_name
				+"</td><td>"+data[attr].user_id
				+"</td><td>"+data[attr].user_class
				+"</td><td>"+data[attr].phone_number
				+"</td><td>"+dir
				+"</td><td>"+st
				+"</td><td>"+"<a href="+ahref+">评价</a>"
				+"</td></tr>";
				$("tbody").append(tr);
			}
		}
	});
	})
	$("#num").keyup(function(){
		if(event.keyCode==13){
			if(!/\d{8}/.test($("#num").val())){
				alert("输入错误");
			}
			else{
				$.ajax({
					type:"GET",
					url:"../student/returnOneStudent",
					dataType:"json",
					data:{
						"student_id":$("#num").val(),//根据学生的学号查找信息
					},
					success:function(data){	
						var attr="";
						$("tbody").html("");			
							var st=null;//状态
							var dir=null;//方向
							switch(data.status){
								case '0':
								st="未面试";
								break;
								case '1':
								st="一面通过";
								break;
								case '2':
								st="二面通过";
								break;
								case '3':
								st="一面待定";
								break;
								case '4':
								st="二面待定";
								break;
								default:
								st="未通过";
							}
							switch(data.direction){
							    case '1':
								dir="嵌入式";
								break;
								case '2':
								dir="大数据";
								break;
								case '3':
								dir="Web前端";
								break;
								case '4':
								dir="Web后台";
								break;
								case '5':
								dir="Android开发";
								break;
								case '6':
								dir="嵌入式";
								break;
							}
							var ahref="2017-ap-status.html"+'?student_id='+data.user_id;
							var tr="<tr><td>"+data.user_name
							+"</td><td>"+data.user_id
							+"</td><td>"+data.student_class
							+"</td><td>"+data.phone_number
							+"</td><td>"+dir
							+"</td><td>"+st
							+"</td><td>"+"<a href="+ahref+">评价</a>"
							+"</td></tr>";
							$("tbody").append(tr);
					}
				});
			}
		}
	});

});