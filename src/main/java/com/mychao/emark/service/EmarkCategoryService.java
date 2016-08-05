package com.mychao.emark.service;

import com.mychao.emark.entity.EmarkCategoryEntity;

import java.util.List;

/**
 * @author myc
 * @version 2016/8/3
 */
public interface EmarkCategoryService {
    public List<EmarkCategoryEntity> selectAll(EmarkCategoryEntity emarkCategoryEntity);
}
