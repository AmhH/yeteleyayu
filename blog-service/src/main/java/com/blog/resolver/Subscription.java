package com.blog.resolver;

import com.blog.publisher.CommentPublisher;
import com.blog.publisher.NoteUpdate;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
public class Subscription implements GraphQLSubscriptionResolver {
    private CommentPublisher commentPublisher;

    public Subscription(CommentPublisher commentPublisher) {
        this.commentPublisher = commentPublisher;
    }

    public Publisher<NoteUpdate> notes() {
        return commentPublisher.getPublisher();
    }
}
