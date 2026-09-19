/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ctms.service;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Service;
import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service public class SiteActivationService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public ActivationResult evaluate(ActivationRequest request){
        int completed=Math.min(request.completedDocuments(),request.essentialDocuments());
        double completeness=Math.round(completed*1000.0/request.essentialDocuments())/10.0;
        List<String> blockers=new ArrayList<>();
        if(completed<request.essentialDocuments())blockers.add("中心启动必需文件尚未齐全");
        if(!request.ethicsApproved())blockers.add("伦理审批尚未完成");
        if(!request.contractSigned())blockers.add("研究合同尚未签署");
        if(!request.investigatorsTrained())blockers.add("研究团队培训记录不完整");
        if(!request.drugStorageReady())blockers.add("研究药物存储条件未确认");
        String status=!request.ethicsApproved()||!request.contractSigned()?"BLOCKED":blockers.isEmpty()?"READY":"REVIEW";
        if(blockers.isEmpty())blockers.add("中心满足启动条件，可进入启用审批");
        return new ActivationResult(completeness,status,blockers);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ActivationRequest(@NotNull @Min(1) @Max(10000) Integer essentialDocuments,@NotNull @Min(0) @Max(10000) Integer completedDocuments,@NotNull Boolean ethicsApproved,@NotNull Boolean contractSigned,@NotNull Boolean investigatorsTrained,@NotNull Boolean drugStorageReady){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ActivationResult(double completeness,String status,List<String> blockers){}
}
