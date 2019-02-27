package com.pm.service;


import com.pm.entity.MyNews;
import com.pm.entity.MyNotice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


/**
 * Created by Dell on 2017/8/24.
 */
public interface NewsService {

   List<MyNews> selectNews();
   List<MyNotice> selectNotice();


   MyNews selectNewsById(Long id);
   MyNotice selectNoticeById(Long id);


   int saveCompanyNewsDetail(Long id, String newTitle, String newSource, String newAuthor, String newHtml);
   int saveCompanyNoticeDetail(Long id, String noticeTitle, String noticeSource, String noticeAuthor, String noticeHtml);

   int saveNewRecord(Long id, Integer newRecord);
   int saveNoticeRecord(Long id, Integer noticeRecord);


   int addCompanyNewsDetail(String newTitle, String newSource, String newAuthor, Date newTime, Integer newRecord, String newHtml);
   int addCompanyNoticeDetail(String newTitle, String newSource, String newAuthor, Date newTime, Integer newRecord, String newHtml);


   void deleteNews(Long id);
   void deleteNotice(Long id);

   //查询上一条，下一条方法
   MyNews getAfterBlog(Long blogId);
   MyNews getPreBlog(Long blogId);
   MyNotice getAfterBlogNotice(Long blogId);
   MyNotice getPreBlogNotice(Long blogId);



}
