/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.ctms.controller;
import cn.zhuatech.ctms.common.ApiResponse; import cn.zhuatech.ctms.service.EnrollmentForecastService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/ctms/insights/enrollment-forecast") public class EnrollmentForecastController {
    private final EnrollmentForecastService service; public EnrollmentForecastController(EnrollmentForecastService service){this.service=service;}
    @PostMapping ApiResponse<EnrollmentForecastService.Result> forecast(@Valid @RequestBody EnrollmentForecastService.Request request){return ApiResponse.ok(service.forecast(request));}
}
