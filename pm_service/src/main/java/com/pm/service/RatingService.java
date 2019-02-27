package com.pm.service;

import com.pm.entity.Rating;

import java.util.Date;
import java.util.List;

public interface RatingService {
    /**
     * @param userid
     * @param pictureid
     * @param rating
     * @return
     */
    int rating(Long userid, Long pictureid, Byte rating);

    /**
     *
     * @param userid
     * @param pictureid
     * @return
     */
    Rating showRatingById(Long userid,Long pictureid);
}

