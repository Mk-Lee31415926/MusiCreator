/**
 * 
 */
$(document).ready(function(){
		
			$("#submit").click(postByAjax);
		});
			
function postByAjax(){
	let requestURL = "/songs";
	let dataJSON = {};
	let checkTitle = $("#title").val();
	
	/*檢查使用者是否有無效欄位，要求是至少title歌曲名不為空*/
	//如果使用者忘記輸入，會幫他預設一個title填上
	if(checkTitle == "")
	{checkTitle = "剛才忘記填上歌曲名了"; }
	
	dataJSON["title"]=checkTitle;
	dataJSON["author"]=$("#author").val();
	dataJSON["melody"]=$("#melody").val();
	$.ajax({
		url: requestURL,
		data: JSON.stringify(dataJSON),
		type: "POST",
		datatype: "json",
		contentType: "application/json;charset=utf-8",
		success: function(returnData){
			window.alert("Your song is saved!");
			console.log("Success");
		},
		error: function(xhr, ajaxOptions, thrownError){
			console.log(xhr.status);
			console.log(thrownError);
		}
	});
}