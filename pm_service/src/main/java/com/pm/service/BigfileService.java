package com.pm.service;


import com.pm.entity.PictureUser;
import com.pm.entity.Plupload;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by Dell on 2017/8/24.
 */
public interface BigfileService {

    void uploadvideo(Plupload plupload, HttpServletRequest request, HttpServletResponse response);

    void uploadvideoRecord(HttpServletRequest request);


}
