/**
 * 
 */
$(document).ready(function(){
		
			$("#submit").click(function(){
				console.log("Title: " + $("#title").val());
			});
		});
			
function postByAjax(){
	let requestURL = "/songs";
	let dataJSON = {};
	/*檢查使用者是否有無效欄位，要求是至少歌曲名不為空*/
	dataJSON["title"]=$("#title").val();
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