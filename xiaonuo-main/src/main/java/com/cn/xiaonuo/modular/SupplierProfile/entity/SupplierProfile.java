/*
Copyright [2020] [https://www.xiaonuo.vip]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

XiaoNuo采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改XiaoNuo源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/xiaonuobase/xiaonuo-vue
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/xiaonuobase/xiaonuo-vue
6.若您的项目无法满足以上几点，可申请商业授权，获取XiaoNuo商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.cn.xiaonuo.modular.SupplierProfile.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cn.xiaonuo.core.pojo.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.*;

/**
 * 供应商档案登记

 *
 * @author 欧阳
 * @date 2021-01-09 11:25:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("supplier_profile")
public class SupplierProfile extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 地址
     */
    private String address;

    /**
     * I类产品
     */
    private String iProduct;

    /**
     * II类产品
     */
    private String iiProduct;

    /**
     * III类产品
     */
    private String iiiProduct;

    /**
     * 供应商曾用名
     */
    private String supplierUserName;

    /**
     * 开户银行
     */
    private String openBank;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 优质级别
     */
    private String qualityLevel;

    /**
     * 网址
     */
    private String url;

    /**
     * 电话
     */
    private String phone;

    /**
     * 第一联系人
     */
    private String firstContact;

    /**
     * 部门I
     */
    private String firstDepartment;

    /**
     * 职务I
     */
    private String firstPosition;

    /**
     * 办公电话I
     */
    private String firstOfficePhone;

    /**
     * 手机I
     */
    private String firstMobilePhone;

    /**
     * 家庭电话I
     */
    private String firstHomePhone;

    /**
     * EMAIL
     */
    private String firstEmail;

    /**
     * 性别I
     */
    private String firstSex;

    /**
     * 第二联系人
     */
    private String secondContact;

    /**
     * 部门II
     */
    private String secondDepartment;

    /**
     * 职务II
     */
    private String secondPosition;

    /**
     * 办公电话II
     */
    private String secondOfficePhone;

    /**
     * 手机II
     */
    private String secondMobilePhone;

    /**
     * 家庭电话II
     */
    private String secondHomePhone;

    /**
     * EMAIL
     */
    private String secondEmail;

    /**
     * 性别I
     */
    private String secondSex;

    /**
     * 开票信息
     */
    private String billingInformation;

    /**
     * 可供应产品集合
     */
    private String collectionProducts;

    /**
     * 登记人
     */
    private String registrant;

    /**
     * 登记时间
     */
    private String registrationTime;

    /**
     * 采购人
     */
    private String purchasingAgent;

    /**
     * 采购人编号
     */
    private String purchaserNumber;
}
