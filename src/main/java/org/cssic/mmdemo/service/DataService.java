package org.cssic.mmdemo.service;

import org.cssic.mmdemo.model.DataEntity;

import java.util.List;

public interface DataService {
    DataEntity findById(Long id);
    List<DataEntity> findByCategory(String category);
    List<DataEntity> findByCreatedBy(Long userId);
    List<DataEntity> findAll();

    DataEntity save(DataEntity data);    // 改为返回 DataEntity

    DataEntity update(DataEntity data);  // 改为返回 DataEntity
    void delete(Long id);
}