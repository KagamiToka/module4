package org.example.validation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Song implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
