package cuiyi.itsource.hrm.client;

import cuiyi.itsource.hrm.client.impl.CacheClientImpl;
import cuiyi.itsource.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="cache-service",fallback = CacheClientImpl.class)
public interface CacheClient {
    //设置字符串
    @GetMapping("/setStr")
    AjaxResult set(
            @RequestParam("key") String key, @RequestParam("value") String value);


    //获取字符值
    @GetMapping("/getStr")
    AjaxResult get(@RequestParam("key")String key);

    @GetMapping("/setex")
    AjaxResult setex(
            @RequestParam("key") String key,
            @RequestParam("seconds")Integer seconds,
            @RequestParam("value") String value);


    @GetMapping("/setnx")
    AjaxResult setnx(
            @RequestParam("key") String key,
            @RequestParam("value") String value);

    @GetMapping("/deleteKey")
    AjaxResult deleteKey(
            @RequestParam("key") String key);
}
