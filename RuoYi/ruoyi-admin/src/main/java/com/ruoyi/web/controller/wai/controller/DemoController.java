

package com.ruoyi.web.controller.wai.controller;

import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.IConsumeService;
import com.ruoyi.system.service.ITBalanceChangeService;
import com.ruoyi.system.service.ITConsumerMachineService;
import com.ruoyi.web.controller.Utils.DateString;
import com.ruoyi.web.controller.Utils.RSASignature;
import com.ruoyi.web.controller.wai.controller.utils.BaseResponse;
import com.ruoyi.web.controller.wai.controller.utils.Return;
import com.ruoyi.web.controller.wai.controller.utils.StatusCode;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/app")
public class DemoController {
    static String pubKey ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDkhXIY57TCsGLsod3Y76tKTi+HiYv7Od9ROSYphPUEgbbC5ghjGJCDTbwkkPFC2EQxgZjn+hDY1N73drQqoR6Y+yuwt/RlscWSP6CTbNeQTXqpw01TzPDez4GtREzEQSWdM16jqJVb3TJQuHBi9CCfZxReZB25LJ1t0DyNef1CpQIDAQAB";

   //static String priKey ="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOSFchjntMKwYuyh3djvq0pOL4eJi/s531E5JimE9QSBtsLmCGMYkINNvCSQ8ULYRDGBmOf6ENjU3vd2tCqhHpj7K7C39GWxxZI/oJNs15BNeqnDTVPM8N7Pga1ETMRBJZ0zXqOolVvdMlC4cGL0IJ9nFF5kHbksnW3QPI15/UKlAgMBAAECgYBP6pcfPJDLcTH3PRg/UHmfr74RcTnB7tg5KHo/FN8250IJ4LZYKXQIZzv/saydytH2WjMmFR6lJbSf6CRTsCrpfb3V1gFmOH7LYAcs/sY5hjuc1A7FAg/B3AIBkcU6/KsmNM1b+GjIXOj1vWuPPioARJMpTpsdprn6L98PlrZUFQJBAPzr/YZ8HPApcE7vLtHLOuZvjmE7AS0YGpspQvfCsoyuJ257Gev0ObJPCvt9hV0TSDHyRVC+7fH4YLSZ4HrR5ZsCQQDnTW6t/OOjNKKKLonyXvm0ajSp+dOjHGZ4alvNmNxTY31o5kE8hqzBGz+ASEX/OtdrPvZDGBBiBbciyuG+Mhy/AkEAnFNUiRoPXNWQCAnH+33Msv9ClpA8wt2CHGMddDvP1ioSTzQhKnjybGZ0mErV8lhnqA9hjm3kbkmhpB7z45X2fwJBAN9i2yfR+w+eP/Rwae3YaBUkFWSr0QfQ3+4f2jXAEdm/Vlk/N3X7I1EEvdlo86FB9Naw4il+TiQ9HNfPVSHZSAUCQH7cbjch2ClJcx1ubhkZOR/UIaGYpoxcRwB2mgTzojQb32uztcz2RyMn2tgS/qcjtijr0fiPYhUI4TQFDLTs21M=";
    static String priKey ="ICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOSFchjntMKwYuyh3djvq0pOL4eJi/s531E5JimE9QSBtsLmCGMYkINNvCSQ8ULYRDGBmOf6ENjU3vd2tCqhHpj7K7C39GWxxZI/oJNs15BNeqnDTVPM8N7Pga1ETMRBJZ0zXqOolVvdMlC4cGL0IJ9nFF5kHbksnW3QPI15/UKlAgMBAAECgYBP6pcfPJDLcTH3PRg/UHmfr74RcTnB7tg5KHo/FN8250IJ4LZYKXQIZzv/saydytH2WjMmFR6lJbSf6CRTsCrpfb3V1gFmOH7LYAcs/sY5hjuc1A7FAg/B3AIBkcU6/KsmNM1b+GjIXOj1vWuPPioARJMpTpsdprn6L98PlrZUFQJBAPzr/YZ8HPApcE7vLtHLOuZvjmE7AS0YGpspQvfCsoyuJ257Gev0ObJPCvt9hV0TSDHyRVC+7fH4YLSZ4HrR5ZsCQQDnTW6t/OOjNKKKLonyXvm0ajSp+dOjHGZ4alvNmNxTY31o5kE8hqzBGz+ASEX/OtdrPvZDGBBiBbciyuG+Mhy/AkEAnFNUiRoPXNWQCAnH+33Msv9ClpA8wt2CHGMddDvP1ioSTzQhKnjybGZ0mErV8lhnqA9hjm3kbkmhpB7z45X2fwJBAN9i2yfR+w+eP/Rwae3YaBUkFWSr0QfQ3+4f2jXAEdm/Vlk/N3X7I1EEvdlo86FB9Naw4il+TiQ9HNfPVSHZSAUCQH7cbjch2ClJcx1ubhkZOR/UIaGYpoxcRwB2mgTzojQb32uztcz2RyMn2tgS/qcjtijr0fiPYhUI4TQFDLTs21M=";

    @Autowired
    private ITBalanceChangeService tBalanceChangeService;
   @Autowired
   private ITConsumerMachineService itConsumerMachineService;
   @Autowired
   private IConsumeService iConsumeService;

   @PostMapping("/parse")
    @ResponseBody

