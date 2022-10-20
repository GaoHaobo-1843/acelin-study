package mybatisplus.gennerator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.gaohb.hello.study.springTest.mybatis.BaseMapper;
import com.google.common.collect.Maps;

/**
 * MyBatis代码生成器
 * @author Admin
 */
public final class CodeGenerator {

    private static final Logger logger = LoggerFactory.getLogger(CodeGenerator.class);

    private static String url;
    private static String username;
    private static String password;
    private static String driverClass;

    private static String outputFilePath;
    private static String parentPackage;
    private static String entityPackage;
    private static String mapperPackage;
    private static String xmlPackage;
    private static String controllerPackage;
    private static String servicePackage;
    private static String serviceImplPackage;
    private static String requestPackage;
    private static String responsePackage;
    private static String tableNames;

    static {
        Properties properties = new Properties();
        InputStream inStream = CodeGenerator.class.getResourceAsStream("/generator.properties");
        try {
            properties.load(inStream);
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
            driverClass = properties.getProperty("jdbc.driverClass");

            outputFilePath = properties.getProperty("outputFilePath");
            parentPackage = properties.getProperty("parentPackage");
            entityPackage = properties.getProperty("entityPackage");
            mapperPackage = properties.getProperty("mapperPackage");
            xmlPackage = properties.getProperty("xmlPackage");
            tableNames = properties.getProperty("tableNames");

            controllerPackage = properties.getProperty("controllerPackage");
            servicePackage = properties.getProperty("servicePackage");
            serviceImplPackage = properties.getProperty("serviceImplPackage");
            requestPackage = properties.getProperty("requestPackage");
            responsePackage = properties.getProperty("responsePackage");
        }
        catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private CodeGenerator() {

    }

    public static void main(String[] args) {
        // 代码生成器
        CustomAutoGenerator autoGenerator = new CustomAutoGenerator();
        autoGenerator.setGlobalConfig(getGlobalConfig());
        autoGenerator.setDataSource(getDataSourceConfig());
        autoGenerator.setPackageInfo(getPackageConfig());
        autoGenerator.setCfg(getInjectionConfig());
        autoGenerator.setTemplate(getTemplateConfig());
        autoGenerator.setStrategy(getStrategyConfig());
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

        autoGenerator.setFileOutConfigs(getExtFileOutConfigs());
        autoGenerator.setPackageMap(getExtPackageMap());

        autoGenerator.execute();
    }

    /**
     * 全局配置
     * @return
     */
    private static GlobalConfig getGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        // 是否打开输出目录
        globalConfig.setOpen(false);
        // 是否覆盖已有文件
        globalConfig.setFileOverride(true);
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setSwagger2(true);

        return globalConfig;
    }

