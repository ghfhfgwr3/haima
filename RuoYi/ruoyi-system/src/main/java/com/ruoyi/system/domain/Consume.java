package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;
        
/**
 * 消费记录表 consume
 *
 * @author ruoyi
 * @String  2019-08-22
 */
public class Consume extends BaseEntity
        {
private static final long serialVersionUID=1L;

        /** 主键 */
    private Integer id;
            /** 时间 */
    private String  time;
            /** 流水号 */
    private String serialNumber;
            /** 会员卡号 */
    private String tMemberId;
            /** 本次消费 */
    private BigDecimal localExpense;
            /** 消费前余额 */
    private BigDecimal preExpenseBalance;
            /** 消费后余额 */
    private BigDecimal postExpenseBalance;
            /** 设备管理id, 设备管理表的外键，1.23.... */
   private Integer equipmentId;
            /**
             *  设备id
             */
            private  String  equipId;

            /** 状态标识 */
    private String stateID;
            /**
             * 会员表
             */
    private TMember tMember;
            /**
             * 消费机管理表
              */
    private  TConsumerMachine tConsumerMachine;
    
        public void setId(Integer id)
            {
            this.id = id;
            }

    public Integer getId()
            {
            return id;
            }

            public void setTime(String  time)
            {
            this.time = time;
            }

    public String  getTime()
            {
            return time;
            }
            public void setSerialNumber(String serialNumber)
            {
            this.serialNumber = serialNumber;
            }

    public String getSerialNumber()
            {
            return serialNumber;
            }

            public void setLocalExpense(BigDecimal localExpense)
            {
            this.localExpense = localExpense;
            }

    public BigDecimal getLocalExpense()
            {
            return localExpense;
            }
            public void setPreExpenseBalance(BigDecimal preExpenseBalance)
            {
            this.preExpenseBalance = preExpenseBalance;
            }

    public BigDecimal getPreExpenseBalance()
            {
            return preExpenseBalance;
            }
            public void setPostExpenseBalance(BigDecimal postExpenseBalance)
            {
            this.postExpenseBalance = postExpenseBalance;
            }

    public BigDecimal getPostExpenseBalance()
            {
            return postExpenseBalance;
            }
           public void setEquipmentId(Integer equipmentId)
            {
            this.equipmentId = equipmentId;
            }

    public Integer getEquipmentId()
            {
            return equipmentId;
            }
            public void setStateID(String stateID)
            {
            this.stateID = stateID;
            }

    public String getStateID()
            {
            return stateID;
            }
    
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id" ,getId())
                .append("time" ,getTime())
                .append("serialNumber" ,getSerialNumber())
                .append("tMemberId" ,gettMemberId())
                .append("localExpense" ,getLocalExpense())
                .append("preExpenseBalance" ,getPreExpenseBalance())
                .append("postExpenseBalance" ,getPostExpenseBalance())
               // .append("equipmentId" ,getEquipmentId())
                .append("stateID" ,getStateID())
            .toString();
        }

            public TMember gettMember() {
                return tMember;
            }

            public void settMember(TMember tMember) {
                this.tMember = tMember;
            }

            public TConsumerMachine gettConsumerMachine() {
                return tConsumerMachine;
            }

            public void settConsumerMachine(TConsumerMachine tConsumerMachine) {
                this.tConsumerMachine = tConsumerMachine;
            }

            public String gettMemberId() {
                return tMemberId;
            }

            public void settMemberId(String tMemberId) {
                this.tMemberId = tMemberId;
            }


            public String getEquipId() {
                return equipId;
            }

            public void setEquipId(String equipId) {
                this.equipId = equipId;
            }
        }
