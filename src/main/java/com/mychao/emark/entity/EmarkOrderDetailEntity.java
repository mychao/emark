package com.mychao.emark.entity;

import java.util.Date;

public class EmarkOrderDetailEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.order_no
     *
     * @mbggenerated
     */
    private String orderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.category_id
     *
     * @mbggenerated
     */
    private Long categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.category_name
     *
     * @mbggenerated
     */
    private String categoryName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.category_size
     *
     * @mbggenerated
     */
    private String categorySize;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.category_price
     *
     * @mbggenerated
     */
    private Long categoryPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.goods_id
     *
     * @mbggenerated
     */
    private Long goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.goods_name
     *
     * @mbggenerated
     */
    private String goodsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.goods_num
     *
     * @mbggenerated
     */
    private Integer goodsNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_order_detail.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.id
     *
     * @return the value of emark_order_detail.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.id
     *
     * @param id the value for emark_order_detail.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.order_no
     *
     * @return the value of emark_order_detail.order_no
     *
     * @mbggenerated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.order_no
     *
     * @param orderNo the value for emark_order_detail.order_no
     *
     * @mbggenerated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.category_id
     *
     * @return the value of emark_order_detail.category_id
     *
     * @mbggenerated
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.category_id
     *
     * @param categoryId the value for emark_order_detail.category_id
     *
     * @mbggenerated
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.category_name
     *
     * @return the value of emark_order_detail.category_name
     *
     * @mbggenerated
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.category_name
     *
     * @param categoryName the value for emark_order_detail.category_name
     *
     * @mbggenerated
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.category_size
     *
     * @return the value of emark_order_detail.category_size
     *
     * @mbggenerated
     */
    public String getCategorySize() {
        return categorySize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.category_size
     *
     * @param categorySize the value for emark_order_detail.category_size
     *
     * @mbggenerated
     */
    public void setCategorySize(String categorySize) {
        this.categorySize = categorySize == null ? null : categorySize.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.category_price
     *
     * @return the value of emark_order_detail.category_price
     *
     * @mbggenerated
     */
    public Long getCategoryPrice() {
        return categoryPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.category_price
     *
     * @param categoryPrice the value for emark_order_detail.category_price
     *
     * @mbggenerated
     */
    public void setCategoryPrice(Long categoryPrice) {
        this.categoryPrice = categoryPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.goods_id
     *
     * @return the value of emark_order_detail.goods_id
     *
     * @mbggenerated
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.goods_id
     *
     * @param goodsId the value for emark_order_detail.goods_id
     *
     * @mbggenerated
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.goods_name
     *
     * @return the value of emark_order_detail.goods_name
     *
     * @mbggenerated
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.goods_name
     *
     * @param goodsName the value for emark_order_detail.goods_name
     *
     * @mbggenerated
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.goods_num
     *
     * @return the value of emark_order_detail.goods_num
     *
     * @mbggenerated
     */
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.goods_num
     *
     * @param goodsNum the value for emark_order_detail.goods_num
     *
     * @mbggenerated
     */
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.create_time
     *
     * @return the value of emark_order_detail.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.create_time
     *
     * @param createTime the value for emark_order_detail.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_order_detail.update_time
     *
     * @return the value of emark_order_detail.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_order_detail.update_time
     *
     * @param updateTime the value for emark_order_detail.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}