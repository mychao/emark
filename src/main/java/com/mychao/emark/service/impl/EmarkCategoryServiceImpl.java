package com.mychao.emark.service.impl;

import com.mychao.emark.entity.EmarkCategoryEntity;
import com.mychao.emark.repository.mapper.EmarkCategoryEntityMapper;
import com.mychao.emark.service.EmarkCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author myc
 * @version 2016/8/3
 */
@Service
public class EmarkCategoryServiceImpl implements EmarkCategoryService{

    @Autowired
    private EmarkCategoryEntityMapper emarkCategoryEntityMapper;

    @Transactional(readOnly = true)
    @Override
    public List<EmarkCategoryEntity> selectAll(EmarkCategoryEntity emarkCategoryEntity) {
        return emarkCategoryEntityMapper.selectAll(emarkCategoryEntity);
    }
}
