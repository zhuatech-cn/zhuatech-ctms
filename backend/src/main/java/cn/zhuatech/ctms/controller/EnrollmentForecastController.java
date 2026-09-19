/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ctms.controller;
import cn.zhuatech.ctms.common.ApiResponse; import cn.zhuatech.ctms.service.EnrollmentForecastService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/ctms/insights/enrollment-forecast") public class EnrollmentForecastController {
    private final EnrollmentForecastService service; /**
                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                      */
public EnrollmentForecastController(EnrollmentForecastService service){this.service=service;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping ApiResponse<EnrollmentForecastService.Result> forecast(@Valid @RequestBody EnrollmentForecastService.Request request){return ApiResponse.ok(service.forecast(request));}
}
