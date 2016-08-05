package com.emark.emark.service;

import com.emark.emark.EmarkApplicationBaseTests;
import com.mychao.emark.entity.EmarkCategoryEntity;
import com.mychao.emark.service.EmarkCategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author myc
 * @version 2016/8/3
 */
public class EmarkCategoryServiceTests extends EmarkApplicationBaseTests{

    @Autowired
    private EmarkCategoryService emarkCategoryService;

    @Test
    public void selectAllTest(){
        List<EmarkCategoryEntity> list = emarkCategoryService.selectAll(null);

    }


}
