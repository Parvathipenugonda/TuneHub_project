package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PlayList;
import com.example.demo.repository.PlayListRepository;
@Service
public class PlayListServiceImplementation implements PlayListService{
	@Autowired
	PlayListRepository repo;
	@Override
	public void addPlaylist(PlayList playlist) {
		repo.save(playlist);
	}
	@Override
	public List<PlayList> fetchAllPlaylists() {
		return repo.findAll();
	}

}
