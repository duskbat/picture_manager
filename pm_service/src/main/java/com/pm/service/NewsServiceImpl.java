package com.pm.service;


import com.pm.dao.MyNewsMapper;
import com.pm.dao.MyNoticeMapper;
import com.pm.entity.MyNews;
import com.pm.entity.MyNewsExample;
import com.pm.entity.MyNotice;
import com.pm.entity.MyNoticeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 2017/8/24.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    MyNewsMapper myNewsMapper;

    @Autowired
    MyNoticeMapper myNoticeMapper;

    @Override
    public List<MyNews> selectNews() {
        return myNewsMapper.selectByExampleWithBLOBs(new MyNewsExample());
    }

    @Override
    public List<MyNotice> selectNotice() {
        return myNoticeMapper.selectByExampleWithBLOBs(new MyNoticeExample());
    }

    @Override
    public MyNews selectNewsById(Long id) {
        return myNewsMapper.selectByPrimaryKey(id);
    }

    @Override
    public MyNotice selectNoticeById(Long id) {
        return myNoticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveCompanyNewsDetail(Long id, String newTitle, String newSource, String newAuthor, String newHtml) {
        return myNewsMapper.updateByPrimaryKeySelective(new MyNews(id, newTitle, newSource, newAuthor,newHtml));
    }

    @Override
    public int saveCompanyNoticeDetail(Long id, String noticeTitle, String noticeSource, String noticeAuthor, String noticeHtml) {
        return myNoticeMapper.updateByPrimaryKeySelective(new MyNotice(id, noticeTitle, noticeSource, noticeAuthor,noticeHtml));
    }

    @Override
    public int saveNewRecord(Long id, Integer newRecord) {
        return myNewsMapper.updateByPrimaryKeySelective(new MyNews(id,newRecord));
    }

    @Override
    public int saveNoticeRecord(Long id, Integer noticeRecord) {
        return myNoticeMapper.updateByPrimaryKeySelective(new MyNotice(id,noticeRecord));
    }


    @Override
    public int addCompanyNewsDetail(String newTitle, String newSource, String newAuthor, Date newTime, Integer newRecord, String newHtml) {
        return myNewsMapper.insertSelective(new MyNews(newTitle,newSource,newAuthor, newTime, newRecord,newHtml));
    }

    @Override
    public int addCompanyNoticeDetail(String newTitle, String newSource, String newAuthor, Date newTime, Integer newRecord, String newHtml) {
        return myNoticeMapper.insertSelective(new MyNotice(newTitle, newSource, newAuthor,newTime, newRecord,newHtml));
    }


    @Override
    public void deleteNews(Long id) {
        myNewsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteNotice(Long id) {
        myNoticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public MyNews getAfterBlog(Long blogId) {
        MyNewsExample blogExample = new MyNewsExample();
        MyNewsExample.Criteria criteria = blogExample.createCriteria();
        criteria.andIdGreaterThan(blogId);
        MyNews blog = new MyNews();

        if(myNewsMapper.selectByExampleWithBLOBs(blogExample).size() > 0 ){
           blog = myNewsMapper.selectByExampleWithBLOBs(blogExample).get(0);

        }else{
            blog.setNewTitle("这是最后一篇文章");
            blog.setId(blogId);
        }
        return blog;
    }

    @Override
    public MyNews getPreBlog(Long blogId) {
        MyNewsExample blogExample = new MyNewsExample();
        MyNewsExample.Criteria criteria = blogExample.createCriteria();
        criteria.andIdLessThan(blogId);
        MyNews blog = new MyNews();
        if(myNewsMapper.selectByExampleWithBLOBs(blogExample).size() > 0 ){
            blog = myNewsMapper.selectByExampleWithBLOBs(blogExample).get(0);
        }else{
            blog.setNewTitle("这是第一篇文章");
            blog.setId(blogId);
        }
        return blog;
    }

    @Override
    public MyNotice getAfterBlogNotice(Long blogId) {
        MyNoticeExample blogExample = new MyNoticeExample();
        MyNoticeExample.Criteria criteria = blogExample.createCriteria();
        criteria.andIdGreaterThan(blogId);
        MyNotice blog = new MyNotice();

        if(myNoticeMapper.selectByExampleWithBLOBs(blogExample).size() > 0 ){
            blog = myNoticeMapper.selectByExampleWithBLOBs(blogExample).get(0);

        }else{
            blog.setNewTitle("这是最后一篇文章");
            blog.setId(blogId);
        }
        return blog;
    }

    @Override
    public MyNotice getPreBlogNotice(Long blogId) {
        MyNoticeExample blogExample = new MyNoticeExample();
        MyNoticeExample.Criteria criteria = blogExample.createCriteria();
        criteria.andIdLessThan(blogId);
        MyNotice blog = new MyNotice();
        if(myNoticeMapper.selectByExampleWithBLOBs(blogExample).size() > 0 ){
            blog = myNoticeMapper.selectByExampleWithBLOBs(blogExample).get(0);
        }else{
            blog.setNewTitle("这是第一篇文章");
            blog.setId(blogId);
        }
        return blog;
    }


}
