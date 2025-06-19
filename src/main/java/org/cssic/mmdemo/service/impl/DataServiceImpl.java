package org.cssic.mmdemo.service.impl;

import org.cssic.mmdemo.dao.DataDao;
import org.cssic.mmdemo.model.DataEntity;
import org.cssic.mmdemo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    private final DataDao dataDao;

    @Autowired
    public DataServiceImpl(DataDao dataDao) {
        this.dataDao = dataDao;
    }

    @Override
    public DataEntity findById(Long id) {
        return dataDao.findById(id);
    }

    @Override
    public List<DataEntity> findByCategory(String category) {
        return dataDao.findByCategory(category);
    }

    @Override
    public List<DataEntity> findByCreatedBy(Long userId) {
        return dataDao.findByCreatedBy(userId);
    }

    @Override
    public List<DataEntity> findAll() {
        return dataDao.findAll();
    }

    @Override
    public DataEntity save(DataEntity data) {
        if (data.getCreatedDate() == null) {
            data.setCreatedDate(new Date());
        }
        return dataDao.save(data);  // 返回保存后的实体
    }

    @Override
    public DataEntity update(DataEntity data) {
        return dataDao.update(data);  // 返回更新后的实体
    }

    @Override
    public void delete(Long id) {
        dataDao.delete(id);
    }
}