$(function(){
	var type=1;
	$.ajax({
			type:"POST",
			url:"../access/returnMessage",
			dataType:"json",
			 data:{
			 	"student_id":$.getUrlParam('student_id')
			 },
			success:function(data){
				if(data.student_name!=undefined){
					if(data.access.second.basescore!=undefined)
					{
						$(".two").css({"display":"block"});
						$(".three").css({"display":"none"});
						$("#judge-2-1").html("基础能力 "+data.access.second.basescore);
						$("#judge-2-2").html("技术水平 "+data.access.second.technicalscore);
						$("#judge-2-3").html("学习能力 "+data.access.second.studyability);
						$("#judge-2-4").html("态度 "+data.access.second.attitude);
						$("#wordJudge-2").html(data.access.second.supplement);
					}
					if(data.access.first.basescore!=undefined)
					{
						type=2;
						$(".one").css({"display":"block"});
						$("#judge-1-1").html("基础能力 "+data.access.first.basescore);
						$("#judge-1-2").html("技术水平 "+data.access.first.technicalscore);
						$("#judge-1-3").html("学习能力 "+data.access.first.studyability);
						$("#judge-1-4").html("态度 "+data.access.first.attitude);
						$("#wordJudge-1").html(data.access.first.supplement);
					}
					$("#name").html(data.student_name);
					$("#id").html(data.student_id);
					$("#class").html(data.student_class);
					$("#sel").val(data.direction);
				}
				else{
					$("form").html("<div id="+"success"+">查无此人</div>");
				}
			}
			,
			error:function(){
				$("form").html("<div id="+"success"+">错误</div>");
			}
		});
	$(".btn").click(function(){
			$.ajax({
			type:"POST",
			url:"../access/addAccess",
			dataType:"json",
			data:{
				"access_type":type,
				"student_id":$("#id").html(),
				"direction":$("#sel").val(),
				"basescore":$("#sel-1").val(),
				"technicalscore":$("#sel-2").val(),
				"studyability":$("#sel-3").val(),
				"attitude":$("#sel-4").val(),
				"supplement":$(".text").val(),
				"status":$("input[name=IFPass]:checked").val()
			},
			success:function(data){
				$("form").html("<div id="+"success"+">评价成功</div>");
			}
			,
			error:function(){
				$("form").html("<div id="+"success"+">错误</div>");
			}
		})
		// return false;
	});
	
}); 
(function ($) {
                $.getUrlParam = function (name) {
                    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
                    var r = window.location.search.substr(1).match(reg);
                    if (r != null) return unescape(r[2]); return null;
                }
})(jQuery);