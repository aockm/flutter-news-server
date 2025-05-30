package com.tockm.controller;

import cn.hutool.core.date.DateTime;
import com.tockm.entity.po.*;
import com.tockm.entity.query.CategoryInfoQuery;
import com.tockm.entity.query.SimplePage;
import com.tockm.entity.vo.PaginationResultVo;
import com.tockm.entity.vo.ResponseVo;
import com.tockm.enums.PageSize;
import com.tockm.service.CategoryInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController extends ABaseController {

    @Resource
    private CategoryInfoService categoryInfoService;

    @RequestMapping("/categories")
    public ResponseVo getCategories(CategoryInfoQuery query){
        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCode("101");
        categoryEntity1.setTitle("分类1");
        CategoryEntity categoryEntity2 = new CategoryEntity();
        categoryEntity2.setCode("102");
        categoryEntity2.setTitle("分类2");
        CategoryEntity categoryEntity3 = new CategoryEntity();
        categoryEntity3.setCode("103");
        categoryEntity3.setTitle("分类3");
        List<CategoryEntity> categoryEntities = new ArrayList<CategoryEntity>();
        categoryEntities.add(categoryEntity1);
        categoryEntities.add(categoryEntity2);
        categoryEntities.add(categoryEntity3);

        int pageSize = query.getPageSize()==null? PageSize.SIZE15.getSize():query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), 3, pageSize);
        PaginationResultVo<UserInfo> result = new PaginationResultVo(3,page.getPageSize(),page.getPageNo(),page.getTotalPage(),categoryEntities);
        return getSuccessResponseVo(result);
    }

    @RequestMapping("/news")
    public ResponseVo loadDataList(){
        NewsInfo newsInfo = new NewsInfo("101","102","103","略图","央视",new DateTime(),"http://slide.news.sina.com.cn/slide_1_2841_608689.html");
        NewsInfo newsInfo2 = new NewsInfo("101","102","103","略图","央视",new DateTime(),"http://slide.news.sina.com.cn/slide_1_2841_608689.html");
        NewsInfo newsInfo3 = new NewsInfo("101","102","103","略图","央视",new DateTime(),"http://slide.news.sina.com.cn/slide_1_2841_608689.html");
        List<NewsInfo> newsInfos = new ArrayList<>();
        newsInfos.add(newsInfo);
        newsInfos.add(newsInfo2);
        newsInfos.add(newsInfo3);
        PaginationResultVo<UserInfo> result = new PaginationResultVo(3,15,1,1,newsInfos);

        return getSuccessResponseVo(result);
    }

    @RequestMapping("/recommend")
    public ResponseVo getRecommend(){
        NewsInfo newsInfo = new NewsInfo("101","102","103","略图","央视",new DateTime(),"http://slide.news.sina.com.cn/slide_1_2841_608689.html");

        return getSuccessResponseVo(newsInfo);
    }


    @RequestMapping("/channels")
    public ResponseVo getChannels(){
        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setCode("101");
        channelEntity.setTitle("新闻");
        ChannelEntity channelEntity2 = new ChannelEntity();
        channelEntity2.setCode("102");
        channelEntity2.setTitle("简讯");
        ChannelEntity channelEntity3 = new ChannelEntity();
        channelEntity3.setCode("103");
        channelEntity3.setTitle("热点");
        List<ChannelEntity> channelEntities = new ArrayList<>();
        channelEntities.add(channelEntity);
        channelEntities.add(channelEntity2);
        channelEntities.add(channelEntity3);
        PaginationResultVo<UserInfo> result = new PaginationResultVo(3,15,1,1,channelEntities);
        return getSuccessResponseVo(result);
    }
    @RequestMapping("/tags")
    public ResponseVo getTags(){
        return getSuccessResponseVo("tags");
    }
}
