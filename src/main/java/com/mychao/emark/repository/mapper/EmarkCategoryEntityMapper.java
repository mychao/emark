package com.mychao.emark.repository.mapper;

import com.mychao.emark.entity.EmarkCategoryEntity;

import java.util.List;

public interface EmarkCategoryEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_category
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_category
     *
     * @mbggenerated
     */
    int insert(EmarkCategoryEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_category
     *
     * @mbggenerated
     */
    int insertSelective(EmarkCategoryEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_category
     *
     * @mbggenerated
     */
    EmarkCategoryEntity selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_category
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(EmarkCategoryEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_category
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(EmarkCategoryEntity record);

    /**
     * 查询所有分类列表
     * @param record 排序字段，按照非null值排序
     * @return
     */
    List<EmarkCategoryEntity> selectAll(EmarkCategoryEntity record);
}