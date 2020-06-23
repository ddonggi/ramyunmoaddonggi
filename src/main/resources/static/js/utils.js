/**
 * 저작자 : 라면모아 생성이 : 라면모아 저작권 : 라면모아 설명: 참고 url:
 */

window.addEventListener("load",function(){
	var detail=document.querySelector(".detail");
	var loveBtn=detail.querySelector(".love-btn");
	
	var reviewDetailId=document.querySelector(".review-detail-id");
	
	reviewDetailId=reviewDetailId.value; //게시판 id
	
	loveBtn.onclick=function(e){
		console.log(e.target.nodeName);
		if(e.target.nodeName!=='I')
			return;
		
		if(e.target.classList.contains('far')){ // 색없는 하트->색있는 하트
			e.target.classList.add('d-none');
			e.target.nextElementSibling.classList.remove('d-none');
			
			var xhr= new XMLHttpRequest();
			
			xhr.open("GET","add-like?id="+reviewDetailId,true)
			
			xhr.onload=function(){
				console.log(xhr.responseText);
				
			}
			
			xhr.send(null);
			
		}else if(e.target.classList.contains('fas')){ // 색있는 하트 -> 색없는 하트
			e.target.classList.add('d-none');
			e.target.previousElementSibling.classList.remove('d-none');
		}
		
		
	}
});
	


function reviewImportCSS(url){
	var head=document.querySelector("head");
	var link=document.createElement("link");
	link.rel="stylesheet";
	link.type="text/css";
	link.href="../css/board/review/"+url;
	head.append(link);
	console.log(link);
}


function Shield(selector) {
	console.log("selector:"+selector);
	this.parent=document.querySelector(selector);
	this.dom=null;

}

//Shield.prototype.show = function() {
//	console.log("show");
//};
//
//Shield.prototype.hide = function() {
//	console.log("hide");
//};

Shield.prototype = {
	show : function() {
		this.dom=document.createElement("div");
//		var hostNode = document.querySelector(selector);

//		shield.className = "shield";
		// body의 막내로 쉴드를 추가하고
		// 크기는 화면 크기로
		// 배경색은 검은색 opacity는 0.5
//		hostNode.style.position = "relative";
		console.log(this.parent);
		this.parent.style.position = "relative";
		this.dom.style.backgroundColor = "none";
		this.dom.style.opacity = 0.5;
		this.dom.style.position = "absolute";
		this.dom.style.left = "0px";
		this.dom.style.top = "0px";
		this.dom.style.width = "100%";
		this.dom.style.height = "100%";
		this.dom.style.display = "flex";
		this.dom.style.justifyContent = "center";
		this.dom.style.alignItems = "center";

		var icon = document.createElement("img");
		// icon.src="../images/ajax-loader.gif";
		icon.src = "/images/ajax-loader.gif"; // 컨택스트경로가 / 일때 절대경로
		// shield.appendChild(icon) 은 TextNode...
		this.dom.append(icon);

		this.parent.append(this.dom);
	},
	hide : function() {
		if(this.dom==null) return;
		this.dom.remove();
	}
};

// 함수 2가지 호출방법

var s = new Shield();
s.show();
s.hide();
console.log("s1:" + s1);

var s1 = new Shield(); // this가 존재 , 이 함수를 new를 통해서 호출하게 되는 용도는
// 객체를 넘기니 초기화 해라
s1.show();
s1.hide();
console.log("s2::" + s1 + s1.kor);

console.log(s.show === s1.show);

//function removeShield(selector) {
	// shield를 수거해야함
//	var parentNode = document.querySelector(selector);
//	var shield = parentNode.querySelector(".shield");
	// 부모.appendChild < = > 부모.removeChild()
	// 부모.append <=> 자신.remove()
	// s.parentElementNode.removeChild(s);
//	shield.remove();
//}

// 1.showShield(".main");
// 2. showShield(,true);
//function showShield(selector, fullscreen) {
//
//	var hostNode = document.querySelector(selector);
//
//	var shield = document.createElement("div");
//	shield.className = "shield";
//	// body의 막내로 쉴드를 추가하고
//	// 크기는 화면 크기로
//	// 배경색은 검은색 opacity는 0.5
//	hostNode.style.position = "relative";
//	shield.style.backgroundColor = "black";
//	shield.style.opacity = 0.5;
//	shield.style.position = "absolute";
//	shield.style.left = "0px";
//	shield.style.top = "0px";
//	shield.style.width = "100%";
//	shield.style.height = "100%";
//	shield.style.display = "flex";
//	shield.style.justifyContent = "center";
//	shield.style.alignItems = "center";
//
//	var icon = document.createElement("img");
//	// icon.src="../images/ajax-loader.gif";
//	icon.src = "/images/ajax-loader.gif"; // 컨택스트경로가 / 일때 절대경로
//	// shield.appendChild(icon) 은 TextNode...
//	shield.append(icon);
//
//	hostNode.append(shield);
//
//}
