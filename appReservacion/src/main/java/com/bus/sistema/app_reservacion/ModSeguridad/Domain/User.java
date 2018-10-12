package com.bus.sistema.app_reservacion.ModSeguridad.Domain;


import java.util.HashSet;
import java.util.Set;

//import org.springframework.security.core.GrantedAuthority;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="user")
public class User {
    @Id
    @Column(name = "username", unique = true,nullable = false,length = 45)
    private String username;
    @Column(name = "password",nullable = false,length = 60)
    private String pass;

    @Column(name = "enabled",nullable = false)
    private boolean enabled;

    @OneToMany(fetch =  FetchType.EAGER, mappedBy = "user")
    private Set<UserRole> userRole = new HashSet<UserRole>();

    public User(){

    }

    public User(String username, String pass, boolean enabled) {
        this.username = username;
        this.pass = pass;
        this.enabled = enabled;
    }

    public User(String username, String pass, boolean enabled, Set<UserRole> userRole) {
        this.username = username;
        this.pass = pass;
        this.enabled = enabled;
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}
