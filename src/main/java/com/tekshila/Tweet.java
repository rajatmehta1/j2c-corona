package com.tekshila;

import lombok.Data;

@Data
public class Tweet {
    private String text;
    private String from;
    private String source;
    private String datePosted;
}
