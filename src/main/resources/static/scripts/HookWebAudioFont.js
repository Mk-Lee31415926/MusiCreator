/**
 * 職司連接keyboard與webaudiofont 
 */

function translateNote( inputNote )
{
	var noteArr = ['C','#C','D','#D','E','F','#F','G','#G','A','#A','B'];
	//需要把"C4"的"C"和"4"(需轉成數字) 分開，再把兩個資訊送到數學處理 12*octave(幾個八度) + noteName
	//把字串的尾巴切開
	var str_len = inputNote.length;
	var note = inputNote.slice(0,str_len-1);
	//轉出八度數字(int)
	var octave = parseInt(inputNote.slice(str_len-1,str_len));
	//在array找note index(int)
	var noteIndex = noteArr.indexOf(note);
	console.log(note,octave,noteIndex);
	return 12*octave+noteIndex;
}