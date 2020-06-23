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
	

	var mfcProduct=subLinkForm.querySelector("input[name=mfc-product]");
	var title=subLinkForm.querySelector("input[name=title]");
	var detailId_=subLinkForm.querySelector("input[name=id]");
	var writerName=subLinkForm.querySelector(".writer-name");
//	var writerId=subLinkForm.querySelector("input[name=writerId]");
	var gradeId=subLinkForm.querySelector("select[name=grade]");
	
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
		gradeId=gradeId.value;
		detailId=detailId_.value;
		
		
		
		mfcProduct=mfcProduct.value;
//		gradeId=gradeId.value;
		
//		console.log(gradeId.value); //평점값
		console.log(mfcProduct.value);//제조사-라면값
		console.log(writerName);//작성자이름
		console.log(writerId); //작성자 id
		console.log(detailId);
		
	
		var data=`content=${content}&writerId=${writerId}&title=${title}&writerName=${writerName}&mfc-product=${mfcProduct}&id=${detailId}&grade=${gradeId}`;
		
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

/*
subLinkForm.onsubmit=function(e){
	
	e.preventDefault();
	console.log("onsubmit");
	
	var content=contentArea.innerHTML;
	title=title.value;
	writerName=writerName.innerText;
	writerId=writerId.value;
	mfcProduct=mfcProduct.value;
	gradeId=gradeId.value;
	
	console.log(gradeId.value); //평점값
	console.log(mfcProduct.value);//제조사-라면값
	console.log(writerName);//작성자이름
	console.log(writerId); //작성자 id
	
	var data=`content=${content}&writerId=${writerId}&title=${title}&writerName=${writerName}&mfc-product=${mfcProduct}&grade=${gradeId}`;
	
	
	var xhr=new XMLHttpRequest();
	
	
	xhr.open('POST','edit',true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.onload=function(){
		console.log(xhr.responseText);
//		comments=JSON.parse(xhr.responseText);
//		location.replace('detail')
		location.href='list';
//		console.log(comments);
//		bind();
	}
	

	xhr.send(data);}*/