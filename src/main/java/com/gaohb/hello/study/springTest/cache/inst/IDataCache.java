package com.gaohb.hello.study.springTest.cache.inst;

import com.gaohb.hello.study.springTest.cache.LocalData;

/**
 * @author acelin
 * @createDate 2022/3/28 15:53
 */
public interface IDataCache {

    /**
     * 从缓存获取Data
     *
     * @param dataId
     * @return
     */
    LocalData getData(String dataId);

    /**
     * 把Data放进缓存
     *
     * @param dataId
     * @param localData
     */
    boolean setData(String dataId, LocalData localData);

    /**
     * 从缓存删除Data
     *
     * @param dataId
     * @return
     */
    boolean removeData(String dataId);

    /**
     * 清空Data缓存(谨慎操作)
     */
    void clearData();

    /**
     * 从本地缓存删除Data
     *
     * @param dataId
     */
    void removeLocalCache(String dataId);

    /**
     * 获取版本号
     *
     * @param dataId
     */
    String getVersionByDataId(String dataId);

    /**
     * 设置版本号
     *
     * @param dataId
     * @param version
     */
    void setVersionByDataId(String dataId, String version);
}
