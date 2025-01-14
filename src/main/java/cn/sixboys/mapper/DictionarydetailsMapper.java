package cn.sixboys.mapper;

import cn.sixboys.domain.Dictionarydetails;
import cn.sixboys.util.QueryObject;

import java.util.List;

/**
 * 字典明细Mapper
 */
public interface DictionarydetailsMapper {

    List<Dictionarydetails>selectAll(Dictionarydetails dictionarydetails);

    List<Dictionarydetails> selectById(Long dictionaryId);

    void insert(Dictionarydetails dictionarydetails);

    void delete(Long id);

    void  update(Dictionarydetails dictionarydetails);

    /**
     *查询总条数
     * @param queryObject
     * @return
     */
    int queryForCount(QueryObject queryObject);

    /**
     *查询当前页显示条数信息
     * @param queryObject
     * @return
     */
    List<Dictionarydetails> queryForList(QueryObject queryObject);

    List<Dictionarydetails> queryForListById(QueryObject queryObject);



}
