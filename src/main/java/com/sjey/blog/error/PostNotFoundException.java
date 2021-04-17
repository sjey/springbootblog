package com.sjey.blog.error;

public class PostNotFoundException extends RuntimeException {
    private long id;

    public PostNotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
