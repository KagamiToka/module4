package org.example.dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
        dictionary.put("dog", "con chó");
        dictionary.put("cat", "con mèo");
    }

    @GetMapping("/")
    public String input() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam (name = "eng") String eng,
                            Model model) {
        String result = dictionary.get(eng.toLowerCase());
        if (result != null) {
            model.addAttribute("eng", eng);
            model.addAttribute("result", result);
        } else {
            model.addAttribute("eng", eng);
            model.addAttribute("result", "Not found");
        }
        return "result";
    }
}
