/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ctms.controller;

import cn.zhuatech.ctms.common.ApiResponse;
import cn.zhuatech.ctms.service.TrialSiteActivationGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/ctms")
public class TrialSiteActivationGovernanceController {
    private final TrialSiteActivationGovernanceService service;
    public TrialSiteActivationGovernanceController(TrialSiteActivationGovernanceService service) { this.service = service; }
    @PostMapping("/trial-site-activation")
    public ApiResponse<TrialSiteActivationGovernanceService.Assessment> assess(
            @Valid @RequestBody TrialSiteActivationGovernanceService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
