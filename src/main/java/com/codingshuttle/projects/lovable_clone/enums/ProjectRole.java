package com.codingshuttle.projects.lovable_clone.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.codingshuttle.projects.lovable_clone.enums.ProjectPermission.*;

@Getter
@RequiredArgsConstructor
public enum ProjectRole {
    EDITOR(VIEW, EDIT, DELETE,VIEW_MEMBER),
    VIEWER(Set.of(VIEW,VIEW_MEMBER)),
    OWNER(Set.of(VIEW, EDIT, DELETE, MANAGE_MEMBER,VIEW_MEMBER));

    ProjectRole(ProjectPermission... projectPermission){
        this.permissions = Set.of(projectPermission);
    }


    private final Set<ProjectPermission> permissions;
}
