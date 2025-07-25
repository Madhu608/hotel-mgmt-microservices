package com.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.modal.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/api/ratings/user/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable("userId") String userId);
}

