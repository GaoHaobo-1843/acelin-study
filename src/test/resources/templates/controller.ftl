package ${package.Controller};

import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iwhalecloud.autotest.client.vo.ResultVO;
import com.iwhalecloud.autotest.web.client.api.I${upperCaseName}Service;
import com.iwhalecloud.autotest.web.client.dto.request.${upperCaseName}QueryReq;
import com.iwhalecloud.autotest.web.client.dto.request.${upperCaseName}SaveReq;
import com.iwhalecloud.autotest.web.client.dto.response.${upperCaseName}Resp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * ${table.comment!}
 * @author Admin
 */
@Api(tags = "${table.comment!}")
@Validated
@RestController
@RequestMapping("/${lowerCaseName}")
public class ${upperCaseName}Controller {

    @Resource
    private I${upperCaseName}Service ${lowerCaseName}Service;

    @ApiOperation(value = "保存${table.comment!}", notes = "保存${table.comment!}")
    @PostMapping("/save${upperCaseName}")
    public ResultVO<String> save${upperCaseName}(@RequestBody @Validated ${upperCaseName}SaveReq req) {
        return ${lowerCaseName}Service.save${upperCaseName}(req);
    }

    @ApiOperation(value = "删除${table.comment!}", notes = "删除${table.comment!}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "${lowerCaseName}Id", value = "${table.comment!}id", dataType = "string", required = true)
    })
    @DeleteMapping("/delete${upperCaseName}")
    public ResultVO<Boolean> delete${upperCaseName}(@RequestParam @NotBlank(message = "${table.comment!}id不能为空") String ${lowerCaseName}Id) {
        return ${lowerCaseName}Service.delete${upperCaseName}(${lowerCaseName}Id);
    }

    @ApiOperation(value = "查询${table.comment!}列表", notes = "查询${table.comment!}列表")
    @PostMapping("/list${upperCaseName}s")
    public ResultVO<List<${upperCaseName}Resp>> list${upperCaseName}s(@RequestBody @Validated ${upperCaseName}QueryReq req) {
        return ${lowerCaseName}Service.list${upperCaseName}s(req);
    }

    @ApiOperation(value = "获取${table.comment!}", notes = "获取${table.comment!}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "${lowerCaseName}Id", value = "${table.comment!}id", dataType = "string", required = true)
    })
    @GetMapping("/get${upperCaseName}")
    public ResultVO<${upperCaseName}Resp> get${upperCaseName}(@RequestParam @NotBlank(message = "${table.comment!}id不能为空") String ${lowerCaseName}Id) {
        return ${lowerCaseName}Service.get${upperCaseName}(${lowerCaseName}Id);
    }
}