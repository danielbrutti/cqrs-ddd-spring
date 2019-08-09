package org.danielbrutti.cqrs.ddd.spring.backoffice.task.domain;

public final class Comment {

    private Task task;
    private CommentId commentId;
    private CommentContent content;
    private CommentDateTime dateTime;

    protected Comment(Task task, CommentId commentId, CommentContent content, CommentDateTime dateTime) {
        this.task = task;
        this.commentId = commentId;
        this.content = content;
        this.dateTime = dateTime;
    }

    public CommentId getCommentId() {
        return commentId;
    }

    public CommentContent getContent() {
        return content;
    }

    public CommentDateTime getDateTime() {
        return dateTime;
    }
}
