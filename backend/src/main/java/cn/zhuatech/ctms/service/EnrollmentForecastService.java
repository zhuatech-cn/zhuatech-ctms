/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ctms.service;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EnrollmentForecastService {
    public Result forecast(Request r) {
        double eligibleRate = 1 - r.screenFailureRate() / 100.0;
        double siteContribution = r.averageMonthlyEnrollmentPerSite() * eligibleRate * r.daysRemaining() / 30.0;
        int projected = (int) Math.round(r.enrolledPatients() + r.activeSites() * siteContribution);
        int gap = Math.max(0, r.targetPatients() - projected);
        int additionalSites = gap == 0 ? 0 : (int) Math.ceil(gap / Math.max(siteContribution, 0.01));
        String status = projected >= r.targetPatients() ? "ON_TRACK" : projected >= r.targetPatients() * 0.85 ? "RECOVERY_PLAN" : "AT_RISK";
        List<String> actions = new ArrayList<>();
        if (additionalSites > 0) actions.add("评估新增 " + additionalSites + " 个同等入组能力中心");
        if (r.screenFailureRate() > 30) actions.add("复核筛选失败原因和入排标准执行一致性");
        if (actions.isEmpty()) actions.add("维持中心入组节奏并按周滚动复核预测");
        return new Result(projected, gap, additionalSites, status, actions);
    }
    public record Request(@Min(1) int targetPatients, @Min(0) int enrolledPatients, @Min(1) int daysRemaining,
                          @Min(1) int activeSites, @DecimalMin("0.1") double averageMonthlyEnrollmentPerSite,
                          @DecimalMin("0") @DecimalMax("95") double screenFailureRate) {}
    public record Result(int projectedEnrollment, int enrollmentGap, int additionalSites, String status, List<String> actions) {}
}
