package com.micro.applet.qywechat.service;

import com.alibaba.fastjson.JSON;
import com.micro.applet.qywechat.common.constants.QYWECHATAPI;
import com.micro.applet.qywechat.request.news.NewsInfo;
import com.micro.applet.qywechat.response.AccessToken;
import com.micro.applet.qywechat.response.NewPushResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

/**
 * TODO 添加类的描述
 *
 * @author liuhui
 * @version 1.0, 2021/2/18 16:16
 */
@Service
public class NewsPushService {

    private static  final Logger logger = LoggerFactory.getLogger(NewsPushService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommonService commonService;

    public NewPushResp pushNews(String agentid) {

        AccessToken ac = commonService.getToken("ww619bb7a5b89a85d8", "87LteJZZ5BNYeWN-HSdSv9YFsBcPkz1XbB5cSGLxV7g");
        String url = MessageFormat.format(QYWECHATAPI.API_NES_PUSH, ac.getAccess_token());
        NewsInfo news = new NewsInfo();
        news.setTouser("@all");
        news.setAgentid(1000002);
        NewsInfo.News.Article article = new NewsInfo.News.Article("title-测试", "desc-测试", "https://mmbiz.qpic.cn/mmbiz_png/jZ6m2JFpoUMdwEI1QN7SLKpJia7tQTJDBBgAE7xUMCdwM7BxplHibImcictbW5ZbGpMHhIicQ3FbWpkiagvaMVSxgrQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1", "https://www.baidu.com/img/dong_8f1d47bcb77d74a1e029d8cbb3b33854.gif");
        news.getNews().getArticles().add(article);
        logger.info(JSON.toJSONString(news));
        return  restTemplate.postForObject(url,news,NewPushResp.class);
    }
}
