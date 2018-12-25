package com.rdd.pia.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "app.article")
public class Article {
    @Id
    @Column(name="idarticle")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idArticle;

    @Column(name="author_id")
    private String authorId;

    @Column(name = "comment_id")
    private String commentId;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "tags_id")
    private String tagsId;

    @Basic(fetch= FetchType.LAZY)
    @Lob
    @Column
    private String articleBody;

    @Column
    private int status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;


    public Article() {
    }


}
