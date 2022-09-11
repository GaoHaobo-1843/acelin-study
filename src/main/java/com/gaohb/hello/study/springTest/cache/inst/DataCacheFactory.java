package com.gaohb.hello.study.springTest.cache.inst;

import com.gaohb.hello.study.springTest.util.SpringUtil;
/**
 * @author acelin
 * @createDate 2022/3/28 15:53
 */
public class DataCacheFactory {

    /**
     * 获取Data缓存
     *
     * @return
     */
    public static IDataCache getCache() {
        if (true) {
            //本地缓存模式
            return SpringUtil.getBean(LocalDataCache.class);
        }
        else {
            //分布式缓存模式
            return SpringUtil.getBean(RemoteDataCache.class);
        }
    }
}
