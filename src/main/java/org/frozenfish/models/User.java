package org.frozenfish.models;

import org.frozenfish.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.Collection;
import java.util.Set;

@Entity
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String cardNumber;

    @NotBlank(message = "Заполните поле Имя")
    private String firstName;

    @NotBlank(message = "Заполните поле Фамилия")
    private String secondName;
    private String middleName;

    @NotBlank(message = "Заполните поле Номер телефона")
    private String phoneNumber;

    @NotBlank(message = "Заполните поле Адрес")
    private String address;
    private String omsNumber;

    @NotBlank(message = "Заполните поле Логин")
    private String username;

    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
    @Email
    private String email;
    private String bDay;
    private boolean active;


    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User() {
    }

    public User(String cardNumber, String firstName, String secondName, String middleName, String phoneNumber,
                String address, String omsNumber, String username, String password, String email, String bDay, boolean active) {
        this.cardNumber = cardNumber;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.omsNumber = omsNumber;
        this.username = username;
        this.password = password;
        this.email = email;
        this.bDay = bDay;
        this.active = active;


    }

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }
    public boolean isDoctor(){
        return roles.contains(Role.DOCTOR);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOmsNumber() {
        return omsNumber;
    }

    public void setOmsNumber(String omsNumber) {
        this.omsNumber = omsNumber;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles()   ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
