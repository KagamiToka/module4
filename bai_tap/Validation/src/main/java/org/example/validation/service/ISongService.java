package org.example.validation.service;

import org.example.validation.entity.Song;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISongService {
    List<Song> getSongs();
    boolean addSong(Song song);
    Song getSong(int id);
}
