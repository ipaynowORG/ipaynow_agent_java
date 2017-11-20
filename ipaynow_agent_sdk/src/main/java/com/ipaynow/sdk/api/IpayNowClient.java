package com.ipaynow.sdk.api;

import com.ipaynow.sdk.api.dto.*;

/**
 * @author hai 17/2/17
 */
public interface IpayNowClient {


    /**
     * 交易查询
     * @param reqDto, appId:商户应用唯一标识。mhtOrderNo: 商户请求流水号
     * @return TransQueryRespDto,
     *  appId,同输入
     *  mhtOrderNo,同输入
     *  nowPayOrderNo, 现在支付流水号
     *  transType,交易类型： AGENT_PAY: 代付。    AGENT_RECEIVE：代收
     *  responseCode 响应码(见文档附录)
     *  responseMsg 响应信息
     *  mhtOrderAmt ,交易金额
     *  transStatus ,交易状态。SUCCESSED,成功 。FAILED,失败。PROCESSING,处理中。
     * @throws IpayNowException
     */
    TransQueryRespDto transQuery(QueryReqDto reqDto) throws IpayNowException;

    /**
     * 单笔代付
     * @param agentPayReqDto,
     * appId:应用编号
     * accType: 入账账户类型。0 对私 1对公
     * payeeName : 入账账户户名
     * payeeCardNo :入账账户账号
     * payeeCardUnionNo : 入账账户联行号
     * agentPayMemo: 资金用途
     * notifyUrl : 商户通知地址
     * mhtReqTime : 商户请求时间
     * mhtOrderNo : 商户订单号
     * mhtOrderAmt : 代付金额
     * @return TransRespDto
     *  appId,同输入
     *  mhtOrderNo,同输入
     *  nowPayOrderNo, 现在支付流水号
     *  responseCode 响应码(见文档附录)
     *  responseMsg 响应信息
     *  transStatus ,交易状态。SUCCESSED,成功 。FAILED,失败。PROCESSING,处理中。
     * @throws IpayNowException
     */
    TransRespDto agentPay(AgentPayReqDto agentPayReqDto) throws IpayNowException;


    /**
     * 单笔代收
     * @param agentReceiveReqDto
     *  appId : 商户应用唯一标识
     *  agentPayMemo : 资金用途,代收原因，显示在银行流水中
     *  mhtUserId :商户客户唯一标识,持卡人在商户这边的唯一标识，用于获取持卡人的多张卡信息
     *  mhtUserCardId :商户白名单ID,商户自己记录的持卡人卡信息ID，因为一个人可以由多张卡
     *  cardOwner :持卡人姓名
     *  cardType :银行卡类别,0001借记卡
     *  cardNo :持卡人银行卡号
     *  cardIdenType :持卡人证件类型,0001身份证
     *  cardIdenNo :持卡人证件号
     *  cardPhoneNo :持卡人预留手机号
     *  accType :账户类型。0对私 1对公
     *  notifyUrl :商户通知地址
     *  mhtReqTime :商户请求时间
     *  mhtOrderNo :商户请求流水号
     *  mhtOrderAmt :代付金额
     * @return TransRespDto
     *  appId,同输入
     *  mhtOrderNo,同输入
     *  nowPayOrderNo, 现在支付流水号
     *  responseCode 响应码(见文档附录)
     *  responseMsg 响应信息
     *  transStatus ,交易状态。SUCCESSED,成功 。FAILED,失败。PROCESSING,处理中。
     * @throws IpayNowException
     */
    TransRespDto agentReceive(AgentReceiveReqDto agentReceiveReqDto) throws IpayNowException;

    /**
     * 账户余额查询
     * @param reqDto, appId 商户应用唯一标识。mhtOrderNo 请求流水号
     * @return BalanceQueryRespDto
     *  appId,同输入
     *  mhtOrderNo,同输入
     *  accountBalance, 账户余额
     *  responseCode 响应码(见文档附录)
     *  responseMsg 响应信息
     * @throws IpayNowException
     */
    BalanceQueryRespDto balanceQuery(QueryReqDto reqDto) throws IpayNowException;

    /**
     * 单笔代付退票查询
     * @param reqDto,appId 商户应用唯一标识,mhtOrderNo 商户请求流水号
     * @return AgentPayRefundQueryRespDto
     * responseCode 响应码(见文档附录)
     * responseMsg 响应信息
     * mhtOrderNo,同输入
     * appId,同输入
     * nowPayOrderNo , 现在支付流水号,退票流水号
     * originalMhtOrderNo ,
     * originalNowPayOrderNo , 原代付流水号
     * payeeAccType ,入账账户类型,01 对公  02 对私
     * payeeName, 入账账户户名
     * payeeCardNo, 入账账户账号
     * payeeCardUnionNo,入账账户联行号
     * refundDate,退票日期,yyyyMMdd
     * refundCode,退票码
     * refundMsg,退票原因
     * transStatus,交易状态。SUCCESSED,成功 。FAILED,失败。PROCESSING,处理中。
     * @throws IpayNowException
     */
    AgentPayRefundQueryRespDto agentPayRefundQuery(QueryReqDto reqDto) throws IpayNowException;




    /**
     * 代付退票批量查询
     * @param reqDto ,appId 商户应用唯一标识,mhtOrderNo 商户请求流水号,nowPage 商户请求页码,pageSize 商户请求数据量,refundDate 退票日期
     * @return AgentPayRefundBatchQueryRespDto
     * responseCode 响应码(见文档附录)
     * responseMsg 响应信息
     * mhtOrderNo,同输入
     * appId,同输入
     * nowPage,同输入
     * pageSize,同输入
     * countNums,数据总数
     * countPages,总页数
     * agentPayRefundQueryRespFieldList , 见AgentPayRefundQueryRespDto中的相关字段含义
     * @throws IpayNowException
     */
    AgentPayRefundBatchQueryRespDto agentPayRefundBatchQuery(BatchQueryReqDto reqDto) throws IpayNowException;

}
