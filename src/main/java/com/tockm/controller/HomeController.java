package com.tockm.controller;

import com.tockm.entity.po.*;
import com.tockm.entity.query.CategoryInfoQuery;
import com.tockm.entity.query.ChannelInfoQuery;
import com.tockm.entity.query.NewsInfoQuery;
import com.tockm.entity.query.SimplePage;
import com.tockm.entity.vo.PaginationResultVo;
import com.tockm.entity.vo.ResponseVo;
import com.tockm.enums.PageSize;
import com.tockm.service.CategoryInfoService;
import com.tockm.service.ChannelInfoService;
import com.tockm.service.NewsInfoService;
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

    @Resource
    private NewsInfoService newsInfoService;

    @Resource
    private ChannelInfoService channelInfoService;

    @RequestMapping("/categories")
    public ResponseVo getCategories(CategoryInfoQuery query){
        CategoryEntity categoryEntity1 = new CategoryEntity("Latest","Latest");
        CategoryEntity categoryEntity2 = new CategoryEntity("Word","Word");
        CategoryEntity categoryEntity3 = new CategoryEntity("Business","Business");

        List<CategoryEntity> categoryEntities = new ArrayList();
        categoryEntities.add(categoryEntity1);
        categoryEntities.add(new CategoryEntity("国内","国内"));
        categoryEntities.add(categoryEntity2);
        categoryEntities.add(categoryEntity3);
        categoryEntities.add(new CategoryEntity("Sport","Sport"));
        categoryEntities.add(new CategoryEntity("Life","Life"));


        int pageSize = query.getPageSize()==null? PageSize.SIZE15.getSize():query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), 3, pageSize);
        PaginationResultVo<UserInfo> result = new PaginationResultVo(3,page.getPageSize(),page.getPageNo(),page.getTotalPage(),categoryEntities);
        return getSuccessResponseVo(result);
    }

    @RequestMapping("/news")
    public ResponseVo loadDataList(NewsInfoQuery query){

        return getSuccessResponseVo(newsInfoService.findListByPage(query));
    }

    @RequestMapping("/recommend")
    public ResponseVo getRecommend(String category){
        return getSuccessResponseVo(newsInfoService.getNewsInfoRecommend(category));
    }


    @RequestMapping("/channels")
    public ResponseVo getChannels(ChannelInfoQuery query){

        List<ChannelEntity> channelEntities = new ArrayList<>();
        channelEntities.add(new ChannelEntity("rt","rt"));
        channelEntities.add(new ChannelEntity("bbc","bbc"));
        channelEntities.add(new ChannelEntity("nbc","nbc"));
        channelEntities.add(new ChannelEntity("bloomberg","bloomberg"));
        channelEntities.add(new ChannelEntity("cnn","cnn"));
        channelEntities.add(new ChannelEntity("fox","fox"));
        PaginationResultVo<UserInfo> result = new PaginationResultVo(3,15,1,1,channelEntities);

        return getSuccessResponseVo(channelInfoService.findListByPage(query));
    }
    @RequestMapping("/tags")
    public ResponseVo getTags(){
        return getSuccessResponseVo("tags");
    }
}
