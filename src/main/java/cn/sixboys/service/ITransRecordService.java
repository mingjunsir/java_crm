package cn.sixboys.service;

import cn.sixboys.domain.TraceRecord;
import cn.sixboys.domain.TransRecord;
import cn.sixboys.util.PageResult;
import cn.sixboys.util.QueryObject;

/**
 * @author mingjuntang
 * @Data 2021/5/18 9:26
 */
public interface ITransRecordService {
    void insert(TransRecord transRecord);
    PageResult<TransRecord> selectTrans(QueryObject queryObject);
}
