package com.codingshuttle.projects.lovable_clone.security;

import com.codingshuttle.projects.lovable_clone.enums.ProjectPermission;
import com.codingshuttle.projects.lovable_clone.enums.ProjectRole;
import com.codingshuttle.projects.lovable_clone.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions {

    private final ProjectMemberRepository projectMemberRepository;
    private final AuthUtil authUtil;

    public boolean hasPermission(Long projectId, ProjectPermission projectPermission){
        Long userId = authUtil.getCurrentUserId();

        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId,userId).
                map(role -> role.getPermissions().contains(projectPermission))
                .orElse(false);
    }

    public boolean canViewProject(long projectId){
        return hasPermission(projectId,ProjectPermission.VIEW);
    }
    public boolean canEditProject(long projectId){
        return hasPermission(projectId,ProjectPermission.EDIT);
    }
    public boolean canDeleteProject(long projectId){
        return hasPermission(projectId,ProjectPermission.DELETE);
    }
    public boolean canViewMembers(long projectId){
        return hasPermission(projectId,ProjectPermission.VIEW_MEMBER);
    }
    public boolean canManageMembers(long projectId){
        return hasPermission(projectId,ProjectPermission.MANAGE_MEMBER);
    }
}
