package com.rdd.pia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author smoothwind
 */
@Entity
@Table(name = "app.article_comments")
public class ArticleComment {
    @Id
    @Column(name = "id_comments")
    private int idComments;
}
