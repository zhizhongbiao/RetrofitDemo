package cn.com.tianyudg.retrofitdemo.config;


public class ApiConfig {
    public static final String HOST = "http://dongguan.huifang.cn/";//测试环境
//    public static final String HOST = "http://dg.huifang.cn/";//正式环境   注意：要问后台是否 http 或者 https

    //登录
    public static final String API_LOGIN = "api/Dealer_userLogin";
    //登出
    public static final String API_LOGOUT = "api/Dealer_userLogout";

    //首页新房列表
    public static final String API_HOME_NEW_LIST = "api/Dealer_estateList";
    //新房详情
    public static final String API_HOME_NEW_DETAIL = "api/Dealer_estateDetail";
    public static final String API_HOME_NEW_DETAIL_HOUSE_TYPE = "api/Dealer_estateHousetypeList";
    //首页二手房列表
    public static final String API_HOME_SECOND_HAND_LIST = "api/Dealer_estateList_fang";
    //二手房详情
    public static final String API_HOME_SECOND_HAND_DETAIL = "api/Dealer_estateDetail_fang";
    //首页租房列表
    public static final String API_HOME_RENT_LIST = "api/Dealer_estateList_rent";
    //首页租房详情
    public static final String API_HOME_RENT_DETAIL = "api/Dealer_estateDetail_rent";
    //首页渠道团队
    public static final String API_HOME_CHANNEL_TEAM_LIST = "api/Dealer_QD_teamList";
    //首页筛选列表
    public static final String API_SUBJECT_FILTER_LIST = "api/publicLabelAndStandardData";
    //地区筛选列表
    public static final String API_REGION_LIST_FILTER = "api/publicRegionList";


    //项目新房列表
    public static final String API_PROJECT_NEW_LIST = "api/Dealer_projectDistributeList_estate";
    //项目二手房列表
    public static final String API_PROJECT_SECOND_HAND_LIST = "api/Dealer_projectDistributeList_fang";
    //项目租房列表
    public static final String API_PROJECT_RENT_LIST = "api/Dealer_projectDistributeList_rent";
    //开发商列表
    public static final String API_PROJECT_DEVELOPER_LIST = "api/Dealer_developerList";
    //开发商绑楼盘列表
    public static final String API_PROJECT_DEVELOPER_BIND_ESTATE_LIST = "api/Dealer_developerBindEstateList";
    //开发商解绑楼盘列表
    public static final String API_PROJECT_DEVELOPER_UNBIND_ESTATE_LIST = "api/Dealer_unbindEstate";
    //添加开发商
    public static final String API_PROJECT_ADD_DEVELOPER = "api/Dealer_developerAdd";
    //开发商列表详情
    public static final String API_PROJECT_DEVELOPER_DETAIL = "api/Dealer_developerDetail";
    //添加项目
    public static final String API_ADD_PROJECT = "api/Dealer_addProject";
    //上传图片
    public static final String API_UPLOAD_IMAGE = "http://dongguan.huifang.cn/api/publicUpload";

    //渠道-公司列表
    public static final String API_COMPANY_LIST = "api/Dealer_QD_company";
    //渠道列表
    public static final String API_CHANNEL_LIST = "api/Dealer_intermediaryList";
    //渠道-门店列表
    public static final String API_STORE_LIST = "api/Dealer_intermediaryMendianList";
    //渠道-团队列表
    public static final String API_TEAM_LIST = "api/Dealer_QD_team";
    //中介绑定楼盘列表 待定
//    public static final String API_AGENT_BIND_ESTATE_LIST = "api/Dealer_developerBindEstateList";
    //渠道-经纪人列表
//    public static final String API_AGENT_LIST = "api/Dealer_QD_agent";
    //渠道-添加渠道
    public static final String API_ADD_CHANNEL = "api/Dealer_intermediaryAdd";
    //渠道-绑定楼盘列表
    public static final String API_ADD_BIND_ESTATE_LIST = "api/Dealer_developerEstateList";
    //渠道-绑定楼盘
    public static final String API_ADD_BIND_ESTATE = "api/Dealer_projectAddEstate";
    //门店详情
//    public static final String API_STORE_DETAIL = "api/Dealer_mendianDetail";
    //渠道详情
    public static final String API_CHANNEL_DETAIL = "api/Dealer_intermediaryDetail";
    //经纪人详情
//    public static final String API_AGENT_DETAIL = "api/Dealer_agentDetail";


