package com.wangyousong.practice.whatever.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class LocalProfileService implements ProfileService {
    @Override
    public String getProfileName() {
        return "local";
    }
}
