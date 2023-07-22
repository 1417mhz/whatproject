package myproject.whatproject.service;

import lombok.RequiredArgsConstructor;
import myproject.whatproject.domain.user.User;
import myproject.whatproject.mapper.MyMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserLoginService implements UserDetailsService {

    private final MyMapper myMapper;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = myMapper.findUserById(userId);
        if (user != null) {
            return new UserDetails() { // UserPrincipal
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    Collection<GrantedAuthority> roleList = new ArrayList<>();
                    roleList.add(new SimpleGrantedAuthority(user.getRole()));
                    return roleList;
                }

                @Override
                public String getPassword() {
                    return user.getPw();
                }

                @Override
                public String getUsername() {
                    return user.getId();
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
                    return user.getState().equals("활성");
                }
            };
        } else { return null; }
    }
}
