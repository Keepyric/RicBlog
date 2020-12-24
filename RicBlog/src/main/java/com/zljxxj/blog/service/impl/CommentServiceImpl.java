package com.zljxxj.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.zljxxj.blog.entity.Comment;
import com.zljxxj.blog.mapper.CommentMapper;
import com.zljxxj.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;


    @Override
    public void insertComment(Comment comment) {

    }

    @Override
    public List<Comment> listCommentByArticleId(Integer articleId) {
        return commentMapper.listCommentByArticleId(articleId);
    }

    @Override
    public Comment getCommentById(Integer id) {
        return null;
    }

    @Override
    public PageInfo<Comment> listCommentByPage(Integer pageIndex, Integer pageSize) {
        return null;
    }

    @Override
    public List<Comment> listComment() {
        return null;
    }

    @Override
    public void deleteComment(Integer id) {

    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public Integer countComment() {
        return null;
    }

    @Override
    public List<Comment> listRecentComment(Integer limit) {
        return commentMapper.listRecentComment(limit);
    }

    @Override
    public List<Comment> listChildComment(Integer id) {
        return null;
    }
}
