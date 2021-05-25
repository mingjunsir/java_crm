package cn.sixboys.domain;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * 移交记录实体类
 * @author mingjuntang
 * @Data 2021/5/17 9:01
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransRecord {
    private Long id;
    private Long customerId;
    private String transUser;
    @DateTimeFormat(value = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date transTime;
    private String oldSeller;
    private Long newSellerId;
    private String transReason;

    private Customer customer;
    private Employee employee;
}
