package dev.akshith6212.blog.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Article {
    Integer author_id;
    String title;
    String time_created;
    String time_updated;
    String content;

    @Override
    public String toString() {
        return "Blog{" +
                "author_id=" + author_id +
                ", title='" + title + '\'' +
                ", time_created='" + time_created + '\'' +
                ", time_updated='" + time_updated + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
