/**
 * 處理網頁初始化載入音檔的部分
 */
$(document).ready(function(){
  			//使用github資源工具
  			//imagemap比較難操縱，除了css效果不知道該怎麼加，在RWD上也需要在另外處理
  			$("#area-map").imageMapResize();
  			$("#piano-img").maphilight();	//處理琴鍵hover上的效果(<area>沒有css屬性可改)
  			//maphilight如何修改default樣式設定?
  			//https://projects.davidlynch.org/maphilight/docs/
  			
  			//const synth = new Tone.Synth().toMaster();
  			
  			//開/關modal form按鈕
  			$("#open_sesame").click(function(){
  				$("#modal_action").toggle();
  			});
  			
  			//載入音源資源的部分
  			$("#area-map").on({
  				mousedown: function(evt){
  					//synth.triggerAttack(evt.target.dataset.note);
  					//$("#noteTest").text(evt.target.dataset.note); //show note name as text
  					
  					//載入聲音了，但我想再加上思考怎麼處理載入延遲的問題，或者說做UIloading呈現
  					//經驗:WebAudioContext must be generated after a user gesture is triggered.
  					//意思是我把setting的變數移到螢幕偵測到event之後再做
  					//Ha!
  					//要去研究到底是哪個部分造成載入時大概過5秒按的動作才有聲音
  					
  					//排除bug : 按下一個按鍵再點另外一個，會停在原本按的上面
  					
  					//note: 把recordHistory綁到input上 then POST
  					//在修一個<div>版本，去研究event bubbling，我覺得div可以做比較多變化，調整起來也比較方便(生成完整鋼琴)
  					//前端要避免送空資料
  					
  					var AudioContextFunc = window.AudioContext || window.webkitAudioContext;
					var audioContext = new AudioContextFunc();
					var player = new WebAudioFontPlayer();
					player.loader.decodeAfterLoading(audioContext, '_tone_0010_Chaos_sf2_file.js'); //Bright Acoustic Piano: 12
  					var pitch = translateNote(evt.target.dataset.note);
  					console.log("translate : " + pitch , typeof pitch);
  					player.queueWaveTable(audioContext, audioContext.destination, _tone_0010_Chaos_sf2_file, 0, pitch, 1);
  					
  					$("#noteDisplay").append(evt.target.dataset.note + " "); //在下方顯示現在彈到的音
  					$("#melody").append(evt.target.dataset.note); //將使用者音符綁在form表單
  				},
  				mouseup: function(evt){
  					console.log(evt.target.dataset.note);
  				}
  			});
  			
  			//綁住按鈕，按下則會把區塊內字串填到form的melody欄位中
  			$("#fillOutForm").click(function(){
  				$("#melody").val("D2-F2");
  				alert(get);
  				
  				$("<input>").attr({
  					type: "text",
  					id: "melody",
  				}).appendTo("#musicForm");
  			});
  		});
  		