    /**
     * 数据源配置
     * @return
     */
    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName(driverClass);
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);

        return dataSourceConfig;
    }

    /**
     * 包配置
     * @return
     */
    private static PackageConfig getPackageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(parentPackage);
        packageConfig.setEntity(entityPackage);
        packageConfig.setMapper(mapperPackage);

        packageConfig.setController(controllerPackage);
        packageConfig.setService(servicePackage);
        packageConfig.setServiceImpl(serviceImplPackage);

        return packageConfig;
    }

    /**
     * 自定义配置
     * @return
     */
    private static InjectionConfig getInjectionConfig() {
        InjectionConfig injectionConfig = new InjectionConfig() {

            @Override
            public void initMap() {
                // to do nothing
            }
        };

        injectionConfig.setFileOutConfigList(getFileOutConfigs());
        return injectionConfig;
    }

    /**
     * 配置模板
     * @return
     */
    private static TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.disable(TemplateType.values());

        return templateConfig;
    }

    /**
     * 策略配置
     * @return
     */
    private static StrategyConfig getStrategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityColumnConstant(true);
        strategyConfig.setSuperMapperClass(BaseMapper.class.getName());
        // 表名
        strategyConfig.setInclude(tableNames.split(","));

        return strategyConfig;
    }

    /**
     * 自定义输出配置
     * @return
     */
    private static List<FileOutConfig> getFileOutConfigs() {
        // 自定义输出配置(自定义配置会优先输出)
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        fileOutConfigs.add(getEntityFileOutConfig());
        fileOutConfigs.add(getMapperFileOutConfig());
        fileOutConfigs.add(getXmlFileOutConfig());

        return fileOutConfigs;
    }

    /**
     * 数据entity层
     * @return
     */
    private static FileOutConfig getEntityFileOutConfig() {
        String templatePath = "/templates/entity.ftl";
        return new FileOutConfig(templatePath) {

            @Override
            public String outputFile(TableInfo tableInfo) {
                String path = outputFilePath + entityPackage.replace(StringPool.DOT, StringPool.SLASH);
                String outputFile = String.format(path + StringPool.SLASH + "%s" + StringPool.DOT_JAVA,
                    tableInfo.getEntityName());
                return outputFile;
            }
        };
    }

    /**
     * 数据mapper层
     * @return
     */
    private static FileOutConfig getMapperFileOutConfig() {
        String templatePath = "/templates/mapper.ftl";
        return new FileOutConfig(templatePath) {

            @Override
            public String outputFile(TableInfo tableInfo) {
                String path = outputFilePath + mapperPackage.replace(StringPool.DOT, StringPool.SLASH);
                String outputFile = String.format(path + StringPool.SLASH + "%s%s" + StringPool.DOT_JAVA,
                    tableInfo.getEntityName(), "Mapper");
                return outputFile;
            }
        };
    }

    /**
     * mapper.xml
     * @return
     */
    private static FileOutConfig getXmlFileOutConfig() {
        String templatePath = "/templates/xml.ftl";
        return new FileOutConfig(templatePath) {

            @Override
            public String outputFile(TableInfo tableInfo) {
                String path = outputFilePath + xmlPackage.replace(StringPool.DOT, StringPool.SLASH);
                String outputFile = String.format(path + StringPool.SLASH + "%s%s" + StringPool.DOT_XML,
                    tableInfo.getEntityName(), "Mapper");
                return outputFile;
            }
        };
    }

    private static List<FileOutConfig> getExtFileOutConfigs() {
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        fileOutConfigs.add(getControllerFileOutConfig());
        fileOutConfigs.add(getServiceFileOutConfig());
        fileOutConfigs.add(getServiceImplFileOutConfig());
        fileOutConfigs.add(getSaveReqFileOutConfig());
        fileOutConfigs.add(getQueryReqFileOutConfig());
        fileOutConfigs.add(getQueryRespFileOutConfig());
        return fileOutConfigs;
    }

    private static Map<String, String> getExtPackageMap() {
        Map<String, String> packageMap = Maps.newHashMap();
        packageMap.put("Request", joinPackage(parentPackage, requestPackage));
        packageMap.put("Response", joinPackage(parentPackage, responsePackage));
        return packageMap;
    }

    private static String joinPackage(String parent, String subPackage) {
        return StringUtils.isBlank(parent) ? subPackage : (parent + StringPool.DOT + subPackage);
    }

    private static FileOutConfig getControllerFileOutConfig() {
        String templatePath = "/templates/controller.ftl";
        return new FileOutConfig(templatePath) {

            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = tableInfo.getEntityName();
                if (StringUtils.startsWith(entityName, CustomAutoGenerator.PREFIX_AT)) {
                    entityName = entityName.substring(CustomAutoGenerator.PREFIX_AT.length());
                }

                String path = outputFilePath + controllerPackage.replace(StringPool.DOT, StringPool.SLASH);
                String outputFile = String.format(path + StringPool.SLASH + "%s%s" + StringPool.DOT_JAVA, entityName,
                    "Controller");
                return outputFile;
            }
        };
    }

    private static FileOutConfig getServiceFileOutConfig() {
        String templatePath = "/templates/service.ftl";
        return new FileOutConfig(templatePath) {

            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = tableInfo.getEntityName();
                if (StringUtils.startsWith(entityName, CustomAutoGenerator.PREFIX_AT)) {
                    entityName = entityName.substring(CustomAutoGenerator.PREFIX_AT.length());
                }

                String path = outputFilePath + servicePackage.replace(StringPool.DOT, StringPool.SLASH);
                String outputFile = String.format(path + StringPool.SLASH + "%s%s%s" + StringPool.DOT_JAVA, "I",
                    entityName, "Service");
                return outputFile;
            }
        };
    }

    private static FileOutConfig getServiceImplFileOutConfig() {
        String templatePath = "/templates/serviceImpl.ftl";
        return new FileOutConfig(templatePath) {

            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = tableInfo.getEntityName();
                if (StringUtils.startsWith(entityName, CustomAutoGenerator.PREFIX_AT)) {
                    entityName = entityName.substring(CustomAutoGenerator.PREFIX_AT.length());
                }

                String path = outputFilePath + serviceImplPackage.replace(StringPool.DOT, StringPool.SLASH);
                String outputFile = String.format(path + StringPool.SLASH + "%s%s" + StringPool.DOT_JAVA, entityName,
                    "ServiceImpl");
                return outputFile;
            }
        };
    }

    private static FileOutConfig getSaveReqFileOutConfig() {
        String templatePath = "/templates/saveReq.ftl";
        return new FileOutConfig(templatePath) {

            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = tableInfo.getEntityName();
                if (StringUtils.startsWith(entityName, CustomAutoGenerator.PREFIX_AT)) {
                    entityName = entityName.substring(CustomAutoGenerator.PREFIX_AT.length());
                }

                String path = outputFilePath + requestPackage.replace(StringPool.DOT, StringPool.SLASH);
                String outputFile = String.format(path + StringPool.SLASH + "%s%s" + StringPool.DOT_JAVA, entityName,
                    "SaveReq");
                return outputFile;
            }
        };
    }

    private static FileOutConfig getQueryReqFileOutConfig() {
        String templatePath = "/templates/queryReq.ftl";
        return new FileOutConfig(templatePath) {

            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = tableInfo.getEntityName();
                if (StringUtils.startsWith(entityName, CustomAutoGenerator.PREFIX_AT)) {
                    entityName = entityName.substring(CustomAutoGenerator.PREFIX_AT.length());
                }

                String path = outputFilePath + requestPackage.replace(StringPool.DOT, StringPool.SLASH);
                String outputFile = String.format(path + StringPool.SLASH + "%s%s" + StringPool.DOT_JAVA, entityName,
                    "QueryReq");
                return outputFile;
            }
        };
    }

    private static FileOutConfig getQueryRespFileOutConfig() {
        String templatePath = "/templates/queryResp.ftl";
        return new FileOutConfig(templatePath) {

            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = tableInfo.getEntityName();
                if (StringUtils.startsWith(entityName, CustomAutoGenerator.PREFIX_AT)) {
                    entityName = entityName.substring(CustomAutoGenerator.PREFIX_AT.length());
                }

                String path = outputFilePath + responsePackage.replace(StringPool.DOT, StringPool.SLASH);
                String outputFile = String.format(path + StringPool.SLASH + "%s%s" + StringPool.DOT_JAVA, entityName,
                    "Resp");
                return outputFile;
            }
        };
    }
}
