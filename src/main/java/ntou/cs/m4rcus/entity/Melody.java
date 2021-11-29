package ntou.cs.m4rcus.entity;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
public class Melody {
	
	@Id
	private String id;
	private String title;
	private String author;
	//需要把音符拆成 note 和 octave
	private String melody;
	private ArrayList<String> song;
	public Melody()
	{
		this.title = "";
		this.author = "";
		this.melody = "";
		song = new ArrayList<String>();
	}
	public Melody(String title,String author,String melody) 
	{
		this.title = title;
		this.author = author;
		this.melody = melody;
		song = new ArrayList<String>();
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setAuthor(String name) {
		this.author = name;
	}
	
	public String getAuthor() {
		return this.author;
	}
	//這裡我做了兩個動作，一是setMelody字串，另一個一併把字串轉成陣列形式了=
	public void setMelody(String melody) {
		
		if(melody == null || melody.isEmpty()) 
		{
			System.out.println("no note is send in...");
		}else {
			this.melody = melody;
			
			StringTokenizer tokens = new StringTokenizer(melody);
			//讀出旋律
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken("-");
				song.add(token);
			}//end while
		}
	}
	
	public String getMelody() {
		return this.melody;
	}
	
	public String toString() {
		String outline = "";
		outline += "[" + id + "] " + "Title: " + title + " Author: " + author + " Melody: " + melody;
		return outline;
	}
}
