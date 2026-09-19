/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ctms.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class TrialSiteActivationGovernanceServiceTest {
    private final TrialSiteActivationGovernanceService service = new TrialSiteActivationGovernanceService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void activatesReadySite() {
        var r = service.assess(new TrialSiteActivationGovernanceService.Request("S1", true, true, true,
                true, true, true, true, true, true, true, true, true));
        assertThat(r.decision()).isEqualTo(TrialSiteActivationGovernanceService.Decision.ACTIVATE);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void reviewsOperationalReadiness() {
        var r = service.assess(new TrialSiteActivationGovernanceService.Request("S2", true, true, true,
                true, true, true, true, true, true, true, false, false));
        assertThat(r.actions()).hasSize(2);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksRegulatoryGaps() {
        var r = service.assess(new TrialSiteActivationGovernanceService.Request("S3", false, false, false,
                false, false, false, false, false, false, false, true, true));
        assertThat(r.blockers()).hasSize(10);
    }
}
