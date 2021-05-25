package cn.sixboys.mapper;

import cn.sixboys.domain.Employee;
import cn.sixboys.util.QueryObject;

import java.util.List;

/**
 * 员工管理Mapper
 * @author mingjuntang
 * @Data 2021/5/9 14:42
 */
public interface EmployeeMapper {

    /**
     * 通过id,删除员工数据
     * @param id
     */
    void delete(Long id);
    void insert(Employee employee);
    void update(Employee employee);
    Employee selectOne(Long id);

    /**
     * 查询总记录数
     */
    int queryForCount(QueryObject queryObject);

    /**
     * 根据条件查询员工
     */
    List<Employee> queryForList(QueryObject queryObject);

    /**
     * 批量删除
     */
    void deleteEmployees(int[] ids);

    /**
     * 批量增加
     * @param employees
     */
    void addEmployees(List<Employee> employees);

    /**
     * 查询所有员工
     * @param employee
     * @return
     */
    List<Employee> selectAll(Employee employee);

    List<Employee> selectSeller(Employee employee);

    Employee queryEmployeeByUsernameAndPassword(Employee employee);
}
