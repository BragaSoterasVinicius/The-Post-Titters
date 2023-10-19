package com.postitters.postitters.posts;

import com.postitters.postitters.posts.service.MemeCatcher;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/memes")
public class MemeController {
    private final MemeCatcher memCatc;

    public MemeController(MemeCatcher memCatc) {
        this.memCatc = memCatc;
    }
    @GetMapping
    public String getMemes() throws IOException, ParseException {
        System.out.println(memCatc.memeCatcher());
        String memes = memCatc.memeCatcher().toString();
        return memes;

    }
}
