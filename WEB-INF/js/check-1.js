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
					$("#name").html(data.user_name);
					$("#id").html(data.user_id);
					var direction=["嵌入式","大数据&运维","web前端","Web后台","Android开发","Linux运维"];
					$("#major").html(direction[data.direction]);
					$("#class").html(data.user_class);
					var status=["未面试","一面通过","二面通过","一面未通过","二面未通过","一面待定","二面待定"]
					if(parseInt(data.status)>=0){
						$("#status").html(status[data.status]);
					}
					else{
						$("#status").html("未通过");
					}
				}
				else{
					$(".result").html("查无此人");
				}
			}
		})
 
}); 
(function ($) {
                $.getUrlParam = function (name) {
                    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
                    var r = window.location.search.substr(1).match(reg);
                    if (r != null) return unescape(r[2]); return null;
                }
})(jQuery);