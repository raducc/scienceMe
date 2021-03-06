package com.scncm.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {

    private static final long serialVersionUID = -5527566191402296042L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_id_seq")
    @SequenceGenerator(name = "tag_id_seq", sequenceName = "tag_id_seq", allocationSize = 1)
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "tag_name")
    private String tagName;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ArticleTag> articleTags;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<ArticleTag> getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(Set<ArticleTag> articleTags) {
        this.articleTags = articleTags;
    }
}
