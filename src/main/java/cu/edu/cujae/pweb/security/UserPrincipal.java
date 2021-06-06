package cu.edu.cujae.pweb.security;


import cu.edu.cujae.pweb.dto.RoleDto;
import cu.edu.cujae.pweb.dto.UserAuthenticatedDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class UserPrincipal implements UserDetails {
    private Long codUser;
    private String username;
    private String password;
    private boolean active;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long codUser, String username, String password, boolean active, Collection<? extends GrantedAuthority> authorities) {
        this.codUser = codUser;
        this.username = username;
        this.password = password;
        this.active = active;
        this.authorities = authorities;
    }

    public static UserPrincipal create(UserAuthenticatedDto user) {
        List<GrantedAuthority> authorities;
        try {
            RoleDto role =new RoleDto( 1,user.getRol());
            authorities = AuthorityUtils.createAuthorityList(role.getNameRole());
        } catch (Exception e) {
            authorities = Collections.
                    singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        }
        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                true,
                authorities
        );
    }

    public static UserPrincipal create(UserAuthenticatedDto user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        return userPrincipal;
    }

    public Long getCodUser() {
        return codUser;
    }

    public void setCodUser(Long codUser) {
        this.codUser = codUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }



    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
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
        return active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

}