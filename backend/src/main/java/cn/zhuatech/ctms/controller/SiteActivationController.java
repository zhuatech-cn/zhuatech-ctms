/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ctms.controller;
import cn.zhuatech.ctms.common.ApiResponse; import cn.zhuatech.ctms.service.SiteActivationService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/admin/site-activation") public class SiteActivationController {
    private final SiteActivationService service; public SiteActivationController(SiteActivationService service){this.service=service;}
    @PostMapping ApiResponse<SiteActivationService.ActivationResult> evaluate(@Valid @RequestBody SiteActivationService.ActivationRequest request){return ApiResponse.ok(service.evaluate(request));}
}
