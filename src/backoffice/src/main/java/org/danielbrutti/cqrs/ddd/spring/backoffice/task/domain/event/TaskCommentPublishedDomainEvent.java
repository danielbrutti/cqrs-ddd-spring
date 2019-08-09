package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain.event;

import org.danielbrutti.cqrs.ddd.spring.shared.domain.bus.event.DomainEvent;

import java.util.Map;

public final class TaskCommentPublishedDomainEvent extends DomainEvent {

    private String commentId;
    private String commentContent;

    public TaskCommentPublishedDomainEvent(String aggregateId, String commentId, String commentContent) {
        super(aggregateId);
        this.commentId = commentId;
        this.commentContent = commentContent;
    }

    @Override
    public String getEventName() {
        return "org.danielbrutti.task.comment.published";
    }

    public String getCommentId() {
        return commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }
}
