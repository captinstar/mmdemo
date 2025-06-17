package org.cssic.mmdemo.dao;

import org.cssic.mmdemo.model.DataEntity;

import java.util.List;

public interface DataDao {
    DataEntity findById(Long id);
    List<DataEntity> findByCategory(String category);
    List<DataEntity> findByCreatedBy(Long userId);
    List<DataEntity> findAll();
    void save(DataEntity data);
    void update(DataEntity data);
    void delete(Long id);
}
