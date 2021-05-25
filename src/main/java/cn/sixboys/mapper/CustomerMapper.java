package cn.sixboys.mapper;

import cn.sixboys.domain.Customer;
import cn.sixboys.domain.Statement;
import cn.sixboys.util.QueryObject;

import java.util.List;

/**
 * 客户管理Mapper
 * @author mingjuntang
 * @Data 2021/5/14 21:49
 */
public interface CustomerMapper {
    /**
     * 分页查询
     * @param queryObject
     * @return
     */
    List<Customer> queryForList(QueryObject queryObject);

    /**
     * 新增一条客户数据
     * @param customer
     */
    void insert(Customer customer);

    /**
     * 更新一条客户数据
     * @param customer
     */
    void update(Customer customer);

    /**
     * 查询总记录数
     */
    int queryForCount(QueryObject queryObject);

    void updateStatus(Customer customer);
    void updateSeller(Customer customer);
    List<Statement> selectStatement(QueryObject queryObject);
}
