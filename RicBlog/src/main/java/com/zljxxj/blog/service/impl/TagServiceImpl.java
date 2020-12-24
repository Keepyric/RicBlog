package com.zljxxj.blog.service.impl;

import com.zljxxj.blog.entity.Tag;
import com.zljxxj.blog.mapper.TagMapper;
import com.zljxxj.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Integer countTag() {
        return null;
    }

    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }

    @Override
    public List<Tag> listTagWithCount() {
        return null;
    }

    @Override
    public Tag getTagById(Integer id) {
        return null;
    }

    @Override
    public Tag insertTag(Tag tag) {
        return null;
    }

    @Override
    public void updateTag(Tag tag) {

    }

    @Override
    public void deleteTag(Integer id) {

    }

    @Override
    public Tag getTagByName(String name) {
        return null;
    }

    @Override
    public List<Tag> listTagByArticleId(Integer articleId) {
        return null;
    }
}
