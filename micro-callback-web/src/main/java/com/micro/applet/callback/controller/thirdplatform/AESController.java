package com.micro.applet.callback.controller.thirdplatform;

import com.micro.applet.callback.common.aes.AESParameters;
import com.micro.applet.callback.common.aes.impl.AesException;
import com.micro.applet.callback.common.aes.impl.WXBizMsgCrypt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * AES 高级加密标准（英语：Advanced Encryption Standard，缩写：AES）
 *
 * @author liuhui
 * @version 1.0, 2021/3/19 16:10
 */
@Api(value = "/api/callback/aes")
@RequestMapping("/api/callback/aes")
@RestController
public class AESController {

    private static  final Logger logger = LoggerFactory.getLogger(AESController.class);

    @RequestMapping(value = "/encryption",method = RequestMethod.POST)
    @ApiOperation(value = "AES消息加密",response = String.class)
    public String wxEncryption(@ApiParam(required = true,name = "aesParas")AESParameters aesParameters) throws Exception {
        String replyMsg = " 中文<xml><ToUserName><![CDATA[oia2TjjewbmiOUlr6X-1crbLOvLw]]></ToUserName><FromUserName><![CDATA[gh_7f083739789a]]></FromUserName><CreateTime>1407743423</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[eYJ1MbwPRJtOvIEabaxHs7TX2D-HV71s79GUxqdUkjm6Gs2Ed1KF3ulAOA9H1xG0]]></MediaId><Title><![CDATA[testCallBackReplyVideo]]></Title><Description><![CDATA[testCallBackReplyVideo]]></Description></Video></xml>";
        WXBizMsgCrypt pc = new WXBizMsgCrypt(aesParameters.getToken(), aesParameters.getEncodingAesKey(), aesParameters.getAppId());
        String mingwen = pc.encryptMsg(replyMsg, aesParameters.getTimestamp(), aesParameters.getNonce());
        logger.info("加密后: " + mingwen);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        StringReader sr = new StringReader(mingwen);
        InputSource is = new InputSource(sr);
        Document document = db.parse(is);

        Element root = document.getDocumentElement();
        NodeList nodelist1 = root.getElementsByTagName("Encrypt");
        NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

        String encrypt = nodelist1.item(0).getTextContent();
        String msgSignature = nodelist2.item(0).getTextContent();

        String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
        String fromXML = String.format(format, encrypt);

        //
        // 公众平台发送消息给第三方，第三方处理
        //

        // 第三方收到公众号平台发送的消息
        String result2 = pc.decryptMsg(msgSignature, aesParameters.getTimestamp(), aesParameters.getNonce(), fromXML);
        logger.info("解密后明文: " + result2);

        //pc.verifyUrl(null, null, null, null);

        return "";
    }
}
