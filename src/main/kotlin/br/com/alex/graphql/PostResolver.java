package br.com.alex.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostResolver implements GraphQLResolver<Post> {

    @Autowired
    private StaticDatabase database;

    public Author getAuthor(Post post) {
        System.out.println("Resolving author for post " + post.getId());
        return database.authors.stream()
                .filter(author -> author.getId().equals(post.getAuthorId()))
                .findFirst()
                .get();
    }
}
