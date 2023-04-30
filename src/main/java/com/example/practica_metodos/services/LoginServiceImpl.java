package com.example.practica_metodos.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Named("loginServiceImpl")
public class LoginServiceImpl implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies() != null ? req.getCookies(): new
                Cookie[0];
        return Arrays.stream(cookies)
                .filter(c -> "username".equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }
}
