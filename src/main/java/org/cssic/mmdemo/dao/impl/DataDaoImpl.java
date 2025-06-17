package org.cssic.mmdemo.dao.impl;

import org.cssic.mmdemo.dao.DataDao;
import org.cssic.mmdemo.model.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DataDaoImpl implements DataDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class DataRowMapper implements RowMapper<DataEntity> {
        @Override
        public DataEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            DataEntity data = new DataEntity();
            data.setId(rs.getLong("id"));
            data.setName(rs.getString("name"));
            data.setDescription(rs.getString("description"));
            data.setValue(rs.getString("value"));
            data.setCategory(rs.getString("category"));
            data.setCreatedBy(rs.getLong("created_by"));
            data.setCreatedDate(rs.getTimestamp("created_date"));
            return data;
        }
    }

    @Override
    public DataEntity findById(Long id) {
        String sql = "SELECT * FROM data_entities WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new DataRowMapper(), id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<DataEntity> findByCategory(String category) {
        String sql = "SELECT * FROM data_entities WHERE category = ?";
        return jdbcTemplate.query(sql, new DataRowMapper(), category);
    }

    @Override
    public List<DataEntity> findByCreatedBy(Long userId) {
        String sql = "SELECT * FROM data_entities WHERE created_by = ?";
        return jdbcTemplate.query(sql, new DataRowMapper(), userId);
    }

    @Override
    public List<DataEntity> findAll() {
        String sql = "SELECT * FROM data_entities";
        return jdbcTemplate.query(sql, new DataRowMapper());
    }

    @Override
    public void save(DataEntity data) {
        String sql = "INSERT INTO data_entities (name, description, value, category, created_by, created_date) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, data.getName(), data.getDescription(), data.getValue(), 
                data.getCategory(), data.getCreatedBy(), new java.sql.Timestamp(data.getCreatedDate().getTime()));
    }

    @Override
    public void update(DataEntity data) {
        String sql = "UPDATE data_entities SET name = ?, description = ?, value = ?, category = ? WHERE id = ?";
        jdbcTemplate.update(sql, data.getName(), data.getDescription(), data.getValue(), data.getCategory(), data.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM data_entities WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
