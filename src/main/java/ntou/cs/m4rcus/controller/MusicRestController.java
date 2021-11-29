package ntou.cs.m4rcus.controller;

import ntou.cs.m4rcus.entity.*;
import ntou.cs.m4rcus.service.SongService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/songs")
public class MusicRestController {
	
	@Autowired
	private SongService songService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Melody> getSong(@PathVariable("id") String id){
		Melody melody = songService.getMelody(id);
		return ResponseEntity.ok(melody); 
	}
	@GetMapping
	public ResponseEntity<List<Melody>> getSongs(@ModelAttribute QueryParameter param)
	//藉由Queryparameter可以自訂根據參數查詢資料庫的資料(進階的GET)
	{
		List<Melody> songs = songService.getMelodys(param);
		return ResponseEntity.ok(songs);
	}
	
	@PostMapping	
	//因為資料簡單(屬性3個)就用原本java bean而已，範例還可以自處理不同的request
	public ResponseEntity<Melody> createSong(@Validated @RequestBody Melody request) throws Exception{
		
		Melody melody = songService.createMelody(request);
		
		//songService把request包成一個程序(get/set data的動作)
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(melody.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(melody);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Melody> updateSong(@PathVariable("id") String id, @Validated @RequestBody Melody request){
		Melody melody = songService.replaceMelody(id, request);
		return ResponseEntity.ok(melody);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Melody> deleteSong(@PathVariable("id") String id){
		songService.deleteMelody(id);
		return ResponseEntity.noContent().build();
	}
}