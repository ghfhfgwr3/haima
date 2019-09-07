package com.ruoyi.web.controller.wai.controller;

import com.ruoyi.system.domain.TBalanceChange;
import com.ruoyi.system.service.ITBalanceChangeService;
import com.ruoyi.web.controller.Utils.DateString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/api")
public class DedController {


   /* @Autowired
   ITBalanceChangeService itBalanceChangeService;*/

    @GetMapping("/get")
    @ResponseBody
    public  void mei(){
       /* TBalanceChange tt = new TBalanceChange();
        tt.setMemo("1");
        tt.setMemberNo("101");
        int a = itBalanceChangeService.insertTBalanceChange(tt);
        System.out.println(a+"000000000000000000000");*/


    }

    public static void main(String[] args) throws  Exception {
        DateString dd = new DateString();
        //返回字符串格式 yyyy-MM-dd HH:mm:ss
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
        String dateString = formatter.format(currentTime);
       Long time= dd.stringShortToMillisecond(dateString);
        System.out.println(time+"志飞高远 成就人生");
       // 2019/9/4 15:14:50
        Date date = new Date();
        Long time1 =dd.dateToMillisecond(date);
        System.out.println(time1+"时间");
        System.out.println("===========================================================");


        Date d=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t=df.format(d);
        long  epoch=df.parse(t).getTime()/1000;
        System.out.println("t is ："+t+",unix stamp is "+epoch);
    }
}