    public BaseResponse parse(@RequestBody String jsonData) throws  Exception{

       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       DateString ds = new DateString();
       JSONObject jsonObject = JSONObject.fromObject(jsonData);
       Long time =null;
       String str;
       //通过键获取值；通过设备ID，查询是否有这台消费机
       String equipId = jsonObject.getString("equipId");
       String  serialNumber = jsonObject.getString("serialNumber");

      //传入的加密数据有空格，用此方法把空格去掉，变成拼接的加号

      /* public static String replaceBlankSpace(String str){
           if(str!=null && str.trim()!="") {
               return str.replaceAll(" ", "+");
           }else{
               return str;
           }
       }*/
       //先验证签名，出去的数据再进行加签名
       String aa=jsonData;
       String sign = RSASignature.sign(aa, priKey, "UTF-8");
       boolean doCheck = RSASignature.doCheck(aa, sign, pubKey, "UTF-8");
       System.out.println(doCheck+"我们每个人都是一滴水~~~~~~~~~~~~");
      if(doCheck==true){
          //对传入的数据进行，时间这块进行转换，unix时间戳，传入的unix转换成北京时间，然后传出unix ;
          //私钥加密，公钥解密，数据是私钥加密的数据；流程
          System.out.println(jsonObject+"1000000000000000001");

          //查询设备信息
          TConsumerMachine tConsumerMachine = itConsumerMachineService.selectTConsumerMachineByMachineId(equipId);
          //多加个判断
          if(tConsumerMachine!=null){
              Integer ii = tConsumerMachine.getState();
              //设备正常
              System.out.println(ii+"如果设备正常");
              if(ii==1){
                  //存到消费记录表里
                  Consume consume = (Consume)JSONObject.toBean(jsonObject, Consume.class);
                  //unix时间转换为string;插入到消费记录表
                  time =jsonObject.getLong("time");

                  String time1= ds.millisecondToStringShort(time);
                  consume.setTime(time1);
                  //插入到消费记录表
                  int a =iConsumeService.insertConsume(consume);
                  TBalanceChange tBalanceChange = new TBalanceChange();
                  tBalanceChange.setChangeMoney(consume.getLocalExpense());
                  int num = tBalanceChangeService.insertTBalanceChange(tBalanceChange);
                  System.out.println("该到消费了~~~~~~~~~~~~~");
                  //消费成功；
                  if(num>0){
                      Return retrun = new Return();

                      String t = df.format(new Date());
                      Long time2=  ds.stringLongToMillisecond(t)/1000;
                      System.out.println(time2+"世纪海马科技~~~~~~~~~~~~~~~~");
                      retrun.setTime(time2);
                      retrun.setSerialNumber(consume.getSerialNumber());
                      System.out.println(retrun+"第二次打印~~~~~~~~~~~");

                      BaseResponse baseResponse = new BaseResponse(StatusCode.Normal);
                      System.out.println(baseResponse+"第一次打印");
                      baseResponse.setData(retrun);
                     baseResponse.setCode1(0);
                     baseResponse.setMsg1("消费成功");
                      System.out.println("消费成功，11111111111111111111");
                      return  baseResponse;
                      //返回时间、流水号；机器状态；消费状态；
                      // return JsonUtils.obj2json(dd);
                  }else {
                      Return retrun = new Return();
                      String t = df.format(new Date());
                      Long time2=  ds.stringLongToMillisecond(t)/1000;
                      retrun.setTime(time2);
                      retrun.setSerialNumber(consume.getSerialNumber());
                      BaseResponse baseResponse = new BaseResponse(StatusCode.Normal);
                      baseResponse.setData(retrun);
                     // baseResponse.setCode1(1);
                    //  baseResponse.setMsg1("消费失败");
                      System.out.println("消费失败，请重新刷卡！");
                      //时间和流水号应该是不管什么状态都需要有的
                  }
                  //设备维护中
              }else if(ii==2){
                  System.out.println("设备维护中~~~~~~22222222222222");
                  //不能进行消费；消费记录加设备的状态返回去；
                  Return retrun = new Return();
                  String t = df.format(new Date());
                  Long time2=  ds.stringLongToMillisecond(t)/1000;
                  retrun.setTime(time2);
                  retrun.setSerialNumber(serialNumber);
                  BaseResponse baseResponse = new BaseResponse(StatusCode.Service);
                  baseResponse.setData(retrun);
                  return baseResponse;
                  //设备停止
              }else if(ii==3){
                  System.out.println("设备停止--------------------3333333333333333");
                  //处理
                  Return retrun = new Return();
                  String t = df.format(new Date());
                  Long time2=  ds.stringLongToMillisecond(t)/1000;
                  retrun.setTime(time2);
                  retrun.setSerialNumber(serialNumber);
                  BaseResponse baseResponse = new BaseResponse(StatusCode.Stop);
                  baseResponse.setData(retrun);
                  return  baseResponse;

              }
          }else{
              Return retrun = new Return();
              String t = df.format(new Date());
              Long time2=  ds.stringLongToMillisecond(t)/1000;
              retrun.setTime(time2);
              retrun.setSerialNumber(serialNumber);
              BaseResponse baseResponse = new BaseResponse(StatusCode.Failure);
              baseResponse.setCode1(-1);
              baseResponse.setMsg1("消费失败");
              baseResponse.setData(retrun);
              System.out.println("1111111111111111111111 ");
          }


      }else {

          Return retrun = new Return();
          String t = df.format(new Date());
          Long time2=  ds.stringLongToMillisecond(t)/1000;
          retrun.setTime(time2);
          retrun.setSerialNumber(serialNumber);
          BaseResponse baseResponse = new BaseResponse(StatusCode.Ff);
          baseResponse.setCode1(-1);
          baseResponse.setMsg1("消费失败");
          baseResponse.setData(retrun);
          System.out.println(baseResponse+"重新来过！！！！！");
         return  baseResponse;

      }


      return null ;
    }


    @PostMapping("/huang")
    @ResponseBody
    public  void mei(@RequestBody String o){

        System.out.println("妹妹");
        System.out.println(o+"11111111111100000001111111111");
       // String o = "{\"time\":\"2018-08-08\"}";
    }


}



