package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.PlayList;
import com.example.demo.entity.Song;
import com.example.demo.service.PlayListService;
import com.example.demo.service.SongService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PlayListController {
	@Autowired
	SongService songService;
	@Autowired
	PlayListService playlistService;
	@GetMapping("/createPlaylist")
public String createPlayList(Model model)
{
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createPlaylist";
	
	
}
	@PostMapping("/addPlayList")
	public String addPlaylist(@ModelAttribute PlayList playlist) {
		//updating playlist table
		playlistService.addPlaylist(playlist);
		System.out.println(playlist);
		//updating song table
		List<Song> songList = playlist.getSongs();
		
		for(Song s:songList)
		{
			s.getPlaylists().add(playlist);
			songService.updateSong(s);
		}
		
		return "adminhome";
	}
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		List<PlayList> allPlaylists=playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylists",allPlaylists);
		return "displayPlaylists";
	}
	
	
}
