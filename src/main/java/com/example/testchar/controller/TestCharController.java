package com.example.testchar.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.util.stream.Collectors;

@RestController
public class TestCharController {

    @GetMapping("/param")
    public String stringConverter(@RequestParam String input) {
        List<Character> characters = input.chars()
                .mapToObj(c -> (char) c)
                .distinct().toList();

        return characters.stream()
                .sorted((c1, c2) -> Long.compare(input.chars().filter(ch -> ch == c2).count(),
                        input.chars().filter(ch -> ch == c1).count()))
                .map(c -> "\"" + c + "\": " + input.chars().filter(ch -> ch == c).count())
                .collect(Collectors.joining(", "));

    }
}
