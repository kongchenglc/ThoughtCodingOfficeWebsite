
function getByClass(oParent,sClass){
	var aEle=document.getElementsByTagName('*');
	var i=0;
	var aResult=[];
	for(i=0;i<aEle.length;i++){
		if(aEle[i].className==sClass){
			aResult.push(aEle[i]);
		}
	}
	return aResult;
}
function moveOpacity(obj,iTarget)
{
	clearInterval(obj.timer);
	obj.timer=setInterval(function(){
		var iCur=parseInt(parseFloat(getStyle(obj,'opacity'))*100);
		ispeed=(iTarget-iCur)/8;
		ispeed=ispeed>0?Math.ceil(ispeed):Math.floor(ispeed);
		if(iCur==iTarget)
		{
			clearInterval(obj.timer);
		}
		else
		{
			obj.style.opacity=(iCur+ispeed)/100;
			obj.style.filter="opacity("+(iCur+ispeed)+")";
		}
	},30);
}
function getStyle(obj,arr)
{
	if(obj.currentStyle)
	{
		return obj.currentStyle[arr];
	}
	else
	{
		return getComputedStyle(obj,false)[arr];
	}
}