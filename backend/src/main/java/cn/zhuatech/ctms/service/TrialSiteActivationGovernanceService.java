/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ctms.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class TrialSiteActivationGovernanceService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.ethicsApprovalCurrent()) blockers.add("伦理审批未生效或已过期");
        if (!request.regulatoryDocumentsComplete()) blockers.add("监管必备文件不完整");
        if (!request.investigatorQualified()) blockers.add("主要研究者资质未确认");
        if (!request.gcpTrainingComplete()) blockers.add("研究团队 GCP 培训未完成");
        if (!request.contractAndBudgetExecuted()) blockers.add("合同与预算未生效");
        if (!request.delegationLogComplete()) blockers.add("职责授权表不完整");
        if (!request.laboratoryCertified()) blockers.add("中心实验室资质未确认");
        if (!request.privacyControlsApproved()) blockers.add("受试者隐私控制未批准");
        if (!request.safetyReportingReady()) blockers.add("安全事件报告流程未就绪");
        if (!request.edcAccessValidated()) blockers.add("电子数据采集访问未验证");
        if (!blockers.isEmpty()) {
            actions.add("阻断中心启用并关闭伦理、合同、资质和数据缺口");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.investigationalProductReady() || !request.monitoringPlanApproved()) {
            if (!request.investigationalProductReady()) actions.add("确认试验用产品运输、温控和接收");
            if (!request.monitoringPlanApproved()) actions.add("批准中心监查计划与首次访视安排");
            return new Assessment(Decision.REVIEW, blockers, actions);
        }
        actions.add("批准中心启用并归档审批、资质、培训和系统访问证据");
        return new Assessment(Decision.ACTIVATE, blockers, actions);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String siteId, boolean ethicsApprovalCurrent,
                          boolean regulatoryDocumentsComplete, boolean investigatorQualified,
                          boolean gcpTrainingComplete, boolean contractAndBudgetExecuted,
                          boolean delegationLogComplete, boolean laboratoryCertified,
                          boolean privacyControlsApproved, boolean safetyReportingReady,
                          boolean edcAccessValidated, boolean investigationalProductReady,
                          boolean monitoringPlanApproved) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Decision { ACTIVATE, REVIEW, BLOCKED }
}
