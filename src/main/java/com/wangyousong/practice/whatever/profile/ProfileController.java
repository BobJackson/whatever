package com.wangyousong.practice.whatever.profile;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Resource
    private ProfileService profileService;

    @GetMapping("/hello-world")
    public String hello() {
        return "hello world from " + profileService.getProfileName();
    }
}
