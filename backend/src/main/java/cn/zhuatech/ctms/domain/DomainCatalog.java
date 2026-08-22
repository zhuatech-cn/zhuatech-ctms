/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ctms.domain;
import org.springframework.stereotype.Component;
import java.util.List;
@Component public class DomainCatalog {
    public String systemName(){return "知华 CTMS 临床试验管理平台";}
    public String sceneName(){return "研究项目、中心启动、受试者进度、访视与质量协同";}
    public List<SeedItem> seedItems(){return List.of(
        new SeedItem("CTMS-20260801-001","华东 06 中心启动资料复核","处理中","项目启动组","高"),
        new SeedItem("CTMS-20260801-002","主要研究者培训签署跟进","待处理","医学运营组","紧急"),
        new SeedItem("CTMS-20260801-003","首例受试者访视窗口核验","已完成","临床监查组","中"),
        new SeedItem("CTMS-20260801-004","研究药物存储条件确认","处理中","药物管理组","高"));}
    public List<String> recommendedActions(){return List.of("优先补齐中心启动必需文件","确认伦理、合同和研究团队培训状态","跟踪访视窗口和质量问题闭环");}
    public record SeedItem(String recordNo,String title,String status,String owner,String priority){}
}
