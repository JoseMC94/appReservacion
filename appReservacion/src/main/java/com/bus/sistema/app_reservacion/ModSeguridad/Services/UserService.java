package com.bus.sistema.app_reservacion.ModSeguridad.Services;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.UserRole;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("userService")
public class UserService implements UserDetailsService {
    @Autowired
    @Qualifier("userRepository")
    private UserRepository UserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.bus.sistema.app_reservacion.ModSeguridad.Domain.User user = UserRepository.findByUsername(username);
        List<GrantedAuthority> autohorities = buildAuthorities(user.getUserRolesByUsuarioId());
        return buildUser(user,autohorities);
    }

    private User buildUser(com.bus.sistema.app_reservacion.ModSeguridad.Domain.User user, List<GrantedAuthority> autohorities){
        return new User(user.getUsername(),user.getPassword(),user.isActivo(),
                true,true,true,autohorities);
    }

    private  List<GrantedAuthority> buildAuthorities(Set<UserRole> userRole){
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for (UserRole userRoles : userRole){
            auths.add(new SimpleGrantedAuthority(userRoles.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);
    }
}