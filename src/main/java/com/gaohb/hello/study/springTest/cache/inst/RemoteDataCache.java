package com.gaohb.hello.study.springTest.cache.inst;

import com.gaohb.hello.study.springTest.cache.LocalData;
import org.springframework.stereotype.Component;

/**
 * @author acelin
 * @createDate 2022/3/28 15:59
 */
@Component
public class RemoteDataCache implements IDataCache{
    @Override
    public LocalData getData(String dataId) {
        return null;
    }

    @Override
    public boolean setData(String dataId, LocalData localData) {
        return false;
    }

    @Override
    public boolean removeData(String dataId) {
        return false;
    }

    @Override
    public void clearData() {

    }

    @Override
    public void removeLocalCache(String dataId) {

    }

    @Override
    public String getVersionByDataId(String dataId) {
        return null;
    }

    @Override
    public void setVersionByDataId(String dataId, String version) {

    }
}
