package com.micro.applet.qywechat.request.news;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文消息
 *
 * @author liuhui
 * @version 1.0, 2021/2/18 15:58
 */
public class NewsInfo extends BaseReq{


    private final String msgtype="news";
    
    /**
     * 图文消息，一个图文消息支持1到8条图文
     **/
    private News news = new News();

    /**
     * 表示是否开启id转译，0表示否，1表示是，默认0
     **/
    private int enable_id_trans=0;

    public static class News{
        private List<Article> articles = new ArrayList<>();

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }

        /**
         * 图文消息
         **/
        public static   class Article{
            /**
             * 标题，不超过128个字节，超过会自动截断（支持id转译）
             **/
            private String title;

            /**
             * 描述，不超过512个字节，超过会自动截断（支持id转译）
             **/
            private String description;

            /**
             * 点击后跳转的链接。 最长2048字节，请确保包含了协议头(http/https)
             **/
            private String url;

            /**
             * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150。
             **/
            private String picurl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getPicurl() {
                return picurl;
            }

            public void setPicurl(String picurl) {
                this.picurl = picurl;
            }

            public Article(String title, String description, String url, String picurl) {
                this.title = title;
                this.description = description;
                this.url = url;
                this.picurl = picurl;
            }
        }
    }


    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getMsgtype() {
        return msgtype;
    }


    public int getEnable_id_trans() {
        return enable_id_trans;
    }

    public void setEnable_id_trans(int enable_id_trans) {
        this.enable_id_trans = enable_id_trans;
    }
}
