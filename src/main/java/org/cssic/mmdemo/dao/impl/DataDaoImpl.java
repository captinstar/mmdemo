package org.cssic.mmdemo.dao.impl;

import org.cssic.mmdemo.dao.DataDao;
import org.cssic.mmdemo.model.DataEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class DataDaoImpl implements DataDao {
    private static final String FIND_BY_ID_SQL = "SELECT * FROM data_entities WHERE id = ?";
    private static final Logger logger = LoggerFactory.getLogger(DataDaoImpl.class);
    
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
    public DataEntity save(DataEntity data) {
        String sql = "INSERT INTO data_entities (name, description, value, category, created_by, created_date) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getName());
            ps.setString(2, data.getDescription());
            ps.setString(3, data.getValue());
            ps.setString(4, data.getCategory());
            ps.setLong(5, data.getCreatedBy());
            ps.setTimestamp(6, new Timestamp(data.getCreatedDate().getTime()));
            return ps;
        }, keyHolder);

        data.setId(keyHolder.getKey().longValue());
        return data;
    }

    @Override
    public DataEntity update(DataEntity data) {
        String sql = "UPDATE data_entities SET name = ?, description = ?, value = ?, category = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql,
                data.getName(),
                data.getDescription(),
                data.getValue(),
                data.getCategory(),
                data.getId()
        );

        return rowsAffected > 0 ? findById(data.getId()) : null;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM data_entities WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}