package br.com.alex.graphql;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StaticDatabase {
    Post p1 = new Post("p1", "Some title", "cat", "author");
    Post p2 = new Post("p2", "Some title2", "cat2", "author2");
    Post p3 = new Post("p3", "Some title2", "cat2", "author2");

    Author a1 = new Author("author", "Some author", Lists.newArrayList(p1));
    Author a2 = new Author("author2", "Random!", Lists.newArrayList(p2, p3));

    List<Post> posts = Lists.newArrayList(
            p1, p2, p3
    );

    List<Author> authors = Lists.newArrayList(
            a1, a2
    );

    public List<Post> addPost(Post p) {
        posts.add(p);
        return posts;
    }

}
