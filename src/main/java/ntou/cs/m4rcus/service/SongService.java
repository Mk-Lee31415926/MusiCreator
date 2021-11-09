package ntou.cs.m4rcus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ntou.cs.m4rcus.entity.Melody;
import ntou.cs.m4rcus.entity.QueryParameter;
import ntou.cs.m4rcus.repository.SongRepository;
//service 作為與mongodb互動的API
@Service
public class SongService {
	@Autowired //autowired repository 他在container就存在，這樣不需要在new新的物件
	private SongRepository repository;
	
	public SongService(SongRepository repository)
	{
		this.repository = repository;
	}
	
	public Melody getMelody(String id) 
	{
		return repository.findById(id).orElseThrow(IllegalArgumentException::new);
	}
	
	public Melody createMelody(Melody request){
		
		String songTitle = request.getTitle();
		String songAuthor = request.getAuthor();
		String songMelody = request.getMelody();
		//檢查傳入歌名字串是否為空 (無效)
		Melody melody =  new Melody(songTitle,songAuthor,songMelody);
		return repository.insert(melody);
	}
	
	public List<Melody> getMelodys(QueryParameter param)
	{
		String orderedBy = param.getOrderedBy(); //根據該欄位屬性排序
		String sortRule = param.getSortrule(); //排序的依據是升冪或降冪
		String keyword = param.getKeyword(); //關鍵詞查找
		
		Sort sort = null;
		if(orderedBy != null && sortRule != null)
		{ // static enum 型別的使用方法 Sort.Direction
			Sort.Direction direction = sortRule.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
			sort = Sort.by(direction,orderedBy);
		}
		if(keyword == null)
		{
			keyword = "";
		}
		if(sort != null)
		{
			return repository.findByTitleContainingIgnoreCase(keyword,sort);
		}else {
			return repository.findByTitleContainingIgnoreCase(keyword);
		}
		
	}
}
