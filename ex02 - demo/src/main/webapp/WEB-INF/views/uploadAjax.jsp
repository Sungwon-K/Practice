<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/dist/css/pointer.css">
</head>
<body>
	
	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>
	
	<div class='uploadResult'>
		<ul>
		
		</ul>
	</div>
	
	<button id="uploadBtn">Upload</button>
	
	<!-- jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<script>
		$(document).ready(function(){
			
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880; //5MB
			
			function checkExtension(fileName, fileSize){
				if(fileSize >= maxSize){
					alert("파일 사이즈 초과");
					return false;
				}
				
				if(regex.test(fileName)){
					alert("해당 종류의 파일은 업로드할 수 없습니다.");
					return false;
				}
				
				return true;
			}
			
			var cloneObj = $(".uploadDiv").clone();			
			
			$("#uploadBtn").on("click",function(e){
				var formData = new FormData(); //form태그에 대응되는 객체
				var inputFile=$("input[name='uploadFile']");//input file 태그찾기
				
				//무조건 배열로 받는다.
				var files = inputFile[0].files;
				
				console.log(files);
				
				for(var i = 0 ; i<files.length;i++){
					
					//파일확장자, 파일사이즈 체크
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}
					formData.append("uploadFile",files[i]);
				}
				
				$.ajax({
					url: '/uploadAjaxAction',
					//ajax전송시 아래 2개 false 필수
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					dataType:'json',
					success: function(result){
						console.log(result);
						
						showUploadedFile(result);
						
						$(".uploadDiv").html(cloneObj.html());						
					}
				});//$.ajax
			});
			
			var uploadResult = $(".uploadResult ul");
			
			function showUploadedFile(uploadResultArr) {
				var str="";
				
				$(uploadResultArr).each(function(i,obj){
										
					if(!obj.image){
						var fileCallPath = encodeURIComponent( obj.uploadPath+"/"+obj.uuid + "_"+obj.fileName);
						
						str+= "<li><a href='/download?fileName="+fileCallPath+"'>"+"<img src='/resources/img/attach.png'>"+obj.fileName+"</a></li>";
					}else{						
						var fileCallPath = encodeURIComponent(obj.uploadPath+ "/s_"+obj.uuid+"_"+obj.fileName);
						
						str+="<li><img src='/display?fielName="+fileCallPath+"'</li>";
					}
				});
				
				uploadResult.append(str);
			}
		});
	</script>
		
</body>
</html>