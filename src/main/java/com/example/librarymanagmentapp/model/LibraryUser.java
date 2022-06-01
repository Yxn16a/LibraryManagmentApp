package com.example.librarymanagmentapp.model;

import com.example.librarymanagmentapp.security.Roles;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Library_user",uniqueConstraints ={
        @UniqueConstraint(name = "email",columnNames = "user_email" ),
        @UniqueConstraint(name = "phoneNumber",columnNames = "user_phone_number" )}
        )
public class LibraryUser extends BaseEntity {
    @Embedded

    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "User_first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "user_last_name")),
            @AttributeOverride(name = "email",column = @Column(name = "user_email", nullable = false)),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "user_phone_number")),
            @AttributeOverride(name = "password", column = @Column(name = "user_password")),
            @AttributeOverride(name = "picture", column = @Column(name = "user_picture"))
    })
    private Person person;
    //@Column(name = "visiting_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitingDate;
    @Embedded
        @AttributeOverrides({
            @AttributeOverride(name = "streetAddressOne", column = @Column(name = "User_street_address_one")),
            @AttributeOverride(name = "streetAddressTwo", column = @Column(name = "user_street_address_two")),
            @AttributeOverride(name = "city", column = @Column(name = "user_city")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "user_zipcode")),
            @AttributeOverride(name = "country", column = @Column(name = "user_country")),
            @AttributeOverride(name = "county", column = @Column(name = "user_county"))
    })
    private Address address;
    @OneToMany(mappedBy = "libraryUser", fetch = FetchType.EAGER)
    private Set<Belongings> belongings = new HashSet<>();
    @OneToMany(mappedBy = "libraryUser", fetch = FetchType.EAGER)
    private Set<FeedBack> feedBack;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // helps to see all the roles
    @JoinTable(name = "user_role",
            joinColumns ={@JoinColumn(name ="user_id")},
            inverseJoinColumns = {@JoinColumn(name ="role_id")})
    private Set<Roles> roles;
}

