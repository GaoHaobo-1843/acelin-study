package ${package.Service};

import java.util.List;

import com.iwhalecloud.autotest.client.vo.ResultVO;
import com.iwhalecloud.autotest.web.client.dto.request.${upperCaseName}QueryReq;
import com.iwhalecloud.autotest.web.client.dto.request.${upperCaseName}SaveReq;
import com.iwhalecloud.autotest.web.client.dto.response.${upperCaseName}Resp;

/**
 * ${table.comment!}
 * @author Admin
 */
public interface I${upperCaseName}Service {

    /**
     * 保存${table.comment!}
     * @param req
     * @return
     */
    ResultVO<String> save${upperCaseName}(${upperCaseName}SaveReq req);

    /**
     * 删除${table.comment!}
     * @param ${lowerCaseName}Id
     * @return
     */
    ResultVO<Boolean> delete${upperCaseName}(String ${lowerCaseName}Id);

    /**
     * 查询${table.comment!}表
     * @param req
     * @return
     */
    ResultVO<List<${upperCaseName}Resp>> list${upperCaseName}s(${upperCaseName}QueryReq req);

    /**
     * 获取${table.comment!}
     * @param ${lowerCaseName}Id
     * @return
     */
    ResultVO<${upperCaseName}Resp> get${upperCaseName}(String ${lowerCaseName}Id);
}