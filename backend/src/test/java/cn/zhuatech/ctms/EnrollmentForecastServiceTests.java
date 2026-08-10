/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.ctms;
import cn.zhuatech.ctms.service.EnrollmentForecastService; import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class EnrollmentForecastServiceTests {
    private final EnrollmentForecastService service=new EnrollmentForecastService();
    @Test void createsRecoveryPlanForSmallGap(){var r=service.forecast(new EnrollmentForecastService.Request(200,100,90,5,8,25)); assertEquals(190,r.projectedEnrollment()); assertEquals(1,r.additionalSites()); assertEquals("RECOVERY_PLAN",r.status());}
    @Test void keepsHealthyStudyOnTrack(){var r=service.forecast(new EnrollmentForecastService.Request(150,100,90,4,5,10)); assertEquals("ON_TRACK",r.status()); assertEquals(0,r.enrollmentGap());}
}
