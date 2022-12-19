package com.nhnacademy.domain;

import java.util.*;

public class Posts implements PostRepository {
    Map<Long, Post> posts = new HashMap<>();

    @Override
    public long register(Post post) {
        posts.put(post.getId(), post);
        return post.getId();
    }

    @Override
    public void modify(Post post) {
        posts.replace(post.getId(), post);
    }

    @Override
    public Post remove(long id) {
        return posts.remove(id);
    }

    @Override
    public Post getPost(long id) {
        return posts.get(id);
    }

    @Override
    public List<Post> getPosts() {
        List<Post> postList = new ArrayList<>();
        for (Post post: posts.values()) {
            postList.add(post);
        }
        return postList;
    }
}
