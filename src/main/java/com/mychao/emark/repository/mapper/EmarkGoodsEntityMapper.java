package com.mychao.emark.repository.mapper;

import com.mychao.emark.entity.EmarkGoodsEntity;

public interface EmarkGoodsEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_goods
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_goods
     *
     * @mbggenerated
     */
    int insert(EmarkGoodsEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_goods
     *
     * @mbggenerated
     */
    int insertSelective(EmarkGoodsEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_goods
     *
     * @mbggenerated
     */
    EmarkGoodsEntity selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_goods
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(EmarkGoodsEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emark_goods
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(EmarkGoodsEntity record);
}