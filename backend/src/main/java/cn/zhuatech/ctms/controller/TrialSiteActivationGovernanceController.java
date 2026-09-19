/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ctms.controller;

import cn.zhuatech.ctms.common.ApiResponse;
import cn.zhuatech.ctms.service.TrialSiteActivationGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/ctms")
public class TrialSiteActivationGovernanceController {
    private final TrialSiteActivationGovernanceService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public TrialSiteActivationGovernanceController(TrialSiteActivationGovernanceService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/trial-site-activation")
    public ApiResponse<TrialSiteActivationGovernanceService.Assessment> assess(
            @Valid @RequestBody TrialSiteActivationGovernanceService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
