package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Song;
import com.example.demo.entity.Users;

public interface SongRepository extends JpaRepository<Song, Integer>{
	public Song findByName(String name);

}
