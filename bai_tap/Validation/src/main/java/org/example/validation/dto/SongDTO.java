package org.example.validation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.validation.entity.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
public class SongDTO implements Validator {
    private String title;
    private String artist;
    private String type;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        if (song.getTitle() == null || song.getTitle().equals("") || song.getTitle().equals(" ")) {
            errors.rejectValue("title", null, "Title is required");
        } else if (song.getArtist() == null || song.getArtist().equals("") || song.getArtist().equals(" ")) {
            errors.rejectValue("artist", null, "Artist is required");
        } else if (song.getType() == null || song.getType().equals("") || song.getType().equals(" ")) {
            errors.rejectValue("type", null, "Type is required");
        }
    }
}
