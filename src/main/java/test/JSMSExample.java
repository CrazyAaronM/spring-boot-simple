//package test;
//
//import cn.jiguang.common.resp.APIConnectionException;
//import cn.jiguang.common.resp.APIRequestException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * @author aaron.hu
// * @version 1.0.0
// * @ClassName JSMSExample.java
// * @Description TODO
// * @createTime 2021年06月15日 15:31:00
// */
//public class JSMSExample {
//    protected static final Logger LOG = LoggerFactory.getLogger(JSMSExample.class);
//
//    private static final String appkey = "09198ca47f1cc830aa3e064c";
//    private static final String masterSecret = "4258ba884dbbceefe3cdb737";
//
//    private static final String devKey = "242780bfdd7315dc1989fedb";
//    private static final String devSecret = "2f5ced2bef64167950e63d13";
//
//    public static void main(String[] args) {
////    	testSendSMSCode();
////    	testCreateSign();pass
////        testUpdateSign();no pass
////        testCheckSign();pass
//        testUpdateSign();
////        testSendVoiceSMSCode();
////        testSendTemplateSMS();
//    }
//
//    public static void testSendSMSCode() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        SMSPayload payload = SMSPayload.newBuilder()
//                .setMobileNumber("13800138000")
//                .setTempId(1)
//                .build();
//        try {
//            SendSMSResult res = client.sendSMSCode(payload);
//            System.out.println(res.toString());
//            LOG.info(res.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testSendSMSWithIHttpClient() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        String authCode = ServiceHelper.getBasicAuthorization(appkey, masterSecret);
//        ApacheHttpClient httpClient = new ApacheHttpClient(authCode, null, ClientConfig.getInstance());
//        // NettyHttpClient httpClient = new NettyHttpClient(authCode, null, ClientConfig.getInstance());
//        // ApacheHttpClient httpClient = new ApacheHttpClient(authCode, null, ClientConfig.getInstance());
//        // 可以切换 HttpClient，默认使用的是 NativeHttpClient
//        client.setHttpClient(httpClient);
//        // 如果使用 NettyHttpClient，发送完请求后要调用 close 方法
//        // client.close();
//        SMSPayload payload = SMSPayload.newBuilder()
//                .setMobileNumber("13800138000")
//                .setTempId(1)
//                .build();
//        try {
//            SendSMSResult res = client.sendSMSCode(payload);
//            System.out.println(res.toString());
//            LOG.info(res.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testSendValidSMSCode() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        try {
//            ValidSMSResult res = client.sendValidSMSCode("01658697-45d9-4644-996d-69a1b14e2bb8", "556618");
//            System.out.println(res.toString());
//            LOG.info(res.toString());
//        } catch (APIConnectionException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            e.printStackTrace();
//            if (e.getErrorCode() == 50010) {
//                // do something
//            }
//            System.out.println(e.getStatus() + " errorCode: " + e.getErrorCode() + " " + e.getErrorMessage());
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    /**
//     *  The default value of ttl is 60 seconds.
//     */
//    public static void testSendVoiceSMSCode() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        SMSPayload payload = SMSPayload.newBuilder()
//                .setMobileNumber("13800138000")
//                .setTTL(90)
//                .build();
//        try {
//            SendSMSResult res = client.sendVoiceSMSCode(payload);
//            LOG.info(res.toString());
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        }
//    }
//
//    public static void testSendTemplateSMS() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        SMSPayload payload = SMSPayload.newBuilder()
//                .setMobileNumber("13800138000")
//                .setTempId(1)
//                .addTempPara("test", "jpush")
//                .build();
//        try {
//            SendSMSResult res = client.sendTemplateSMS(payload);
//            LOG.info(res.toString());
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        }
//    }
//
//    public static void testSendBatchTemplateSMS() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        List<RecipientPayload> list = new ArrayList<RecipientPayload>();
//        RecipientPayload recipientPayload1 = new RecipientPayload.Builder()
//                .setMobile("13800138000")
//                .addTempPara("code", "638938")
//                .build();
//        RecipientPayload recipientPayload2 = new RecipientPayload.Builder()
//                .setMobile("13800138000")
//                .addTempPara("code", "829302")
//                .build();
//        list.add(recipientPayload1);
//        list.add(recipientPayload2);
//        RecipientPayload[] recipientPayloads = new RecipientPayload[list.size()];
//        BatchSMSPayload smsPayload = BatchSMSPayload.newBuilder()
//                .setTempId(1)
//                .setRecipients(list.toArray(recipientPayloads))
//                .build();
//        try {
//            BatchSMSResult result = client.sendBatchTemplateSMS(smsPayload);
//            LOG.info("Got result: " + result);
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testSendScheduleSMS() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        ScheduleSMSPayload payload = ScheduleSMSPayload.newBuilder()
//                .setMobileNumber("13800138000")
//                .setTempId(1111)
//                .setSendTime("2017-07-31 16:17:00")
//                .addTempPara("number", "798560")
//                .build();
//        try {
//            ScheduleResult result = client.sendScheduleSMS(payload);
//            LOG.info(result.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testUpdateScheduleSMS() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        ScheduleSMSPayload payload = ScheduleSMSPayload.newBuilder()
//                .setMobileNumber("13800138000")
//                .setTempId(1111)
//                .setSendTime("2017-07-31 15:00:00")
//                .addTempPara("number", "110110")
//                .build();
//        try {
//            ScheduleResult result = client.updateScheduleSMS(payload, "dsfd");
//            LOG.info(result.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testSendBatchScheduleSMS() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        List<RecipientPayload> list = new ArrayList<RecipientPayload>();
//        RecipientPayload recipientPayload1 = new RecipientPayload.Builder()
//                .setMobile("13800138000")
//                .addTempPara("number", "638938")
//                .build();
//        RecipientPayload recipientPayload2 = new RecipientPayload.Builder()
//                .setMobile("13800138001")
//                .addTempPara("number", "829302")
//                .build();
//        list.add(recipientPayload1);
//        list.add(recipientPayload2);
//        RecipientPayload[] recipientPayloads = new RecipientPayload[list.size()];
//        ScheduleSMSPayload smsPayload = ScheduleSMSPayload.newBuilder()
//                .setSendTime("2017-07-31 16:00:00")
//                .setTempId(1245)
//                .setRecipients(list.toArray(recipientPayloads))
//                .build();
//        try {
//            BatchSMSResult result = client.sendBatchScheduleSMS(smsPayload);
//            LOG.info(result.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testUpdateBatchScheduleSMS() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        List<RecipientPayload> list = new ArrayList<RecipientPayload>();
//        RecipientPayload recipientPayload1 = new RecipientPayload.Builder()
//                .setMobile("13800138000")
//                .addTempPara("number", "328393")
//                .build();
//        RecipientPayload recipientPayload2 = new RecipientPayload.Builder()
//                .setMobile("13800138001")
//                .addTempPara("number", "489042")
//                .build();
//        list.add(recipientPayload1);
//        list.add(recipientPayload2);
//        RecipientPayload[] recipientPayloads = new RecipientPayload[list.size()];
//        ScheduleSMSPayload smsPayload = ScheduleSMSPayload.newBuilder()
//                .setSendTime("2017-07-31 16:00:00")
//                .setTempId(1245)
//                .setRecipients(list.toArray(recipientPayloads))
//                .build();
//        try {
//            BatchSMSResult result = client.updateBatchScheduleSMS(smsPayload, "dfs");
//            LOG.info(result.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testDeleteScheduleSMS() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        try {
//            ResponseWrapper result = client.deleteScheduleSMS("sd");
//            LOG.info("Response content: " + result.responseContent + " response code: " + result.responseCode);
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testGetAccountSMSBalance() {
//        SMSClient client = new SMSClient(devSecret, devKey);
//        try {
//            AccountBalanceResult result = client.getSMSBalance();
//            LOG.info(result.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testGetAppSMSBalance() {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        try {
//            AppBalanceResult result = client.getAppSMSBalance();
//            LOG.info(result.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//
//    public void testCreateTemplate() {
//        try {
//            SMSClient client = new SMSClient(masterSecret, appkey);
//            TemplatePayload payload = TemplatePayload.newBuilder()
//                    .setTemplate("您好，您的验证码是{{code}}，2分钟内有效！")
//                    .setType(1)
//                    .setTTL(120)
//                    .setRemark("验证短信")
//                    .build();
//            SendTempSMSResult result = client.createTemplate(payload);
//            LOG.info(result.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    // 只有审核不通过状态的模板才允许修改
//    public void testUpdateTemplate() {
//        try {
//            SMSClient client = new SMSClient(masterSecret, appkey);
//            TemplatePayload payload = TemplatePayload.newBuilder()
//                    .setTempId(12345)
//                    .setTemplate("您好，您的验证码是{{code}}，2分钟内有效！")
//                    .setType(1)
//                    .setTTL(120)
//                    .setRemark("验证短信")
//                    .build();
//            SendTempSMSResult result = client.updateTemplate(payload, 12345);
//            LOG.info(result.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public void testCheckTemplate() {
//        try {
//            SMSClient client = new SMSClient(masterSecret, appkey);
//            TempSMSResult result = client.checkTemplate(144923);
//            LOG.info(result.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public void testDeleteTemplate() {
//        try {
//            SMSClient client = new SMSClient(masterSecret, appkey);
//            ResponseWrapper result = client.deleteTemplate(144923);
//            LOG.info(result.toString());
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testCreateSign(){
//        try {
//            File avatar_file = new File("C:\\Users\\jiguang\\Desktop\\sign.jpg");
//            File[] files = new File[1];
//            files[0] = avatar_file;
//            SMSClient client = new SMSClient(masterSecret, appkey);
//            SignPayload payload = SignPayload.newBuilder().
//                    sign("SDK6").
//                    type(1).
//                    remark("SDK测试").
//                    images(files).
//                    build();
//            SignResult result = client.createSign(payload);
//            LOG.info(result.toString());
//        }catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testUpdateSign(){
//        try {
//            File avatar_file = new File("C:\\Users\\jiguang\\Desktop\\testSign.jpg");
//            File[] files = new File[1];
//            files[0] = avatar_file;
//            SMSClient client = new SMSClient(masterSecret, appkey);
//            SignPayload payload = SignPayload.newBuilder().
//                    sign("SDK6").
//                    type(1).
//                    remark("SDK测试").
//                    images(files).
//                    build();
//            SignResult result = client.updateSign(payload,10859);
//            LOG.info(result.toString());
//        }catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testCheckSign(){
//        try {
//            SMSClient client = new SMSClient(masterSecret, appkey);
//            SignInfoResult result = client.checkSign(10859);
//            LOG.info(result.toString());
//        }catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//    public static void testDeleteSign(){
//        try {
//            SMSClient client = new SMSClient(masterSecret, appkey);
//            ResponseWrapper result = client.deleteSign(10859);
//            LOG.info(result.toString());
//        }catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Message: " + e.getMessage());
//        }
//    }
//
//}