    //代理列表
    public static final String API_PROXY_LIST = "api/Dealer_dealerList";
    //代理详情
    public static final String API_PROXY_DETAIL = "api/Dealer_dealerDetail";
    //下级代理商
    public static final String API_NEXT_PROXY_LIST = "api/Dealer_dealerExistList";
    //下级开发商
    public static final String API_NEXT_DEVELOPER_LIST = "api/Dealer_dealerDeveloperList";
    //下级中介
    public static final String API_NEXT_AGENT_LIST = "api/Dealer_dealerCompanyList";
    //添加代理
    public static final String API_ADD_PROXY = "api/Dealer_dealerAdd";


    //我的-用户信息
    public static final String API_USER_INFO = "api/Dealer_userInfo";
    //我的-代理列表
    public static final String API_MY_AGENT_LIST = "api/Dealer_dailiList";
    //我的-代理列表
    public static final String API_MY_EMPLOYEE_LIST = "api/Dealer_dailiDetail";
    //我的-门店分配
    public static final String API_MY_STORE_DISTRIBUTE_LIST = "api/Dealer_employeeMendians";
    //我的-门店绑定员工
    public static final String API_MY_STORE_BIND_EMPLOYEE = "api/Dealer_mendianTieEmployee";
    //我的-添加代理
    public static final String API_ADD_AGENT = "api/Dealer_addDaili";
    //我的-添加员工
    public static final String API_ADD_EMPLOYEE = "api/Dealer_addEmployee";
    //我的提现记录列表
    public static final String API_WITHDRAW_RECORD_LIST = "api/Dealer_userFinance_withdraw";
    //我的提现详情
    public static final String API_WITHDRAW_DRTAIL = "api/Dealer_userWithdrawDetail";
    // 我的钱包
    public static final String API_MY_WALLET = "api/Dealer_userFinance";

    // 我的银行卡列表
    public static final String API_MY_BANK_CARD_LIST = "api/Dealer_userBankCardList";
    //申请提现页面
    public static final String API_APPLY_WITHDRAW = "api/Dealer_userWithdraw";
    //申请提现成功
    public static final String API_APPLY_WITHDRAW_SUCCESS = "api/Dealer_userWithdraw_success";

    //我的收入列表
    public static final String API_INCOME_RECORD_LIST = "api/Dealer_userFenrunList";
    //我的收入详情
    public static final String API_INCOME_RECORD_DETAIL = "api/Dealer_userFenrunDetail";
    //统计列表
    public static final String API_MY_SHARE_LIST = "api/Dealer_userFenrunCountList";
    //分润统计
    public static final String API_SHARE_STATISTICS = "api/Dealer_userFenrunCount";
    //绑定银行卡
    public static final String API_BIND_BANK_CARD = "api/Dealer_userSaveCard";
    //解绑定银行卡
    public static final String API_UNBIND_BANK_CARD = "api/Dealer_userCancelCard";



    //修改登录密码
    public static final String API_RESET_LOGIN_PSW = "api/Dealer_userResetPassword";
    //绑定新手机
    public static final String API_BIND_NEW_PHONE = "api/Dealer_userSetMobile";

    //设置支付密码
    public static final String API_SET_PAY_PSW = "api/Dealer_userSetPaypass";
    //修改支付密码
    public static final String API_RESET_PAY_PSW = "api/Dealer_userResetPaypass";
    //找回支付密码
    public static final String API_FIND_BACK_PAY_PSW = "api/Dealer_userFindPaypass";
    //找回登录密码
    public static final String API_FIND_BACK_LOGIN_PSW = "api/Dealer_userForgetPassword";

    //接口中的接口
    public static final String API_API = "api/publicLabelAndStandardData";

    //上传图片
    public static final String API_UPLOAD_PICTURE = "api/publicUpload";
}

