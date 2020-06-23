/**
 * 
 */
window.addEventListener("load",function(){
	var contentBox = document.querySelector(".content-box");
	var boldButton = contentBox.querySelector(".btn-bold");
	var italicButton = contentBox.querySelector(".btn-italic");
	var imgButton = contentBox.querySelector(".btn-img");// 트리거 위한 버튼
	var fileButton = contentBox.querySelector(".btn-file");
	var contentArea = contentBox.querySelector(".content-area");
	var underlineButton= contentBox.querySelector(".btn-underline");
	var btnBox=document.querySelector(".btn-box");
	var submitButton=btnBox.querySelector(".btn-submit");
	var subLinkForm=document.querySelector(".sub-link-search-form");
	
	var writerName=subLinkForm.querySelector(".writer-name"); //reg.jsp

	var writerId=subLinkForm.querySelector("input[name=writerId]");
	var topic=subLinkForm.querySelector("input[name=topic]");
	//var gradeId=subLinkForm.querySelector("select[name=grade]");
	var title=subLinkForm.querySelector("input[name=title]");
	var detailId_=subLinkForm.querySelector("input[name=id]");
	
	
	var setHeadingSize=subLinkForm.querySelector("select[name=set_headingSize]");



	contentArea.addEventListener('mousedown',function(e){
		
		if(e.target.nodeName!=='DIV')
			return;
		var targetContent=e.target;
		console.log(targetContent);
		setHeadingSize.onchange=function(e){
			if(e.target.value==1){
				targetContent.style.fontSize='40px';
			}
			else if(e.target.value==2){
				targetContent.style.fontSize='35px';
			}
			else if(e.target.value==3){
				targetContent.style.fontSize='30px';
			}
			else if(e.target.value==4){
				targetContent.style.fontSize='25px';
			}
			else if(e.target.value==5){
				targetContent.style.fontSize='20px';
			}
			else if(e.target.value==6){
				targetContent.style.fontSize='16px';
			}
		}
	})

	
	subLinkForm.onsubmit=function(e){ //수정 버튼 클릭시
		
		e.preventDefault();
		console.log("onsubmit");
		
		var content=contentArea.innerHTML;
		title=title.value;
		writerName=writerName.innerText;
		console.log(writerId);
		if(writerId!==null){
			writerId=writerId.value;	
		}
		
		detailId=detailId_.value;
		
		
		
		topic=topic.value;
//		gradeId=gradeId.value;
		
//		console.log(gradeId.value); //평점값
		console.log(writerName);//작성자이름
		console.log(writerId); //작성자 id
		console.log(detailId);
		
		var data=`content=${content}&writerId=${writerId}&title=${title}&writerName=${writerName}&topic=${topic}&id=${detailId}`;
		
		
		var xhr=new XMLHttpRequest();
		
		
		xhr.open('POST','edit',true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.onload=function(){
			console.log(xhr.responseText);
//			comments=JSON.parse(xhr.responseText);
//			location.replace('detail')
			location.href='list';
//			console.log(comments);
//			bind();
		}
		

		xhr.send(data);
	}
	
});
