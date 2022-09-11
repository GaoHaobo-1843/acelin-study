package com.gaohb.hello.study.springTest.cache.inst;

import com.gaohb.hello.study.springTest.cache.LocalData;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author acelin
 * @CreateDate 2022/3/28 15:59
 */
@Component
public class LocalDataCache implements IDataCache{

    private int TIMEOUT_HALF_HOUR = 60 * 30; //半个小时

    /* expireAfterWrite 定时回收 */

    /*  expireAfterAccess(long, TimeUnit)：缓存项在给定时间内没有被读/写访问，则回收。请注意这种缓存的回收顺序和基于大小回收一样。
     expireAfterWrite(long,TimeUnit)：缓存项在给定时间内没有被写访问（创建或覆盖），则回收。 */

    private Cache<String, LocalData> localCache = CacheBuilder.newBuilder().maximumSize(1024)
            .expireAfterWrite(TIMEOUT_HALF_HOUR, TimeUnit.SECONDS).build();

    private Cache<String, String> localVersionCache = CacheBuilder.newBuilder().maximumSize(1024)
            .expireAfterWrite(TIMEOUT_HALF_HOUR, TimeUnit.SECONDS).build();



    @Override
    public LocalData getData(String dataId) {
        if (StringUtils.isBlank(dataId)) {
            return null;
        }

        LocalData localData =  localCache.getIfPresent(dataId);
        return localData;
    }

    @Override
    public boolean setData(String dataId, LocalData localData) {

        if (StringUtils.isBlank(dataId)) {
            return false;
        }

        localCache.put(dataId, localData);
        return true;
    }

    @Override
    public boolean removeData(String dataId) {
        if (StringUtils.isBlank(dataId)) {
            return false;
        }

        localCache.invalidate(dataId);
        localVersionCache.invalidate(dataId);
        return true;
    }

    @Override
    public void clearData() {
        localCache.invalidateAll();
        localVersionCache.invalidateAll();
    }

    @Override
    public void removeLocalCache(String dataId) {

    }

    /**
     * 本地缓存清理定时任务，每15分钟执行一次，cleanUp方法只会清理过期的缓存，不会清理有效的
     */
    @Scheduled(cron = "0 */15 * * * ?")
    public void autoCleanUp() {
        localCache.cleanUp();
        localVersionCache.cleanUp();
    }


    @Override
    public String getVersionByDataId(String dataId) {
        return localVersionCache.getIfPresent(dataId);
    }

    @Override
    public void setVersionByDataId(String dataId, String version) {
        localVersionCache.put(dataId,version);
    }
}
