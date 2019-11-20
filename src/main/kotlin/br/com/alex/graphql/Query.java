package br.com.alex.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private StaticDatabase database;

    public List<Post> getRecentPosts(int count, int offset) {
        System.out.println("Querying for " + count + " with offset " + offset);
        return database.posts;
    }
}
