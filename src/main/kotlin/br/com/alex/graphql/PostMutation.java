package br.com.alex.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PostMutation implements GraphQLMutationResolver {
    @Autowired
    private StaticDatabase postDao;
    @Autowired
    private PostPublisher postPublisher;

    public List<Post> writePost(String title, String text, String category) {
        Post post = new Post(UUID.randomUUID().toString(), title, text, category);
        postPublisher.getPostObservable().onNext(post);
        return postDao.addPost(post);
    }
}
