package cn.sixboys.mapper;

import cn.sixboys.domain.TraceRecord;
import cn.sixboys.domain.TransRecord;
import cn.sixboys.util.QueryObject;

import java.util.List;

/**
 * @author mingjuntang
 * @Data 2021/5/17 9:09
 */
public interface TransRecordMapper {

    /**
     * 插入数据
     * @param transRecord
     */
    void insert(TransRecord transRecord);

    /**
     * 分页查询
     * @param queryObject
     * @return
     */
    List<TransRecord> queryForList(QueryObject queryObject);

    /**
     * 查询总记录数
     * @param queryObject
     * @return
     */
    int queryForCount(QueryObject queryObject);
}
