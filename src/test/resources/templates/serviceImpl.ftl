package ${package.ServiceImpl};

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iwhalecloud.autotest.client.entity.${entity};
import com.iwhalecloud.autotest.client.vo.ResultVO;
import com.iwhalecloud.autotest.common.enums.StatusEnum;
import com.iwhalecloud.autotest.common.util.BeanUtil;
import com.iwhalecloud.autotest.dataservice.mapper.${table.mapperName};
import com.iwhalecloud.autotest.web.client.api.I${upperCaseName}Service;
import com.iwhalecloud.autotest.web.client.dto.request.${upperCaseName}QueryReq;
import com.iwhalecloud.autotest.web.client.dto.request.${upperCaseName}SaveReq;
import com.iwhalecloud.autotest.web.client.dto.response.${upperCaseName}Resp;

/**
 * ${table.comment!}
 * @author Admin
 */
@Service
public class ${upperCaseName}ServiceImpl implements I${upperCaseName}Service {

    @Resource
    private ${table.mapperName} ${lowerCaseName}Mapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO<String> save${upperCaseName}(${upperCaseName}SaveReq req) {
        ${entity} ${lowerCaseName} = BeanUtil.copyProperties(req, ${entity}.class);
        if (StringUtils.isBlank(${lowerCaseName}.get${primaryField.capitalName}())) {
            ${lowerCaseName}Mapper.insert(${lowerCaseName});
        }
        else {
            ${lowerCaseName}Mapper.updateByPrimaryKeySelective(${lowerCaseName});
        }
        return ResultVO.ofSuccessData(${lowerCaseName}.get${primaryField.capitalName}());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO<Boolean> delete${upperCaseName}(String ${primaryField.propertyName}) {
        ${entity} ${lowerCaseName} = new ${entity}();
        ${lowerCaseName}.set${primaryField.capitalName}(${primaryField.propertyName});
        ${lowerCaseName}.setStatusCd(StatusEnum.INVALID.getCode());
        int count = ${lowerCaseName}Mapper.updateByPrimaryKeySelective(${lowerCaseName});
        return ResultVO.ofSuccessData(count > 0);
    }

    @Override
    public ResultVO<List<${upperCaseName}Resp>> list${upperCaseName}s(${upperCaseName}QueryReq req) {
        // TODO
        return null;
    }

    @Override
    public ResultVO<${upperCaseName}Resp> get${upperCaseName}(String ${primaryField.propertyName}) {
        ${entity} ${lowerCaseName} = ${lowerCaseName}Mapper.selectByPrimaryKey(${primaryField.propertyName});
        return ResultVO.ofSuccessData(BeanUtil.copyProperties(${lowerCaseName}, ${upperCaseName}Resp.class));
    }
}