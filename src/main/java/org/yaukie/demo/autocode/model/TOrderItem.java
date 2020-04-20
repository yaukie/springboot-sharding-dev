package org.yaukie.demo.autocode.model;

import java.util.Date;

public class TOrderItem {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.id
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.order_id
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.item_id
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    private Integer itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.item_name
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    private String itemName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.item_type
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    private String itemType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.created_time
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    private Date createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.update_time
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.id
     *
     * @return the value of t_order_item.id
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.id
     *
     * @param id the value for t_order_item.id
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.order_id
     *
     * @return the value of t_order_item.order_id
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.order_id
     *
     * @param orderId the value for t_order_item.order_id
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.item_id
     *
     * @return the value of t_order_item.item_id
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.item_id
     *
     * @param itemId the value for t_order_item.item_id
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.item_name
     *
     * @return the value of t_order_item.item_name
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.item_name
     *
     * @param itemName the value for t_order_item.item_name
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.item_type
     *
     * @return the value of t_order_item.item_type
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.item_type
     *
     * @param itemType the value for t_order_item.item_type
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.created_time
     *
     * @return the value of t_order_item.created_time
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.created_time
     *
     * @param createdTime the value for t_order_item.created_time
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.update_time
     *
     * @return the value of t_order_item.update_time
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.update_time
     *
     * @param updateTime the value for t_order_item.update_time
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_item
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TOrderItem other = (TOrderItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getItemType() == null ? other.getItemType() == null : this.getItemType().equals(other.getItemType()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order_item
     *
     * @mbg.generated Sun Mar 29 21:19:03 CST 2020
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getItemType() == null) ? 0 : getItemType().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}