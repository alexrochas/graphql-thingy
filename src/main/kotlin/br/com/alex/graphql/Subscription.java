package br.com.alex.graphql;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import io.reactivex.BackpressureStrategy;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class Subscription implements GraphQLSubscriptionResolver {

    private PostPublisher postPublisher;

    Subscription(PostPublisher postPublisher) {
        this.postPublisher = postPublisher;
    }

    public Publisher<Post> getPosts(List<String> authors) {
        //return postPublisher.getPostObservable().toFlowable(BackpressureStrategy.BUFFER).publish().autoConnect();
        return postPublisher.getPublisher(authors);
    }

}