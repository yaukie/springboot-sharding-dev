package org.yaukie.demo.autocode.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yaukie.demo.autocode.model.TEncryptOrder;
import org.yaukie.demo.autocode.model.TEncryptOrderExample;

public interface TEncryptOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    long countByExample(TEncryptOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    int deleteByExample(TEncryptOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    int insert(TEncryptOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    int insertSelective(TEncryptOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    List<TEncryptOrder> selectByExample(TEncryptOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    TEncryptOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    int updateByExampleSelective(@Param("record") TEncryptOrder record, @Param("example") TEncryptOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    int updateByExample(@Param("record") TEncryptOrder record, @Param("example") TEncryptOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    int updateByPrimaryKeySelective(TEncryptOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_encrypt_order
     *
     * @mbg.generated Mon Mar 30 09:45:06 CST 2020
     */
    int updateByPrimaryKey(TEncryptOrder record);
}