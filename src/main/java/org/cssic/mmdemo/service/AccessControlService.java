package org.cssic.mmdemo.service;

import org.cssic.mmdemo.model.User;
import org.springframework.stereotype.Service;

@Service
public class AccessControlService {

    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";
    private static final String ROLE_GUEST = "GUEST";

    /**
     * 检查用户是否有管理员权限
     */
    public boolean isAdmin(User user) {
        return user != null && ROLE_ADMIN.equals(user.getRole());
    }

    /**
     * 检查用户是否有普通用户权限
     */
    public boolean isUser(User user) {
        return user != null && (ROLE_USER.equals(user.getRole()) || ROLE_ADMIN.equals(user.getRole()));
    }

    /**
     * 检查用户是否有权限访问某个数据
     */
    public boolean canAccessData(User user, Long dataCreatedBy) {
        if (user == null) {
            return false;
        }

        // 管理员可以访问所有数据
        if (ROLE_ADMIN.equals(user.getRole())) {
            return true;
        }

        // 普通用户只能访问自己创建的数据
        return ROLE_USER.equals(user.getRole()) && user.getId().equals(dataCreatedBy);
    }

    /**
     * 检查用户是否有权限修改某个数据
     */
    public boolean canModifyData(User user, Long dataCreatedBy) {
        return canAccessData(user, dataCreatedBy);
    }
}
