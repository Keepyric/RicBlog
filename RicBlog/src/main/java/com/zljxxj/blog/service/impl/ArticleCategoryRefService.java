package com.zljxxj.blog.service.impl;


import com.zljxxj.blog.entity.ArticleCategoryRef;
import com.zljxxj.blog.entity.Category;
import com.zljxxj.blog.mapper.ArticleCategoryRefMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCategoryRefService implements ArticleCategoryRefMapper {

    @Override
    public int insert(ArticleCategoryRef record) {
        return 0;
    }

    @Override
    public int deleteByCategoryId(Integer categoryId) {
        return 0;
    }

    @Override
    public int deleteByArticleId(Integer articleId) {
        return 0;
    }

    @Override
    public int countArticleByCategoryId(Integer categoryId) {
        return 0;
    }

    @Override
    public List<Integer> selectCategoryIdByArticleId(Integer articleId) {
        return null;
    }

    @Override
    public List<Integer> selectArticleIdByCategoryId(Integer categoryId) {
        return null;
    }

    @Override
    public List<Category> listCategoryByArticleId(Integer articleId) {
        return null;
    }
}
