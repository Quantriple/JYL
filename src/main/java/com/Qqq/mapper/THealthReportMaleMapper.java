package com.Qqq.mapper;

import com.Qqq.entity.THealthReportMale;
import java.util.List;

public interface THealthReportMaleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_male
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_male
     *
     * @mbg.generated
     */
    int insert(THealthReportMale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_male
     *
     * @mbg.generated
     */
    THealthReportMale selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_male
     *
     * @mbg.generated
     */
    List<THealthReportMale> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_male
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(THealthReportMale record);
}