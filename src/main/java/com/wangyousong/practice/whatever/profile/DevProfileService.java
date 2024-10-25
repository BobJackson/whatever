package com.wangyousong.practice.whatever.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevProfileService implements ProfileService {
    @Override
    public String getProfileName() {
        return "dev";
    }
}
