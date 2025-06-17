package org.cssic.mmdemo.model;

import java.io.Serializable;

public class DataEntity implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String value;
    private String category;
    private Long createdBy;
    private java.util.Date createdDate;

    public DataEntity() {
    }

    public DataEntity(Long id, String name, String description, String value, String category, Long createdBy, java.util.Date createdDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.category = category;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public java.util.Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value='" + value + '\'' +
                ", category='" + category + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                '}';
    }
}
