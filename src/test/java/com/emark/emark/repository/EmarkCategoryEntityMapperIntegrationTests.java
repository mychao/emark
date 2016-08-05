package com.emark.emark.repository;

import com.emark.emark.EmarkApplicationBaseTests;
import com.mychao.emark.entity.EmarkCategoryEntity;
import com.mychao.emark.repository.mapper.EmarkCategoryEntityMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author myc
 * @version 2016/8/3
 */
public class EmarkCategoryEntityMapperIntegrationTests extends EmarkApplicationBaseTests{

    @Autowired
    private EmarkCategoryEntityMapper emarkCategoryEntityMapper;

    @Test
    public void testEmarkCategoryEntityMapper(){
        insertSelectiveTest();
        selectByPrimaryKeyTest();
        updateByPrimaryKeySelectiveTest();
        selectByPrimaryKeyTest();
        deleteByPrimaryKeyTest();
    }

    private void insertSelectiveTest(){
        EmarkCategoryEntity emarkCategoryEntity = new EmarkCategoryEntity();
        emarkCategoryEntity.setId(1l);
        emarkCategoryEntity.setCategoryName("标准版");
        int ret = emarkCategoryEntityMapper.insertSelective(emarkCategoryEntity);
        Assert.assertTrue(ret == 1);
    }

    private void selectByPrimaryKeyTest(){
        EmarkCategoryEntity emarkCategoryEntity = emarkCategoryEntityMapper.selectByPrimaryKey(1l);
        Assert.assertNotNull(emarkCategoryEntity);
    }

    private void updateByPrimaryKeySelectiveTest(){
        EmarkCategoryEntity emarkCategoryEntity = new EmarkCategoryEntity();
        emarkCategoryEntity.setId(1l);
        emarkCategoryEntity.setCategoryName("普通版");
        int ret = emarkCategoryEntityMapper.updateByPrimaryKeySelective(emarkCategoryEntity);
        Assert.assertTrue(ret == 1);
    }

    private void deleteByPrimaryKeyTest(){
        int ret = emarkCategoryEntityMapper.deleteByPrimaryKey(1l);
        Assert.assertTrue(ret == 1);
    }

    @Test
    public void selectAllTest(){
        EmarkCategoryEntity emarkCategoryEntity = new EmarkCategoryEntity();
        emarkCategoryEntity.setId(111l);
        List<EmarkCategoryEntity> list = emarkCategoryEntityMapper.selectAll(emarkCategoryEntity);
    }

}
