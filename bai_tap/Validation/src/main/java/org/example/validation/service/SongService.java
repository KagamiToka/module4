package org.example.validation.service;

import org.example.validation.entity.Song;
import org.example.validation.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository songRepository;

    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    @Override
    public boolean addSong(Song song) {
        return songRepository.save(song)!=null;
    }

    @Override
    public Song getSong(int id) {
        return songRepository.findById(id).orElse(null);
    }

}
