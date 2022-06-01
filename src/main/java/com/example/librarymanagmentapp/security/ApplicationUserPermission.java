package com.example.librarymanagmentapp.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApplicationUserPermission {
    // REQUESTING A BOOK HAS TO BE WORKED ON
    BOOK_READ("book:read"),
    BOOK_WRITE("book:write"),
    AUTHOR_READ("author:read"),
    AUTHOR_WRITE("author:write"),

    BELONGING_READ("belonging:read"),
    BELONGING_WRITE("belonging:write"),

    BOOK_STATUS_READ("bookstatus:read"),
    BOOK_STATUS_WRITE("bookstatus:write"),

    MEMBERS_READ("members:read"),
    MEMBERS_WRITE("members:write"),

    LIBRARIAN_READ("librarian:read"),
    LIBRARIAN_WRITE("librarian:write"),

    RACK_READ("rack:read"),
    RACK_WRITE("rack:write"),

    BOOKSUGGESTION_READ("booksuggestion:read"),
    BOOKSUGGESTION_WRITE("booksuggestion : write");

    private final String permission;

}
