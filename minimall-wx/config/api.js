// 以下是业务服务器API地址
// 本机开发时使用
var WxApiRoot = 'http://localhost:8769/wx/';
// 局域网测试使用
// var WxApiRoot = 'http://192.168.0.101:8080/wx/';
// 云平台部署时使用
// var WxApiRoot = 'http://118.24.0.153:8080/wx/';
// 云平台上线时使用
// var WxApiRoot = 'https://www.menethil.com.cn/wx/';

module.exports = {
  IndexUrl: WxApiRoot + 'base/home/index', //首页数据接口
  CatalogList: WxApiRoot + 'base/catalog/index', //分类目录全部分类数据接口
  CatalogCurrent: WxApiRoot + 'base/catalog/current', //分类目录当前分类数据接口

  AuthLoginByWeixin: WxApiRoot + 'user/auth/login_by_weixin', //微信登录
  AuthLoginByAccount: WxApiRoot + 'user/auth/login', //账号登录
  AuthLogout: WxApiRoot + 'user/auth/logout', //账号登出
  AuthRegister: WxApiRoot + 'user/auth/register', //账号注册
  AuthReset: WxApiRoot + 'user/auth/reset', //账号密码重置
  AuthRegisterCaptcha: WxApiRoot + 'user/auth/regCaptcha', //验证码
  AuthBindPhone: WxApiRoot + 'user/auth/bindPhone', //绑定微信手机号

  GoodsCount: WxApiRoot + 'base/goods/count', //统计商品总数
  GoodsList: WxApiRoot + 'base/goods/list', //获得商品列表
  GoodsCategory: WxApiRoot + 'base/goods/category', //获得分类数据
  GoodsDetail: WxApiRoot + 'base/goods/detail', //获得商品的详情
  GoodsRelated: WxApiRoot + 'base/goods/related', //商品详情页的关联商品（大家都在看）

  BrandList: WxApiRoot + 'base/brand/list', //品牌列表
  BrandDetail: WxApiRoot + 'base/brand/detail', //品牌详情

  CartList: WxApiRoot + 'base/cart/index', //获取购物车的数据
  CartAdd: WxApiRoot + 'base/cart/add', // 添加商品到购物车
  CartFastAdd: WxApiRoot + 'base/cart/fastadd', // 立即购买商品
  CartUpdate: WxApiRoot + 'base/cart/update', // 更新购物车的商品
  CartDelete: WxApiRoot + 'base/cart/delete', // 删除购物车的商品
  CartChecked: WxApiRoot + 'base/cart/checked', // 选择或取消选择商品
  CartGoodsCount: WxApiRoot + 'base/cart/goodscount', // 获取购物车商品件数
  CartCheckout: WxApiRoot + 'base/cart/checkout', // 下单前信息确认

  CollectList: WxApiRoot + 'base/collect/list', //收藏列表
  CollectAddOrDelete: WxApiRoot + 'base/collect/addordelete', //添加或取消收藏

  CommentList: WxApiRoot + 'comment/list', //评论列表
  CommentCount: WxApiRoot + 'comment/count', //评论总数
  CommentPost: WxApiRoot + 'comment/post', //发表评论

  TopicList: WxApiRoot + 'base/topic/list', //专题列表
  TopicDetail: WxApiRoot + 'base/topic/detail', //专题详情
  TopicRelated: WxApiRoot + 'base/topic/related', //相关专题

  SearchIndex: WxApiRoot + 'base/search/index', //搜索关键字
  SearchResult: WxApiRoot + 'base/search/result', //搜索结果
  SearchHelper: WxApiRoot + 'base/search/helper', //搜索帮助
  SearchClearHistory: WxApiRoot + 'base/search/clearhistory', //搜索历史清楚

  AddressList: WxApiRoot + 'user/address/list', //收货地址列表
  AddressDetail: WxApiRoot + 'user/address/detail', //收货地址详情
  AddressSave: WxApiRoot + 'user/address/save', //保存收货地址
  AddressDelete: WxApiRoot + 'user/address/delete', //保存收货地址

  ExpressQuery: WxApiRoot + 'express/query', //物流查询

  RegionList: WxApiRoot + 'region/list', //获取区域列表

  OrderSubmit: WxApiRoot + 'order/submit', // 提交订单
  OrderPrepay: WxApiRoot + 'order/prepay', // 订单的预支付会话
  OrderList: WxApiRoot + 'order/list', //订单列表
  OrderDetail: WxApiRoot + 'order/detail', //订单详情
  OrderCancel: WxApiRoot + 'order/cancel', //取消订单
  OrderRefund: WxApiRoot + 'order/refund', //退款取消订单
  OrderDelete: WxApiRoot + 'order/delete', //删除订单
  OrderConfirm: WxApiRoot + 'order/confirm', //确认收货
  OrderGoods: WxApiRoot + 'order/goods', // 代评价商品信息
  OrderComment: WxApiRoot + 'order/comment', // 评价订单商品信息

  FeedbackAdd: WxApiRoot + 'base/feedback/submit', //添加反馈
  FootprintList: WxApiRoot + 'footprint/list', //足迹列表
  FootprintDelete: WxApiRoot + 'footprint/delete', //删除足迹

  UserFormIdCreate: WxApiRoot + 'formid/create', //用户FromId，用于发送模版消息

  GroupOnList: WxApiRoot + 'base/groupon/list', //团购列表
  GroupOnMy: WxApiRoot + 'base/groupon/my', //团购API-我的团购
  GroupOnDetail: WxApiRoot + 'base/groupon/detail', //团购API-详情
  GroupOnJoin: WxApiRoot + 'base/groupon/join', //团购API-详情

  CouponList: WxApiRoot + 'base/coupon/list', //优惠券列表
  CouponMyList: WxApiRoot + 'base/coupon/mylist', //我的优惠券列表
  CouponSelectList: WxApiRoot + 'base/coupon/selectlist', //当前订单可用优惠券列表
  CouponReceive: WxApiRoot + 'base/coupon/receive', //优惠券领取
  CouponExchange: WxApiRoot + 'base/coupon/exchange', //优惠券兑换

  StorageUpload: WxApiRoot + 'base/storage/upload', //图片上传,

  UserIndex: WxApiRoot + 'user/user/index', //个人页面用户相关信息
  IssueList: WxApiRoot + 'base/issue/list', //帮助信息

};