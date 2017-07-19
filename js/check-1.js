$(function(){
	$.ajax({
			type:"GET",
			url:"../student/returnOneStudent",
			dataType:"json",
			data:{
				"student_id":$.getUrlParam('num')
			},
			success:function(data){
				if(data.status!=undefined){
					$("#userName").html(data.user_name);
					$("#userId").html(data.user_id);
					var direction=["","嵌入式","大数据","web前端","Web后台","Android开发","Linux运维"];
					$("#userMajor").html(direction[data.direction]);
					if(parseInt(data.status)>=0){
						switch(data.status){
							case '0':
							st="未面试";
							break;
							case '2':
							st="已录取";
							break;
							default:
							st="面试中";
								}
							$("#userStatus").html(st);
					}
					else{
						$("#userStatus").html("已回绝");
				
				}}
				else{
					$(".result").html("未找到此用户");
			}}
			
		})
 
}); 
(function ($) {
                $.getUrlParam = function (name) {
                    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
                    var r = window.location.search.substr(1).match(reg);
                    if (r != null) return unescape(r[2]); return null;
                }
})(jQuery);