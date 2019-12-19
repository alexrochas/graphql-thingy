package br.com.alex.graphql;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class PostPublisher {

    private static final Logger LOG = LoggerFactory.getLogger(PostPublisher.class);

    private final Subject<Post> postObservable;
    private final Flowable<Post> publisher;
    ConnectableObservable<Post> connectableObservable;

    public PostPublisher() {
        Subject<Post> postObservable = PublishSubject.create();

        this.postObservable = postObservable;

        connectableObservable = postObservable.share().publish();
        connectableObservable.connect();
        Flowable<Post> publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
        this.publisher = publisher;
    }

    public Subject<Post> getPostObservable() {
        return postObservable;
    }

    public Flowable<Post> getPublisher() {
        return publisher;
    }

    public Flowable<Post> getPublisher(List<String> authorId) {
        if (authorId != null) {
            return publisher.filter(post -> authorId.contains(post.getAuthorId()));
        }
        return publisher;
    }

}
