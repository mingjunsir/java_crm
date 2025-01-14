package cn.sixboys.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 员工类实体对象
 * @author mingjuntang
 * @Data 2021/5/9 14:38
 */

@Getter
@Setter
@ToString
public class Employee {
    @ExcelIgnore
    private Long id;
    private String name;
    private String password;
    private String email;
    private Integer age;
    private Long deptId;
    @DateTimeFormat(value = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date hireDate;
    private Integer state;
    private Integer admin;
    private Integer roleId;
    //关联属性
    private Department department;
    private Role role;
}
