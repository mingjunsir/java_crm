package cn.sixboys.controller;

import cn.sixboys.domain.Customer;
import cn.sixboys.domain.JsonResult;
import cn.sixboys.domain.TransRecord;
import cn.sixboys.service.ICustomerService;
import cn.sixboys.service.ITransRecordService;
import cn.sixboys.util.PageResult;
import cn.sixboys.util.QueryObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 移交记录接口
 * @author mingjuntang
 * @Data 2021/5/18 9:33
 */
@Controller
@RequestMapping("/transRecord")
public class TransRecordController {
    @Resource
    private ITransRecordService transRecordService;
    @Resource
    private ICustomerService customerService;

    @RequestMapping("/insert")
    @ResponseBody
    public JsonResult insert(TransRecord transRecord){
        transRecord.setTransTime(new Date());
        transRecordService.insert(transRecord);
        Customer customer = new Customer();
        customer.setSellerId(transRecord.getNewSellerId());
        customer.setId(transRecord.getCustomerId());
        customerService.updateSeller(customer);
        return new JsonResult(true,"插入成功");
    }

    @RequestMapping("/queryForList")
    @ResponseBody
    public JsonResult queryForList(Integer currentPage, Integer pageSize, String keyword, String startTime, String endTime){
        if(currentPage == null) {
            currentPage = 1;
        }
        if(pageSize ==null ) {
            pageSize = 4;
        }

        QueryObject queryObject = new QueryObject();
        queryObject.setCurrentPage(currentPage);
        queryObject.setPageSize(pageSize);
        if (keyword !=null){
            queryObject.setKeyword(keyword);
        }
        if (startTime != null && endTime != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date st = simpleDateFormat.parse(startTime);
                Date et = simpleDateFormat.parse(endTime);
                queryObject.setStartTime(st);
                queryObject.setEndTime(et);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        PageResult<TransRecord> pageResult = transRecordService.selectTrans(queryObject);
        return new JsonResult(true,"查询成功",pageResult);
    }
}
