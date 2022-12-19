package com.nhnacademy.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConcretePost implements Post {
    private long id;
    private String title;
    private String content;
    private String writerUserId;
    private LocalDateTime writeTime;
    private int viewCount;

    private static long count = 0;

    public ConcretePost() {
        this.id = ++count;
        this.writeTime = LocalDateTime.now();
    }

    @Override
    public void increaseViewCount() {
        viewCount++;
    }
}
