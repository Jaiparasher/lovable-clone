package com.codingshuttle.projects.lovable_clone.security;

import com.codingshuttle.projects.lovable_clone.enums.ProjectRole;
import com.codingshuttle.projects.lovable_clone.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions {

    private final ProjectMemberRepository projectMemberRepository;
    private final AuthUtil authUtil;

    public boolean canViewProject(long projectId){
        Long userId = authUtil.getCurrentUserId();

        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId,userId).
                map(role -> role.equals(ProjectRole.OWNER) || role.equals(ProjectRole.EDITOR) || role.equals(ProjectRole.VIEWER))
                .orElse(false);

    }
    public boolean canEditProject(long projectId){
        Long userId = authUtil.getCurrentUserId();

        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId,userId).
                map(role -> role.equals(ProjectRole.OWNER) || role.equals(ProjectRole.EDITOR))
                .orElse(false);
    }
}
