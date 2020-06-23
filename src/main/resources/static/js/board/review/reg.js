/**
 * 
 */

// var regBox = document.querySelector(".reg-box");
//
// console.log(regBox);
//
// var btnCancel = regBox.querySelector(".btn-cancel");
//
// btnCancel.onclick = cancelBtnClick;
// TODO : cancel button
/*
function cancelBtnClick(e) { //취소버튼 비동기
	shield.show();
	e.preventDefault();

	if (e.target.nodeName != "A") {
		console.log(e.target.nodeName);
		return;
	}
	newMain.remove();
	console.log(newMain);
	// oldBody.insertAdjacentElement("beforebegin",newHead);
	header.insertAdjacentElement("afterend", main);

	shield.hide();

}
*/



var contentBox = document.querySelector(".content-box");
var boldButton = contentBox.querySelector(".btn-bold");
var italicButton = contentBox.querySelector(".btn-italic");
var imgButton = contentBox.querySelector(".btn-img");// 트리거 위한 버튼
var sizeButton = contentBox.querySelector(".btn-fontSize");
var fileButton = contentBox.querySelector(".btn-file");
var contentArea = contentBox.querySelector(".content-area");
var underlineButton= contentBox.querySelector(".btn-underline");
var btnBox=document.querySelector(".btn-box");
var submitButton=btnBox.querySelector(".btn-submit");
var subLinkForm=document.querySelector(".sub-link-search-form");


var writerName=subLinkForm.querySelector(".writerName-txt");
var writerId=subLinkForm.querySelector("input[name=writerId]");
var mfcProduct=subLinkForm.querySelector("input[name=mfc-product]");
var gradeId=subLinkForm.querySelector("select[name=grade]");
var title=subLinkForm.querySelector("input[name=title]");

var setHeadingSize=subLinkForm.querySelector("select[name=set_headingSize]");

console.log(setHeadingSize);
console.log(heading_size);
/*setHeadingSize.onclick=function(e){
	console.log(setHeadingSize.value);
}*/



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


setHeadingSize.onclick=function(e){
	e.preventDefault();
	console.log(e.target);
	console.log("heading_size");	
	console.log(e.target.value);
	var headingSize=e.target.value;
//	`${e.target.value}`
	if(headingSize===1){
		document.execCommand('formatBlock', false,'<h1>' );	
	}
		
}

//window.addEventListener("load",function(){
	function heading_size(setfont,fsize)
	{
		console.log("heading_size");	
	  document.execCommand(setfont, false, fsize);
	}	
//});


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
	
	
	xhr.open('POST','reg-data',true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.onload=function(){
		console.log(xhr.responseText);
//		comments=JSON.parse(xhr.responseText);
//		location.replace('detail')
		location.href='list';
//		console.log(comments);
//		bind();
	}
	

	xhr.send(data);
}



/*등록 버튼 클릭시
//submitButton.onclick=function(e){
	e.preventDefault();
	alert('등록버튼 클릭');
	console.log(contentArea.innerHTML);
	var content=contentArea.innerHTML;
	var data=`content=${content}`;
	
//	title=${title}
//	mfcProduct=${mfcProduct}
//	writerId=
//	content=${content}&
	
	
	var xhr=new XMLHttpRequest();
	
	
	xhr.open('POST','reg-data',true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.onload=function(){
		console.log(xhr.responseText);
		comments=JSON.parse(xhr.responseText);
//		console.log(comments);
//		bind();
	}
	

	xhr.send(data);
}*/

fileButton.oninput = function(e) {
	// e.preventDefault();
	// 상자가 열리고 거기서 파일을 선택하면 상자가 닫힌다.
	// 그럼 현재 선택된 파일의 정보는 어떻게 되는가??
	var files = e.target.files;
	var formData = new FormData();
	// if (files.length > 1) {
	// alert('파일은 하나만 선택할 수 있습니다.');
	// return;
	// }

	// console.log(e.target.files.length) //파일이 선택되면 1, 안되면 0이 된다.
	console.log(files);
	for (var i = 0; i < files.length; i++) {

		var file = files[i];
		console.log(file.name + "," + file.type);
		// 정규식 문자열 => "image/jpg", "image/png", "image/gif" 만 허락하겠다.
		// "image/(jpg|png|gif)"

		var regEx = new RegExp('image/(jpg|png|gif)');
		console.log(regEx);
		console.log(file.type.match(regEx));

		// 파일사이즈 제한
		// if(file.size>1024*1024*10){ //10MB넘는다면
		// alert('파일 사이즈가 큽니다. 10MB 넘지 않게해주세요.');
		// return;
		// }

		// 아~ 이미지 파일을 하나를 선택헀고 이제 그것을 업로드 해야겠다.
		// formData = new FormData();
		formData.append("file", file);
		formData.append("title", "Hello");

	}
	// console.log(formData.getAll("file"));
	var xhr = new XMLHttpRequest();

	xhr.open("POST", "/upload", true);
	xhr.upload.addEventListener("progress", function(e) { // 파일 올라가는 진척도
		console.log(e.loaded + " / " + e.total);
		// 퍼센테이지로 출력하기
		console.log(Math.round(e.loaded * 100 / e.total) + "%");
	});

	xhr.onload = function() {
		console.log(xhr.responseText);
		// document.execCommand("insertImage",null,"/upload/");
		// 선택 영역이라는 것이 있어야만 이미지가 그 위치를 알 수 있고,
		// 그래야 삽입이 되는구나.

		contentArea.focus();
		
		for (var i = 0; i < files.length; i++) {
			var file = files[i];
			
			document.execCommand("insertHTML", false,
					`<div><img style="width:300px;" src="/upload/${file.name}"></div>`);
//			contentArea.insertAdjacentHTML("beforebegin","<br>");
		}

	};
	xhr.send(formData);

};

contentArea.onclick = function(e) {
	console.log(e.target);
	console.log(e.target.nodeName);
//	console.log(!(e.target.nodeName=='IMG'))
	if (e.target.nodeName !== 'IMG')
		return;
	var resize = prompt("변경하고 싶은 사이즈를 숫자로 입력해주세요.\n(기본:300->300px*300px)",
			"300");
	e.target.style.width = `${resize}px`;
	
	

}

imgButton.onclick = function(e) {
	e.preventDefault();
//	alert('imgButtonClicked!');

	// fileButton의 onClick을 트리거하는 코드
	var event = new MouseEvent("click", {
		'view' : window,
		'bubbles' : true,
		'cancelable' : true
	});
	fileButton.dispatchEvent(event);

};

boldButton.onclick = function(e) {
	e.preventDefault();
	document.execCommand("bold");
};

italicButton.onclick = function(e) {
	e.preventDefault();
	document.execCommand("italic");
}

underlineButton.onclick=function(e){
	e.preventDefault();
	document.execCommand("underline");
}



sizeButton.onclick=function(e){
	e.preventDefault();
	document.execCommand("fontSize");
}