package ${package.Request};

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

/**
 * 查询${table.comment!}
 * @author Admin
 */
@ApiModel(value = "${upperCaseName}QueryReq对象", description = "查询${table.comment!}")
@SuppressWarnings("serial")
public class ${upperCaseName}QueryReq implements Serializable {

}