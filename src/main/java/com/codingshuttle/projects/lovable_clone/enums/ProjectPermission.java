package com.codingshuttle.projects.lovable_clone.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProjectPermission {

    VIEW("project:view"),
    EDIT("project:edit"),
    DELETE("project:delete"),

    MANAGE_MEMBER("project_members:manage"),
    VIEW_MEMBER("project_members:view");

    private final String value;
}
