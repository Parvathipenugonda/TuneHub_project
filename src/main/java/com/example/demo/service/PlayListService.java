package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PlayList;

public interface PlayListService {
public void addPlaylist(PlayList playlist);

public List<PlayList> fetchAllPlaylists();

}
