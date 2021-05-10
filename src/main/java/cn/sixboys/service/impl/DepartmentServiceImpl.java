package cn.sixboys.service.impl;



import cn.sixboys.domain.Department;
import cn.sixboys.mapper.DepartmentMapper;
import cn.sixboys.service.IDepartmentService;
import cn.sixboys.util.PageResult;
import cn.sixboys.util.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public int select(Department department) {

        return departmentMapper.select(department);

    }

    @Override
    public void delete(Long id) {
        departmentMapper.deleteByid(id);
    }

    @Override
    public void input(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    /**
     *分页查询信息
     * @param queryObject
     * @return
     */
    @Override
    public PageResult<Department> query(QueryObject queryObject) {
        int totalCount = departmentMapper.queryForCount(queryObject);
        if (totalCount==0){
            return new PageResult<>(queryObject.getCurrentPage(), queryObject.getPageSize(),totalCount, Collections.emptyList());
        }
        List<Department> departments = departmentMapper.queryForList(queryObject);
        return new PageResult<>(queryObject.getCurrentPage(),queryObject.getPageSize(),totalCount,departments);

    }
}
