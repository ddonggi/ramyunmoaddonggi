/**
 * 
 */

window.addEventListener("load",function(){
	var comment = document.querySelector("#comment");
	var commentSortWriteBtn=comment.querySelector(".comment-sort-write-btn");
	var commentSortWrite=comment.querySelector(".comment-sort-write");
	var commentWriteBox=comment.querySelector(".comment-write-box");
	var commentForm=comment.querySelector(".comment-form");
	var commentCancelBtn=comment.querySelector(".comment-cancel-btn");
	var commentRegBtn=comment.querySelector(".comment-reg-btn");
	var commentRefresh=comment.querySelector(".comment-header-refresh");
	var reviewDetailId_=comment.querySelector(".review-detail-id");
	var reviewDetailId=reviewDetailId_.value;
	var comments="";
	

	
	
	
	console.log(reviewDetailId);
	
	
	// 새로고침 버튼 --> 구현중
	commentRefresh.onclick=function(e){
		var xhr=new XMLHttpRequest();
		
		
		xhr.open('GET','detail-data?id='+reviewDetailId,true);
		
		xhr.onload=function(){
			console.log(xhr.responseText);
			comments=JSON.parse(xhr.responseText);
			console.log(comments);
			bind();
		}
		
	
		xhr.send(null);
	}
	
	function bind(){ // 댓글 새로고침 바인드 --> 구현중
		// sessionScope 해결해야한다. -> detail-data controller에서
		// 쿼리로 session에서 아이디가 있다면 얻어와서 쿼리로 가져오자.
		// 자바스크립트로 session 아이디 얻어오는 방법?..
		var commentFirstForm=document.querySelector(".comment-first-form");
		var cmtContent="";
		for(var i in comments){
			var cmt= comments[i];
			var childrenTemplate="";
			var childrenContent="";
			console.log(cmt.children);
			
			if(cmt.children){ // 대댓글이 있다면
				console.log("true");
				for(var i in cmt.children){
					var child=cmt.children[i];
					childrenTemplate=`<div class="comment-write-box second">
				<input type="hidden" value="${child.bossId}">
				<div class="img-box">
					<img src="../images/right-arrow-64x64.png" alt="">
				</div>

				<div class="comment-box_box">
					<div class="comment-meta-info">
						<a href="" class="user-id">${child.writerName }</a>
						<div class="regdate">${child.regdate}</div>
						<div class="update">
							<div class="dots-box">
								<i class="dots fas fa-ellipsis-v"></i>
							</div>
							<div class="update-box d-none">
								<div class="update-edit">
									<span>수정</span>
								</div>
								<div class="update-delete">
									<span>삭제</span>
								</div>
							</div>
						</div>
					</div>

					<p class="comment-content">${child.content}</p>

					<ul class="comment-btn-list">
						<li class="comment-item">
							<button class="comment-item-btn btn-reset comment-report-btn">
								<img src="../../../../images/board/siren-2859791_640.png"
									width="16px" height="16px" alt="">신고
							</button>
						</li>
						<li class="comment-item">
							<button class="comment-item-btn btn-reset comment-write-btn">
								<i class="fas fa-comment-medical"></i>댓글 쓰기
							</button>
						</li>
					</ul>
				</div>

			</div>

			<form class="comment-form d-none" action="detail" method="post">
				<input type="hidden" value="${child.bossId}">
				<div class="comment-write-box second">
					<div class="img-box">
						<img src="../images/right-arrow-64x64.png" alt="">
					</div>

					<div class="comment-box_box">
						<div class="comment-meta-info">
							<a href="" class="comment-writer-name">${sessionScope.nickname }</a>
							<!-- <div class="regdate">2020-06-03 15:23:43</div> -->
						</div>

						<textarea class="comment-write-content" name="contents"
							placeholder="댓글을 입력해주세요." rows="" cols="" spellcheck="false"
							required="required" maxlength="300"></textarea>
						<div class="comment-container">
							<ul class="comment-btn-list">
								<li class="comment-reg-item"><input type="submit"
									value="등록" class="comment-reg-btn comment-second btn-reset" /></li>
								<li class="comment-reg-item margin-left"><a
									class="comment-cancel-btn"> 취소 </a></li>
							</ul>

							<div class="comment-write-count">
								<span class="comment-write-num">0</span>/<span>300</span>
							</div>
						</div>
					</div>

				</div>
			</form>`;
					childrenContent+=childrenTemplate;
				} // ~for
			
				
			}// ~if
			else{console.log("false")}
			
			// first 댓글 template
			var template=`<div class="comment-box">
			<input type="hidden" value="${cmt.id}">
			<div class="comment-likes">
				<button type="button" class="likes-btn">
					<i class="likes far fa-heart"></i> <i
						class="likes d-none fas fa-heart"></i>
				</button>
				<div class="likes-cnt">${cmt.likes}</div>
			</div>

			<div class="comment-box_box">
				<div class="comment-meta-info">
					<a href="" class="user-id">${cmt.writerName }</a>
					<div class="regdate">${cmt.regdate}</div>
					<div class="update">
						<div class="dots-box">
							<i class="dots fas fa-ellipsis-v"></i>
						</div>
						<div class="update-box d-none">
							<div class="update-edit">
								<span>수정</span>
							</div>
							<div class="update-delete">
								<span>삭제</span>
							</div>
						</div>
					</div>
				</div>

				<p class="comment-content">${cmt.content}</p>

				<ul class="comment-btn-list">
					<li class="comment-item">
						<button class="comment-item-btn btn-reset comment-report-btn">
							<img src="../../../../images/board/siren-2859791_640.png"
								width="16px" height="16px" alt="">신고
						</button>
					</li>
					<li class="comment-item">
						<button class="comment-item-btn btn-reset comment-write-btn">
							<i class="fas fa-comment-medical"></i>댓글 쓰기
						</button>
					</li>
				</ul>
			</div>

		</div>
		<form class="comment-form d-none" action="detail" method="post">
			<input type="hidden" value="${cmt.id}">
			<div class="comment-write-box second">
				<div class="img-box">
					<img src="../images/right-arrow-64x64.png" alt="">
				</div>

				<div class="comment-box_box">
					<div class="comment-meta-info">
						<a href="" class="comment-writer-name">${sessionScope.nickname }</a>
						<!-- <div class="regdate">2020-06-03 15:23:43</div> -->
					</div>

					<textarea class="comment-write-content" name="content"
						placeholder="댓글을 입력해주세요." rows="" cols="" spellcheck="false"
						required="required" maxlength="300"></textarea>
					<div class="comment-container">
						<ul class="comment-btn-list">
							<li class="comment-reg-item"><input type="submit" value="등록"
								class="comment-reg-btn comment-second btn-reset" /></li>
							<li class="comment-reg-item margin-left"><a
								class="comment-cancel-btn"> 취소 </a></li>
						</ul>

						<div class="comment-write-count">
							<span class="comment-write-num">0</span>/<span>300</span>
						</div>
					</div>
				</div>

			</div>
		</form>
		`+childrenContent;
			cmtContent+=template;	
		}
	}
	
	
	// comment data values
// var writerName=comment.querySelector(".comment-writer-name");
// var textarea=comment.querySelector("textarea");
	
	

	var navbar=document.querySelector(".navbar");
	var member=navbar.querySelector(".member");
	
	comment.onclick=function(e){
		console.log(e.target);
		
		if(e.target.classList.contains('comment-sort-write-btn')){
			var loginFlag=member.children[0].innerText;
			
			if(loginFlag === '로그인'){
				alert('글쓰기는 로그인이 필요합니다.');
				return;
			}
			commentSortWriteBtnClick(e);// 맨 위 상단 댓글쓰기 버튼클릭
		}
		
		
		if (e.target.classList.contains('comment-reg-btn'))
			commentRegBtnClick(e);// 등록버튼 클릭시 ★ 이벤트 e를 인자로 넘겨줘야함!!
		
		
		if(e.target.classList.contains('comment-write-btn')){
			var loginFlag=member.children[0].innerText;
			
			if(loginFlag === '로그인'){
				alert('글쓰기는 로그인이 필요합니다.');
				return;
			}
			commentWriteBtnClick(e); // 대댓글 댓글쓰기 버튼클릭
		
		}
			
		
		if(e.target.classList.contains('comment-cancel-btn'))
			commentCancelBtnClick(e); // 댓글 취소버튼 클릭
		
		if(e.target.classList.contains('dots'))
			dotsBoxBtnClick(e);
		
		if(e.target.classList.contains('likes'))
			likesBtnClick(e);

		if(e.target.nodeName==='TEXTAREA'){
			e.target.addEventListener('input',function(e){
				var cmtTextarea=e.target;
				var cmtTextareaValue=cmtTextarea.value;
				console.log(cmtTextareaValue); // 글자
				console.log(cmtTextareaValue.length); // 글자 수 카운트
				
				cmtTextarea.nextElementSibling.lastElementChild.firstElementChild.innerText=cmtTextareaValue.length;
				
			});
		}
		
// console.log(textarea);
// textarea.addEventListener('input',function(e){
// textarea=e.target.value;
// console.log(e.target.value);
// console.log(textarea.length);
// });
		
			
	}
// console.log(commentForm);
// console.log(commentRegBtn);
	var likesFlag=false;
	function likesBtnClick(e){
		if(e.target.classList.contains('far')){ // 색없는 하트
			console.log(e.target.nextElementSibling.classList);
			e.target.classList.add('d-none');
			e.target.nextElementSibling.classList.remove('d-none');
		}else if(e.target.classList.contains('fas')){ // 색있는 하트
			e.target.classList.add('d-none');
			e.target.previousElementSibling.classList.remove('d-none');
		}
	}
	
	// dots(수정,삭제) 클릭시
	var dotsFlag=false;
	function dotsBoxBtnClick(e){
		console.log("dotsBox");
		if(dotsFlag){
			e.target.parentElement.nextElementSibling.classList.add("d-none");
			dotsFlag=false;
		}else{
			e.target.parentElement.nextElementSibling.classList.remove("d-none");
			dotsFlag=true;
		}
		
		
	}
	
	
	// 댓글쓰기 버튼 클릭시
	function commentSortWriteBtnClick(e){
		// textarea.value="";// textarea에 값을 초기화시키기 위해 textarea.innerText="";가
		// 아닌
							// value를 쓰자
		e.target.parentElement.parentElement.nextElementSibling.classList.remove("d-none");
	}
	
	// 대댓글 댓글쓰기 버튼 클릭시
	function commentWriteBtnClick(e){
		
		// textarea.value="";//
		// value를 쓰자
		e.target.parentElement.parentElement.parentElement.parentElement.nextElementSibling.classList.remove("d-none");
		console.log(e.target.nextElementSibling.lastElementChild.firstElementChild)
		
	}
	
	
	// 댓글 취소 버튼 클릭시
	function commentCancelBtnClick(e){
		
		var elem=e.target;
		while(!elem.classList.contains("comment-form"))
			elem=elem.parentElement;
		
		elem.classList.add("d-none");
	}
	
	
	
	
	function commentRegBtnClick(e){ // 댓글 등록버튼 클릭시
		e.preventDefault();
// alert("hi");
		console.log(e);
		console.log(e.target);
		
		// console.log(e.target.innerText); // 작성자이름
 var current = null;
 for(current = e.target; !current.classList.contains("comment-container");
 current = current.parentElement){
 console.log(current.classList);
 }
		
		var elem=e.target;
		var content=current.previousElementSibling.value // 작성한 content
		var writerName=current.previousElementSibling.previousElementSibling.firstElementChild.innerText;
		
		
		while(!current.classList.contains('comment-form'))
			current=current.parentElement;
		
		var bossId=current.previousElementSibling.firstElementChild.value;
		console.log('bossId:'+bossId);
	
		xhr=new XMLHttpRequest();
		xhr.open('POST','detail',true);
		
		xhr.onload=function(){
			console.log(xhr.responseText);
			var result=JSON.parse(xhr.responseText);
			if(e.target.classList.contains('comment-first')){// 첫 댓글
				while(!elem.classList.contains("comment-form"))
					elem=elem.parentElement;
				commentForm=elem;
				var template=`<div class="comment-box">
				<input type="hidden" value="${result.id}">
					<div class="comment-likes">
						<button type="button" class="likes-btn">
							<i class="likes far fa-heart"></i>
							<i class="likes d-none fas fa-heart"></i>
						</button>
						<div class="likes-cnt">${result.likes}</div>
					</div>

					<div class="comment-box_box">
						<div class="comment-meta-info">
					<a href="" class="user-id">${result.writerName }</a>
					<div class="regdate">${result.regdate}</div>
					<div class="update">
	                        <div class="dots-box">
	                            <i class="dots fas fa-ellipsis-v"></i>
	                        </div>
	                        <div class="update-box d-none">
	                            <div class="update-edit"><span>수정</span></div>
	                            <div class="update-delete"><span>삭제</span></div>
	                        </div>
	                    </div>
				</div>

						<p class="comment-content">${result.content}</p>

						<ul class="comment-btn-list">
							<li class="comment-item">
								<button class="comment-item-btn btn-reset comment-report-btn">
									<img src="../../../../images/board/siren-2859791_640.png"
										width="16px" height="16px" alt="">신고
								</button>
							</li>
							<li class="comment-item">
								<button class="comment-item-btn btn-reset comment-write-btn">
									<i class="fas fa-comment-medical"></i>댓글 쓰기
								</button>
							</li>
						</ul>
					</div>

				</div>
				<form class="comment-form d-none" action="detail" method="post">
				<input type="hidden" value="${result.id}">
		        <div class="comment-write-box second">
		            <div class="img-box">
		                <img src="../images/right-arrow-64x64.png" alt="">
		            </div>
		
		            <div class="comment-box_box">
		                <div class="comment-meta-info">
		                    <a href="" class="comment-writer-name">${result.writerName}</a>
		                    <!-- <div class="regdate">2020-06-03 15:23:43</div> -->
		                </div>
		
		                <textarea class="comment-write-content" name="contents" placeholder="댓글을 입력해주세요." rows="" cols=""
		                    spellcheck="false" required="required" maxlength="300"></textarea>
		                <div class="comment-container">
		                    <ul class="comment-btn-list">
		                        <li class="comment-reg-item"><input type="submit" value="등록"
		                                class="comment-reg-btn comment-second btn-reset" /></li>
		                        <li class="comment-reg-item margin-left"><a class="comment-cancel-btn"> 취소 </a></li>
		                    </ul>
		
		                    <div class="comment-write-count">
		                        <span class="comment-write-num">0</span>/<span>300</span>
		                    </div>
		                </div>
		            </div>
		
		        </div>
	       </form>
				`
				commentForm.insertAdjacentHTML('afterend',template);
				commentForm.classList.add("d-none"); // 댓글 등록 후 댓글 폼 지우기
			}else if(e.target.classList.contains('comment-second')){ // 대댓글
				
				while(!elem.classList.contains("comment-form"))
					elem=elem.parentElement;
				commentForm=elem;
				var template=`<form class="comment-form d-none" action="detail" method="post">
				<input type="hidden" value="${result.bossId}">
		        <div class="comment-write-box second">
		            <div class="img-box">
		                <img src="../images/right-arrow-64x64.png" alt="">
		            </div>
		
		            <div class="comment-box_box">
		                <div class="comment-meta-info">
		                    <a href="" class="comment-writer-name">${result.writerName}</a>
		                    <!-- <div class="regdate">2020-06-03 15:23:43</div> -->
		                </div>
		
		                <textarea class="comment-write-content" name="contents" placeholder="댓글을 입력해주세요." rows="" cols=""
		                    spellcheck="false" required="required" maxlength="300"></textarea>
		                <div class="comment-container">
		                    <ul class="comment-btn-list">
		                        <li class="comment-reg-item"><input type="submit" value="등록"
		                                class="comment-reg-btn comment-second btn-reset" /></li>
		                        <li class="comment-reg-item margin-left"><a class="comment-cancel-btn"> 취소 </a></li>
		                    </ul>
		
		                    <div class="comment-write-count">
		                        <span class="comment-write-num">0</span>/<span>300</span>
		                    </div>
		                </div>
		            </div>
		
		        </div>
	       </form>
				<div class="comment-write-box second">
				<input type="hidden" value="${result.bossId}">
					<div class="img-box">
		                <img src="../images/right-arrow-64x64.png" alt="">
		            </div>

					<div class="comment-box_box">
						<div class="comment-meta-info">
					<a href="" class="user-id">${result.writerName }</a>
					<div class="regdate">${result.regdate}</div>
					<div class="update">
	                        <div class="dots-box">
	                            <i class="dots fas fa-ellipsis-v"></i>
	                        </div>
	                        <div class="update-box d-none">
	                            <div class="update-edit"><span>수정</span></div>
	                            <div class="update-delete"><span>삭제</span></div>
	                        </div>
	                    </div>
				</div>

						<p class="comment-content">${result.content}</p>

						<ul class="comment-btn-list">
							<li class="comment-item">
								<button class="comment-item-btn btn-reset comment-report-btn">
									<img src="../../../../images/board/siren-2859791_640.png"
										width="16px" height="16px" alt="">신고
								</button>
							</li>
							<li class="comment-item">
								<button class="comment-item-btn btn-reset comment-write-btn">
									<i class="fas fa-comment-medical"></i>댓글 쓰기
								</button>
							</li>
						</ul>
					</div>

				</div>`
					commentForm.previousElementSibling.insertAdjacentHTML('afterend',template);
				
				commentForm.classList.add("d-none");
				
			}
			commentForm.querySelector('textarea').value="";// textarea에 값을
															// 초기화시키기 위해
															// textarea.innerText="";가
															// 아닌
		}
		
		if(bossId!==undefined)
			var json={"discussionId":reviewDetailId,"writerName":writerName,
				"content":content,"bossId":bossId};
		else
			var json={"discussionId":reviewDetailId,"writerName":writerName,
				"content":content,"bossId":-1};
		
		console.log(json);
		var data=JSON.stringify(json);
		
		xhr.setRequestHeader("Content-type", "application/json");
		console.log(data);
		xhr.send(data);
		
	}
	
});
