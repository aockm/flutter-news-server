package com.tockm.controller;

import com.tockm.entity.po.*;
import com.tockm.entity.query.CategoryInfoQuery;
import com.tockm.entity.query.NewsInfoQuery;
import com.tockm.entity.query.SimplePage;
import com.tockm.entity.vo.PaginationResultVo;
import com.tockm.entity.vo.ResponseVo;
import com.tockm.enums.PageSize;
import com.tockm.service.CategoryInfoService;
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

    @RequestMapping("/categories")
    public ResponseVo getCategories(CategoryInfoQuery query){
        CategoryEntity categoryEntity1 = new CategoryEntity("Latest","Latest");
        CategoryEntity categoryEntity2 = new CategoryEntity("Word","Word");
        CategoryEntity categoryEntity3 = new CategoryEntity("Business","Business");

        List<CategoryEntity> categoryEntities = new ArrayList();
        categoryEntities.add(new CategoryEntity("国内","国内"));
        categoryEntities.add(categoryEntity1);
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
//        NewsInfo newsInfo = new NewsInfo("101","102","Life","https://p2.img.cctvpic.com/photoworkspace/contentimg/2025/05/30/2025053015425334310.png","央视",new DateTime("2025-05-30 10:10:10"),"https://k.sinaimg.cn/n/front20250530ac/400/w720h480/20250530/fda6-69b77430f51cae2686f8cc324aa96ed0.jpg/w700d1q75cms.jpg?by=cms_fixed_width");
//        NewsInfo newsInfo2 = new NewsInfo("101","102","Sport","https://p2.img.cctvpic.com/photoworkspace/contentimg/2025/05/30/2025053015425334310.png","央视",new DateTime("2025-03-30 10:10:10"),"https://k.sinaimg.cn/n/front20250530ac/400/w720h480/20250530/fda6-69b77430f51cae2686f8cc324aa96ed0.jpg/w700d1q75cms.jpg?by=cms_fixed_width");
//        NewsInfo newsInfo3 = new NewsInfo("101","日本水产品请求入华，中方回应","Latest","https://p2.img.cctvpic.com/photoworkspace/contentimg/2025/05/30/2025053015425334310.png","937江苏新闻广播",new DateTime("2025-05-20 10:10:10"),"https://k.sinaimg.cn/n/front20250530ac/400/w720h480/20250530/fda6-69b77430f51cae2686f8cc324aa96ed0.jpg/w700d1q75cms.jpg?by=cms_fixed_width");
//        List<NewsInfo> newsInfos = new ArrayList<>();
//        newsInfos.add(newsInfo);
//        newsInfos.add(newsInfo2);
//        newsInfos.add(newsInfo3);
//        PaginationResultVo<UserInfo> result = new PaginationResultVo(3,15,1,1,newsInfos);

        return getSuccessResponseVo(newsInfoService.findListByPage(query));
    }

    @RequestMapping("/recommend")
    public ResponseVo getRecommend(String category){
       //        NewsInfo newsInfo = new NewsInfo("101","日本水产品请求入华，中方回应","Latest","https://p2.img.cctvpic.com/photoworkspace/contentimg/2025/05/30/2025053015425334310.png","937江苏新闻广播",new DateTime("2025-05-30 10:10:10"),"https://p2.img.cctvpic.com/photoworkspace/contentimg/2025/05/30/2025053015425334310.pngl");
//        query.setCategory("Latest");
//        query.setRecommend(1);
        return getSuccessResponseVo(newsInfoService.getNewsInfoRecommend(category));
    }


    @RequestMapping("/channels")
    public ResponseVo getChannels(){

        List<ChannelEntity> channelEntities = new ArrayList<>();
        channelEntities.add(new ChannelEntity("rt","rt"));
        channelEntities.add(new ChannelEntity("bbc","bbc"));
        channelEntities.add(new ChannelEntity("nbc","nbc"));
        channelEntities.add(new ChannelEntity("bloomberg","bloomberg"));
        channelEntities.add(new ChannelEntity("cnn","cnn"));
        channelEntities.add(new ChannelEntity("fox","fox"));
        PaginationResultVo<UserInfo> result = new PaginationResultVo(3,15,1,1,channelEntities);
        return getSuccessResponseVo(result);
    }
    @RequestMapping("/tags")
    public ResponseVo getTags(){
        return getSuccessResponseVo("tags");
    }
}
