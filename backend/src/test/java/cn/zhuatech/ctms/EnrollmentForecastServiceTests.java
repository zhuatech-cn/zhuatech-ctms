/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ctms;
import cn.zhuatech.ctms.service.EnrollmentForecastService; import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class EnrollmentForecastServiceTests {
    private final EnrollmentForecastService service=new EnrollmentForecastService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void createsRecoveryPlanForSmallGap(){var r=service.forecast(new EnrollmentForecastService.Request(200,100,90,5,8,25)); assertEquals(190,r.projectedEnrollment()); assertEquals(1,r.additionalSites()); assertEquals("RECOVERY_PLAN",r.status());}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void keepsHealthyStudyOnTrack(){var r=service.forecast(new EnrollmentForecastService.Request(150,100,90,4,5,10)); assertEquals("ON_TRACK",r.status()); assertEquals(0,r.enrollmentGap());}
}
