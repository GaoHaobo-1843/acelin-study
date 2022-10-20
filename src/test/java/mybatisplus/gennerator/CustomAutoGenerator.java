package mybatisplus.gennerator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.google.common.collect.Sets;

/**
 * @author Admin
 */
public class CustomAutoGenerator  extends AutoGenerator {

    private static final Logger logger = LoggerFactory.getLogger(CustomAutoGenerator.class);

    public static final String PREFIX_AT = "At";
    private static final String KEY_LOWE_RCASE_NAME = "lowerCaseName";
    private static final String KEY_UPPER_CASE_NAME = "upperCaseName";
    private static final String KEY_DTO = "dto";
    private static final String PRIMARY_FIELD = "primaryField";

    private static final Set<String> NON_DTO_FIELDS = Sets.newHashSet("status_cd", "status_date", "create_user",
        "create_date", "update_user", "update_date");
    private List<FileOutConfig> fileOutConfigs;
    private Map<String, String> packageMap;

    public List<FileOutConfig> getFileOutConfigs() {
        return fileOutConfigs;
    }

    public void setFileOutConfigs(List<FileOutConfig> fileOutConfigs) {
        this.fileOutConfigs = fileOutConfigs;
    }

    public Map<String, String> getPackageMap() {
        return packageMap;
    }

    public void setPackageMap(Map<String, String> packageMap) {
        this.packageMap = packageMap;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute() {
        super.execute();

        ConfigBuilder configBuilder = pretreatmentConfigBuilder(config);
        AbstractTemplateEngine templateEngine = new FreemarkerTemplateEngine();
        templateEngine.init(configBuilder);
        List<TableInfo> tableInfos = configBuilder.getTableInfoList();
        for (TableInfo tableInfo : tableInfos) {
            Map<String, Object> objectMap = templateEngine.getObjectMap(tableInfo);
            Object packageInfo = objectMap.get("package");
            if (Objects.nonNull(packageInfo) && packageInfo instanceof Map && Objects.nonNull(packageMap)) {
                ((Map<String, String>) packageInfo).putAll(packageMap);
            }
            String entityName = tableInfo.getEntityName();
            if (StringUtils.startsWith(entityName, PREFIX_AT)) {
                // 去掉At前缀
                entityName = entityName.substring(PREFIX_AT.length());
            }
            // 首字母小写
            objectMap.put(KEY_LOWE_RCASE_NAME, StringUtils.uncapitalize(entityName));
            // 首字母大写
            objectMap.put(KEY_UPPER_CASE_NAME, entityName);

            List<TableField> dtoFields = tableInfo.getFields().stream()
                .filter(field -> !NON_DTO_FIELDS.contains(field.getColumnName())).collect(Collectors.toList());
            TableField primaryField = dtoFields.stream().filter(TableField::isKeyFlag).findFirst().orElse(null);
            objectMap.put(KEY_DTO, new TableInfo().setFields(dtoFields));
            objectMap.put(PRIMARY_FIELD, primaryField);

            for (FileOutConfig fileOutConfig : fileOutConfigs) {
                try {
                    String outputFile = fileOutConfig.outputFile(tableInfo);
                    if (createFile(outputFile)) {
                        templateEngine.writer(objectMap, fileOutConfig.getTemplatePath(), outputFile);
                    }
                }
                catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 创建文件
     * @param filePath
     * @return
     * @throws IOException 
     */
    protected boolean createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            FileUtils.forceDelete(file);
        }
        FileUtils.forceMkdirParent(file);
        return file.createNewFile();
    }
}
