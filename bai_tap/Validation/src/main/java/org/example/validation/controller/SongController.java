package org.example.validation.controller;

import org.example.validation.entity.Song;
import org.example.validation.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping(value = "")
    public String showSongs(Model model) {
        List<Song> songs = songService.getSongs();
        model.addAttribute("songs", songs);
        return "song/list";
    }

    @GetMapping("/add")
    public String addSong(Model model) {
        model.addAttribute("song", new Song());
        return "song/add";
    }

    @PostMapping("/add")
    public String addSong(Song song) {
        songService.addSong(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String editSong(Model model,@PathVariable(name = "id") int id) {
        model.addAttribute("song", songService.getSong(id));
        return "song/edit";
    }

    @PostMapping("/edit")
    public String editSong(@ModelAttribute(name = "song") Song song) {
        songService.addSong(song);
        return "redirect:/songs";
    }
}
