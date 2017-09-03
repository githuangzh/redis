package com.huangzh.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.util.HashMap;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

/**
 * Created by Will on 2017/9/3.
 */
public class RedisDay1 {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("192.168.88.8",6379);
        System.out.println(jedis.ping());

        //key string练习
        /*jedis.select(0);
        jedis.set("k1","s1");
        String k1 = jedis.get("k1");
        System.out.println(k1);

        jedis.del("k1");
        System.out.println(k1);


        jedis.set("cou1","1");*/
        //定时销毁

        /*jedis.expire("cou1",10);
        jedis.incr("cou1");
        System.out.println(jedis.get("cou1"));
        int i = 0;
        while (i<10){
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("EXISTS?======"+jedis.get("cou1"));
            i++;
        }
        jedis.pexpire("cou1",1000);//毫秒定时
        jedis.EXPIREAT("cou1",1355292000)//时间戳定时
        jedis.ttl("cou1")//剩余生命时间
        jedis.rename("cou1","cou2")//更改key名
        */

        /*移动库
        jedis.set("day1","hello world!");
        jedis.move("day1",2);
        System.out.println(jedis.keys("*"));
        System.out.println(jedis.exists("day1"));
        jedis.select(1);
        System.out.println(jedis.exists("day1"));*/
        //append

        jedis.set("name","huangzh");
        if(jedis.exists("name")){
            jedis.append("name","love");
            System.out.println(jedis.get("name"));
        }
        //bitcount 案例计算用户上线次数 效率极高
        jedis.setbit("huangzh",170903,"1");
        jedis.setbit("huangzh",170904,"1");
        System.out.println(jedis.bitcount("huangzh"));
        //原子操作
        jedis.set("number","1");
        jedis.incr("number");
        jedis.decr("number");
        jedis.incrBy("number",100);
        jedis.decrBy("number",20);
        System.out.println(jedis.get("number"));
        //字符串截取
        System.out.println(jedis.getrange("name",0,6));
        System.out.println(jedis.getrange("name",0,-1));
        //sort练习专辑
        /*jedis.ltrim("l1",1,0);
        jedis.lpush("l1","3","1","2");
        jedis.set("user_level_1","v1");
        jedis.set("user_level_2","v4");
        jedis.set("user_level_3","v9");
        jedis.set("user_sorce_1","100");
        jedis.set("user_sorce_2","400");
        jedis.set("user_sorce_3","900");
        jedis.set("user_name_1","wangbing");
        jedis.set("user_name_2","hale");
        jedis.set("user_name_3","mike");
        System.out.println(jedis.sort("l1"));
        SortingParams params = new SortingParams();
        params.by("user_sorce_*");
        params.get("user_name_*");
        params.get("user_level_*");
        System.out.println(jedis.sort("l1",params));

        HashMap<String,String> map = new HashMap<String, String>();
        map.put("name","wanbing");
        map.put("sorce","100");
        map.put("level","v1");
        jedis.hmset("user_info_3",map);
        map.put("name","halen");
        map.put("sorce","200");
        map.put("level","v2");
        jedis.hmset("user_info_1",map);
        map.put("name","mike");
        map.put("sorce","900");
        map.put("level","v9");
        jedis.hmset("user_info_2",map);
        SortingParams params2 = new SortingParams();
        params2.by("user_info_*->sorce");
        params2.get("user_info_*->name");
        params2.get("user_info_*->level");
        System.out.println(jedis.sort("l1",params2));*/


    }
}
