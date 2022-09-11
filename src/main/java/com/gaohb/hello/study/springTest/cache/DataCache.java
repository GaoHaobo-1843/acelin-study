package com.gaohb.hello.study.springTest.cache;

import com.gaohb.hello.study.springTest.cache.LocalData;
import com.gaohb.hello.study.springTest.cache.inst.DataCacheFactory;

/**
 *
 * @author acelin
 * @createDate 2022/3/28 15:51
 */
public class DataCache {


    /**
     * 从缓存获取LocalData
     *
     * @param dataId
     * @return
     */
    public static LocalData getLocalData(String dataId) {
        return DataCacheFactory.getCache().getData(dataId);
    }

    /**
     * 从分布式缓存获取LocalData
     *
     * @param dataId
     * @return
     */
    public static LocalData getData(String dataId) {
        return DataCacheFactory.getCache().getData(dataId);
    }

    /**
     * 把LocalData放进缓存
     *
     * @param dataId
     * @param localData
     */
    public static boolean setLocalData(String dataId, LocalData localData) {
        return DataCacheFactory.getCache().setData(dataId, localData);
    }

    /**
     * 从缓存删除LocalData
     *
     * @param dataId
     * @return
     */
    public static boolean removeLocalData(String dataId) {
        return DataCacheFactory.getCache().removeData(dataId);
    }

    /**
     * 清空LocalData缓存(谨慎操作)
     */
    public static void clearLocalData() {
        DataCacheFactory.getCache().clearData();
    }

    /**
     * 从本地缓存删除LocalData
     *
     * @param dataId
     */
    public static void removeLocalCache(String dataId) {
        DataCacheFactory.getCache().removeLocalCache(dataId);
    }
}
