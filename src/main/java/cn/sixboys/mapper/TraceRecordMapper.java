package cn.sixboys.mapper;

import cn.sixboys.domain.TraceRecord;
import cn.sixboys.util.QueryObject;

import java.util.List;

/**
 * @author mingjuntang
 * @Data 2021/5/15 20:28
 */
public interface TraceRecordMapper {

    /**
     * 分页查询
     * @param queryObject
     * @return
     */
    List<TraceRecord> queryForList(QueryObject queryObject);

    /**
     * 插入数据
     * @param traceRecord
     */
    void insert(TraceRecord traceRecord);

    /**
     * 查询总记录数
     * @param queryObject
     * @return
     */
    int queryForCount(QueryObject queryObject);
}
