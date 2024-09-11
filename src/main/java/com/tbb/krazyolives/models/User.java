package com.tbb.krazyolives.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;



@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name ="users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull
    @Column(name = "first_name")
    String firstName;
    @NonNull
    @Column(name = "last_name")
    String lastName;

    @NonNull
    @Column(name = "email")
    String email;

    @NonNull
    @Column(name = "password")
    String password;

    public User(long id, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations = new LinkedHashSet<>();



    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "menu_id")
    private Menu menu;


    //Helper Method

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
        reservation.setUser(this);
    }


}
