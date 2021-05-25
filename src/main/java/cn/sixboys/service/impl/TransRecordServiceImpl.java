package cn.sixboys.service.impl;

import cn.sixboys.domain.TraceRecord;
import cn.sixboys.domain.TransRecord;
import cn.sixboys.mapper.TransRecordMapper;
import cn.sixboys.service.ITransRecordService;
import cn.sixboys.util.PageResult;
import cn.sixboys.util.QueryObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 移交记录实现类
 * @author mingjuntang
 * @Data 2021/5/18 9:28
 */
@Service
public class TransRecordServiceImpl implements ITransRecordService {
    @Resource
    private TransRecordMapper transRecordMapper;
    @Override
    public void insert(TransRecord transRecord) {
        transRecordMapper.insert(transRecord);
    }

    @Override
    public PageResult<TransRecord> selectTrans(QueryObject queryObject) {
        List<TransRecord> transRecords = transRecordMapper.queryForList(queryObject);
        int i = transRecordMapper.queryForCount(queryObject);
        PageResult<TransRecord> pageResult = new PageResult<>(queryObject.getCurrentPage(),queryObject.getPageSize(),i,transRecords);
        return pageResult;
    }
}
