package com.mychao.emark.entity;

import java.util.Date;

public class EmarkGoodsEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_goods.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_goods.category_id
     *
     * @mbggenerated
     */
    private Long categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_goods.goods_name
     *
     * @mbggenerated
     */
    private String goodsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_goods.goods_img
     *
     * @mbggenerated
     */
    private String goodsImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_goods.goods_thumbnail
     *
     * @mbggenerated
     */
    private String goodsThumbnail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_goods.show_status
     *
     * @mbggenerated
     */
    private Byte showStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_goods.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emark_goods.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_goods.id
     *
     * @return the value of emark_goods.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_goods.id
     *
     * @param id the value for emark_goods.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_goods.category_id
     *
     * @return the value of emark_goods.category_id
     *
     * @mbggenerated
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_goods.category_id
     *
     * @param categoryId the value for emark_goods.category_id
     *
     * @mbggenerated
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_goods.goods_name
     *
     * @return the value of emark_goods.goods_name
     *
     * @mbggenerated
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_goods.goods_name
     *
     * @param goodsName the value for emark_goods.goods_name
     *
     * @mbggenerated
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_goods.goods_img
     *
     * @return the value of emark_goods.goods_img
     *
     * @mbggenerated
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_goods.goods_img
     *
     * @param goodsImg the value for emark_goods.goods_img
     *
     * @mbggenerated
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_goods.goods_thumbnail
     *
     * @return the value of emark_goods.goods_thumbnail
     *
     * @mbggenerated
     */
    public String getGoodsThumbnail() {
        return goodsThumbnail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_goods.goods_thumbnail
     *
     * @param goodsThumbnail the value for emark_goods.goods_thumbnail
     *
     * @mbggenerated
     */
    public void setGoodsThumbnail(String goodsThumbnail) {
        this.goodsThumbnail = goodsThumbnail == null ? null : goodsThumbnail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_goods.show_status
     *
     * @return the value of emark_goods.show_status
     *
     * @mbggenerated
     */
    public Byte getShowStatus() {
        return showStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_goods.show_status
     *
     * @param showStatus the value for emark_goods.show_status
     *
     * @mbggenerated
     */
    public void setShowStatus(Byte showStatus) {
        this.showStatus = showStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_goods.create_time
     *
     * @return the value of emark_goods.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_goods.create_time
     *
     * @param createTime the value for emark_goods.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emark_goods.update_time
     *
     * @return the value of emark_goods.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emark_goods.update_time
     *
     * @param updateTime the value for emark_goods.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}