/**
 * using AJAX to get song data and display to table.
 */
let jsonUrl="songs";
$.getJSON(jsonUrl,function(data){
	for(let entry in data){
		var tableContent = tableContent +
			"<tr>" +
			"<td>" + data[entry].id + "</td>" +
			"<td>" + data[entry].title + "</td>" +
			"<td>" + data[entry].author + "</td>" +
			"<td>" + data[entry].melody + "</td>" +
			"<td><img class='playbtn img-fluid' src='../img/play-music.png' id='playIt'/></td>" +
			"</tr>"
			;
	}
	$("#showSongs").append(tableContent);
});