package com.liu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 文章评论信息
 */
public class Comment {
    /**
     * 评论id
     */
    private Integer id;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论者
     */
    private Integer user_id;
    /**
     * 评论所属文章
     */
    private Integer article_id;
}
