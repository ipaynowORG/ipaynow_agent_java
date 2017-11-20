
# 代收付SDK使用说明 #

## 版本变更记录 ##


- 1.0.0 : 初稿

## 目录 ##

[1. 概述](#1)

&nbsp;&nbsp;&nbsp;&nbsp;[1.1 简介](#1.1)

&nbsp;&nbsp;&nbsp;&nbsp;[1.2 如何获取](#1.2)

[2. API](#2)

&nbsp;&nbsp;&nbsp;&nbsp;[2.1 代收付API](#2.1)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[单笔代收](#2.1.1)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[单笔代付](#2.1.2)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[账户余额查询](#2.1.3)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[交易查询](#2.1.4)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[单笔代付退票查询](#2.1.5)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[代付退票批量查询](#2.1.6)

&nbsp;&nbsp;&nbsp;&nbsp;[2.2 支付结果通知](#2.2)

[3. 完整DEMO](#3)

[4. 完整DEMO](#4)


<h2 id='1'> 1. 概述 </h2>

<h4 id='1.1'> 1.1 简介 </h4>

- 代收: 代收是指现在支付商户与自己的客户签订代收协议，并委托现在支付对已经与自己签订代收协议的商户发起银行卡扣款，所扣款项进入现在支付商户的余额账户中。商户可以选择代扣资金是停留在商户余额账户中，还是T+1结算入商户的结算账户中。

- 代付: 代付是指现在支付商户根据自己的业务需要先将业务资金充值入自己在现在支付的余额账户中，然后发起指令，委托现在支付从自己的虚拟账户中将业务资金转账到指令中指定的银行卡中。业务资金将实时入账到指令指定的收款人银行卡。

<h4 id='1.2'> 1.2 如何获取 </h4>

[获取源码](https://github.com/ipaynowORG/ipaynow_agent_java)

[demo源码](https://github.com/ipaynowORG/ipaynow_agent_java)

Maven坐标如下

	<dependency>
	       <groupId>com.github.ipaynow</groupId>
           <artifactId>ipaynow_agent_sdk</artifactId>
           <version>1.0.0</version>
	</dependency>





<h2 id='2'> 2. API </h2>

<h4 id='2.1'> 2.1 代收付API </h4>

<h5 id='2.1.1'></h4>

- 单笔代收

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

<h5 id='2.1.2'></h4>

- 单笔代付

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

<h5 id='2.1.3'></h4>

- 账户余额查询

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

<h5 id='2.1.4'></h4>

- 交易查询

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

<h5 id='2.1.5'></h4>

- 单笔代付退票查询

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

<h5 id='2.1.6'></h4>

- 代付退票批量查询

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

<h4 id='2.2'>2.2 支付结果通知</h4>

通知方式采用httppost方式通知,接受demo如下

        //获取通知数据需要从body中流式读取
        BufferedReader reader = req.getReader();
        StringBuilder reportBuilder = new StringBuilder();
        String tempStr = "";
        while((tempStr = reader.readLine()) != null){
               reportBuilder.append(tempStr);
        }
        //报文数据字符串
        String reportContent = reportBuilder.toString();

    结果通知现在支付请求数据示例：
        {“data”:{“transType”:”PAY”,”chTransId”:”200003201703221910181130275”,”mhtOrderAmt”:”1”,”responseCode”:”A001”,”responseMsg”:”成功”,”responseTime”:”20170322191042”,
        ”transStatus”:”SUCCESSED”，“mhtOrderNo”:”20170322191017s”},
        ”sign_r”:”48f9a9554a3914e5d39489a3e626bd2d9b687455a1683631f5a64c5a0fed9af9”,sign_s:”152a310c0dac28c624783a9090ddd8717718c12629dbf0224c1a1170b03beaf4”,”sign_v”:”28”}

    结果通知商户响应数据示例：
        {“success”:”Y”}

    若商户未成功响应现在支付发出的通知，现在支付会重新通知商户，规则如下：
    1.前5分钟，每分钟通知一次，累计5次
    2.5分钟后，每5分钟通知一次，累计5次

字段含义如下:

<table>
        <tr>
            <th>字段名称</th>
            <th>字段Key</th>
            <th>格式</th>
            <th>必填</th>
            <th>备注</th>
        </tr>
        <tr>
            <td>商户请求流水号</td>
            <td>mhtOrderNo</td>
            <td>String (1,40)</td>
            <td>Y</td>
            <td>同输入</td>
        </tr>
        <tr>
            <td>现在支付流水号</td>
            <td>chTransId</td>
            <td>String(1,60)</td>
            <td>N</td>
            <td></td>
        </tr>
        <tr>
            <td>交易类型</td>
            <td>transType</td>
            <td>String(1,60)</td>
            <td>N</td>
            <td>AGENT_PAY: 代付 。AGENT_RECEIVE：代收</td>
        </tr>
        <tr>
            <td>响应码</td>
            <td>responseCode</td>
            <td>String(4)</td>
            <td>Y</td>
            <td>见文档附录</td>
        </tr>
        <tr>
            <td>响应信息</td>
            <td>responseMsg</td>
            <td>String(1,100)</td>
            <td>Y</td>
            <td>相应信息</td>
        </tr>
        <tr>
            <td>响应时间</td>
            <td>responseTime</td>
            <td>String(14)</td>
            <td>Y</td>
            <td>yyyyMMddHHmmss</td>
        </tr>
        <tr>
            <td>交易金额</td>
            <td>mhtOrderAmt</td>
            <td>Number(22)</td>
            <td>N</td>
            <td>单位:分</td>
        </tr>
        <tr>
            <td>交易状态</td>
            <td>transStatus</td>
            <td>String(4)</td>
            <td>N</td>
            <td>SUCCESSED,成功。FAILED,失败。PROCESSING,处理中。</td>
        </tr>
    </table>



<h2 id='3'> 3. 完整DEMO </h2>

            直接运行cn.ipaynow.ipaynow_pay_demo.Main
            访问
            http://127.0.0.1:7072/paytest/index.html