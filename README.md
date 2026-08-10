<div align="center">

# ZhuaTech CTMS · 知华临床试验管理平台

研究项目、中心启动、受试者进度、访视执行与质量协同的前后端分离社区源码项目

[知华科技官网](https://www.zhuatech.cn/) · [产品能力](#产品能力) · [运行项目](#运行项目) · [许可与边界](#许可与边界) · [咨询](#商业授权与深度定制)

</div>

> 版权所有 © 2026 上海如静知华信息科技有限公司。本工程仅限个人非商业学习、研究与技术交流，任何商业用途或企业内部生产使用均须事先取得书面授权。

## 从中心启动到质量闭环

ZhuaTech CTMS 是知华科技推出的临床试验管理平台社区源码版。首版围绕“项目准备—中心启动—受试者入组—访视执行—问题关闭”构建管理端和移动工作台，并提供中心启动就绪度核验与运营风险评估接口。它适合作为 Java 前后端分离、权限隔离和临床运营协同的学习样例，不是经验证的生产级临床系统。

![CTMS 管理端试验运营总览](docs/images/ctms-trial-dashboard.png)

<p align="center"><em>管理端：项目、中心、入组进度与重点质量事项统一呈现</em></p>

![CTMS 移动监查工作台](docs/images/ctms-mobile-monitoring.png)

<p align="center"><em>移动端：中心访视、文件核验、问题跟进和偏差上报入口</em></p>

## 产品能力

| 业务域 | 社区版能力 | 典型使用者 |
| --- | --- | --- |
| 项目与中心 | 项目态势、中心状态、启动事项、责任团队 | 项目经理、启动专员 |
| 访视与质量 | 访视工作台、问题跟进、偏差上报、质量关闭 | CRA、质量人员 |
| 启动就绪度 | 文件完整度、伦理/合同/培训/药物条件阻断分析 | 临床运营管理者 |
| 权限与安全 | ADMIN/OPERATOR 隔离、HTTP Basic 演示鉴权 | 系统学习者 |

中心启动接口会返回 `READY / REVIEW / BLOCKED` 及阻断原因；风险接口会综合积压、延期、关键事项、容量和完整度形成建议。所有演示结果仅用于软件学习，不能代替医学判断、GCP 合规活动或正式质量决策。

## 工程结构

```text
zhuatech-ctms/
├── backend/       Java 21 / Spring Boot 4 / Security / JPA / MySQL
├── frontend/      Vue 3 / Vite / 管理端与响应式 H5
├── docs/          API、架构说明与页面截图
├── compose.yaml   本地一键编排
└── LICENSE        个人非商业社区源码许可
```

## 运行项目

准备 Docker 后执行：

```bash
cp .env.example .env
docker compose up --build
```

浏览器访问 `http://localhost:8090`。演示账号：`admin / admin123`、`operator / operator123`。联网环境必须通过环境变量更换默认凭据，并补充企业 SSO、细粒度授权、审计、加密、备份和数据脱敏。

开发模式也可分别启动：

```bash
cd backend && mvn spring-boot:run
cd frontend && npm install && npm run dev
```

接口细节见 [docs/API.md](docs/API.md)，设计边界见 [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)。

## 许可与边界

本项目使用 **ZhuaTech Community Source License 1.0（个人非商业版）**，属于 source-available 社区源码，不是 OSI 认可的开源软件。

- 允许个人学习、研究、技术交流和非商业修改。
- 禁止企业内部生产、商业部署、SaaS、收费下载、实施交付、投标、培训、品牌替换及其他直接或间接获利用途。
- 商业使用、生产部署或深度定制必须取得上海如静知华信息科技有限公司书面授权。

完整条款以 [LICENSE](LICENSE) 为准。

## 商业授权与深度定制

知华科技（上海如静知华信息科技有限公司）提供企业数字化、软件项目外包、私有化部署、系统集成与深度开发服务。

- 官网：[https://www.zhuatech.cn/](https://www.zhuatech.cn/)
- 咨询：通过官网联系，或扫描任一微信二维码。

<p align="center"><img src="docs/images/zhuatech-wechat-consulting.png" alt="知华科技微信咨询二维码一" width="260" />&nbsp;&nbsp;&nbsp;&nbsp;<img src="docs/images/zhuatech-wechat-consulting-2.png" alt="知华科技微信咨询二维码二" width="260" /></p>

## 参与与安全

仓库仅含演示数据，不包含真实受试者信息、生产接口或生产凭据。请勿提交个人隐私、健康数据、密钥和真实业务资料。贡献前阅读 [CONTRIBUTING.md](CONTRIBUTING.md)，安全问题按 [SECURITY.md](SECURITY.md) 私下报告。

关键词：知华科技 CTMS、临床试验管理系统、中心启动管理、临床监查平台、Java CTMS、Spring Boot 临床系统、Vue 企业管理系统、上海软件定制开发。

## 受试者入组预测

新增 `POST /api/ctms/insights/enrollment-forecast`，结合剩余入组周期、活跃中心数、中心月均入组能力和筛选失败率，预测最终入组人数、缺口及建议新增中心数量，输出 `ON_TRACK`、`RECOVERY_PLAN` 或 `AT_RISK`。
