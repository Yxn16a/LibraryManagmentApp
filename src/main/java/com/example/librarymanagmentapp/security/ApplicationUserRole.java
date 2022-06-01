package com.example.librarymanagmentapp.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.librarymanagmentapp.security.ApplicationUserPermission.*;
@AllArgsConstructor
@Getter
public enum ApplicationUserRole {
    LIBRARYUSER(Sets.newHashSet(BOOKSUGGESTION_READ,BOOK_WRITE)),
    MANAGER(Sets.newHashSet(BOOK_READ, BOOK_WRITE,LIBRARIAN_READ,
                           LIBRARIAN_WRITE,MEMBERS_READ,MEMBERS_WRITE,
                           RACK_READ,RACK_WRITE)),
    LIBLARIAN(Sets.newHashSet(BOOK_READ, RACK_READ,RACK_WRITE,BOOK_WRITE,
                               MEMBERS_READ,MEMBERS_WRITE));

    // TODO SEE IF MEMBER IS NECESSARY HERE MEMBER(Sets.newHashSet(BOOK_READ));


    private final Set<ApplicationUserPermission> permissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

}
