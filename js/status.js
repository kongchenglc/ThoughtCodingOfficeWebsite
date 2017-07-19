$(function(){
	var status=null;
	console.log("1");
	$.ajax({
			type:"GET",
			url:"../access/returnMessage",
			dataType:"json",
			 data:{
			 	"student_id":$.getUrlParam('student_id')
			 },
			success:function(data){
				status=1;
				if(data.student_name!=undefined){
					if(data.access.first.basescore!=undefined)
					{
						$(".first").css({"display":"block"});
						status=1;
						$("#status").html("一面");
						$("#judge-1").html("基础能力 "+data.access.first.basescore);
						$("#judge-2").html("技术水平 "+data.access.first.technicalscore);
						$("#judge-3").html("学习能力 "+data.access.first.studyability);
						$("#judge-4").html("态度 "+data.access.first.attitude);
						$("#firstJudge").html(data.access.first.supplement);
						 if(data.access.second.basescore!=undefined)
					{
						$(".second").css({"display":"block"});
						status=2;
						$("#status-2").html("二面");
						$("#judge-2-1").html("基础能力 "+data.access.second.basescore);
						$("#judge-2-2").html("技术水平 "+data.access.second.technicalscore);
						$("#judge-2-3").html("学习能力 "+data.access.second.studyability);
						$("#judge-2-4").html("态度 "+data.access.second.attitude);
						$("#firstJudge-2").html(data.access.second.supplement);
					}
					}
					else{
						$(".none").css({"display":"block"});
						$(".none").html("未面试");
					}
					$("#name").html(data.student_name);
					$("#id").html(data.student_id);
					$("#class").html(data.student_class);
					$("#sel").val(data.direction);
				}
				else{
					$("form").html("查无此人");
				}
			}
			,
			error:function(){
				console.log("error");
			}
		});
	$(".btn").click(function(){
			$.ajax({
			type:"POST",
			url:"../student/changeStudentStatus",
			dataType:"json",
			data:{
				"student_id":$.getUrlParam('student_id'),
				"status":$("input[name=IFPass]:checked").val(),
				"access_type":status
			},
			success:function(data){
				$("form").html("修改成功");
			}
			,
			error:function(){
				console.log("erroraaa");	
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