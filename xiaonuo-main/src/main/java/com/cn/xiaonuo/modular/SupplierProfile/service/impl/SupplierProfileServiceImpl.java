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
package com.cn.xiaonuo.modular.SupplierProfile.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.xiaonuo.core.exception.ServiceException;
import com.cn.xiaonuo.core.factory.PageFactory;
import com.cn.xiaonuo.core.pojo.page.PageResult;
import com.cn.xiaonuo.modular.SupplierProfile.entity.SupplierProfile;
import com.cn.xiaonuo.modular.SupplierProfile.enums.SupplierProfileExceptionEnum;
import com.cn.xiaonuo.modular.SupplierProfile.mapper.SupplierProfileMapper;
import com.cn.xiaonuo.modular.SupplierProfile.param.SupplierProfileParam;
import com.cn.xiaonuo.modular.SupplierProfile.service.SupplierProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 供应商档案登记
service接口实现类
 *
 * @author 欧阳
 * @date 2021-01-09 11:25:40
 */
@Service
public class SupplierProfileServiceImpl extends ServiceImpl<SupplierProfileMapper, SupplierProfile> implements SupplierProfileService {

    @Override
    public PageResult<SupplierProfile> page(SupplierProfileParam supplierProfileParam) {
        QueryWrapper<SupplierProfile> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotNull(supplierProfileParam)) {

            // 根据 查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSupplierId())) {
                queryWrapper.lambda().eq(SupplierProfile::getSupplierId, supplierProfileParam.getSupplierId());
            }

            // 根据供应商名称 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSupplierName())) {
                queryWrapper.lambda().like(SupplierProfile::getSupplierName, supplierProfileParam.getSupplierName());
            }

            // 根据地址 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getAddress())) {
                queryWrapper.lambda().like(SupplierProfile::getAddress, supplierProfileParam.getAddress());
            }

            // 根据I类产品 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getIProduct())) {
                queryWrapper.lambda().like(SupplierProfile::getIProduct, supplierProfileParam.getIProduct());
            }

            // 根据II类产品 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getIiProduct())) {
                queryWrapper.lambda().like(SupplierProfile::getIiProduct, supplierProfileParam.getIiProduct());
            }

            // 根据III类产品 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getIiiProduct())) {
                queryWrapper.lambda().like(SupplierProfile::getIiiProduct, supplierProfileParam.getIiiProduct());
            }

            // 根据供应商曾用名 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSupplierUserName())) {
                queryWrapper.lambda().like(SupplierProfile::getSupplierUserName, supplierProfileParam.getSupplierUserName());
            }

            // 根据开户银行 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getOpenBank())) {
                queryWrapper.lambda().like(SupplierProfile::getOpenBank, supplierProfileParam.getOpenBank());
            }

            // 根据银行账号 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getBankAccount())) {
                queryWrapper.lambda().like(SupplierProfile::getBankAccount, supplierProfileParam.getBankAccount());
            }

            // 根据优质级别 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getQualityLevel())) {
                queryWrapper.lambda().like(SupplierProfile::getQualityLevel, supplierProfileParam.getQualityLevel());
            }

            // 根据网址 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getUrl())) {
                queryWrapper.lambda().like(SupplierProfile::getUrl, supplierProfileParam.getUrl());
            }

            // 根据电话 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getPhone())) {
                queryWrapper.lambda().like(SupplierProfile::getPhone, supplierProfileParam.getPhone());
            }

            // 根据第一联系人 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstContact())) {
                queryWrapper.lambda().like(SupplierProfile::getFirstContact, supplierProfileParam.getFirstContact());
            }

            // 根据部门I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstDepartment())) {
                queryWrapper.lambda().like(SupplierProfile::getFirstDepartment, supplierProfileParam.getFirstDepartment());
            }

            // 根据职务I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstPosition())) {
                queryWrapper.lambda().like(SupplierProfile::getFirstPosition, supplierProfileParam.getFirstPosition());
            }

            // 根据办公电话I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstOfficePhone())) {
                queryWrapper.lambda().like(SupplierProfile::getFirstOfficePhone, supplierProfileParam.getFirstOfficePhone());
            }

            // 根据手机I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstMobilePhone())) {
                queryWrapper.lambda().like(SupplierProfile::getFirstMobilePhone, supplierProfileParam.getFirstMobilePhone());
            }

            // 根据家庭电话I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstHomePhone())) {
                queryWrapper.lambda().like(SupplierProfile::getFirstHomePhone, supplierProfileParam.getFirstHomePhone());
            }

            // 根据EMAIL 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstEmail())) {
                queryWrapper.lambda().like(SupplierProfile::getFirstEmail, supplierProfileParam.getFirstEmail());
            }

            // 根据性别I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstSex())) {
                queryWrapper.lambda().like(SupplierProfile::getFirstSex, supplierProfileParam.getFirstSex());
            }

            // 根据第二联系人 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondContact())) {
                queryWrapper.lambda().like(SupplierProfile::getSecondContact, supplierProfileParam.getSecondContact());
            }

            // 根据部门II 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondDepartment())) {
                queryWrapper.lambda().like(SupplierProfile::getSecondDepartment, supplierProfileParam.getSecondDepartment());
            }

            // 根据职务II 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondPosition())) {
                queryWrapper.lambda().like(SupplierProfile::getSecondPosition, supplierProfileParam.getSecondPosition());
            }

            // 根据办公电话II 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondOfficePhone())) {
                queryWrapper.lambda().like(SupplierProfile::getSecondOfficePhone, supplierProfileParam.getSecondOfficePhone());
            }

            // 根据手机II 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondMobilePhone())) {
                queryWrapper.lambda().like(SupplierProfile::getSecondMobilePhone, supplierProfileParam.getSecondMobilePhone());
            }

            // 根据家庭电话II 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondHomePhone())) {
                queryWrapper.lambda().like(SupplierProfile::getSecondHomePhone, supplierProfileParam.getSecondHomePhone());
            }

            // 根据EMAIL 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondEmail())) {
                queryWrapper.lambda().like(SupplierProfile::getSecondEmail, supplierProfileParam.getSecondEmail());
            }

            // 根据性别I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondSex())) {
                queryWrapper.lambda().like(SupplierProfile::getSecondSex, supplierProfileParam.getSecondSex());
            }

            // 根据开票信息 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getBillingInformation())) {
                queryWrapper.lambda().like(SupplierProfile::getBillingInformation, supplierProfileParam.getBillingInformation());
            }

            // 根据可供应产品集合 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getCollectionProducts())) {
                queryWrapper.lambda().like(SupplierProfile::getCollectionProducts, supplierProfileParam.getCollectionProducts());
            }

            // 根据登记人 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getRegistrant())) {
                queryWrapper.lambda().like(SupplierProfile::getRegistrant, supplierProfileParam.getRegistrant());
            }

            // 根据登记时间 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getRegistrationTime())) {
                queryWrapper.lambda().like(SupplierProfile::getRegistrationTime, supplierProfileParam.getRegistrationTime());
            }

            // 根据采购人 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getPurchasingAgent())) {
                queryWrapper.lambda().like(SupplierProfile::getPurchasingAgent, supplierProfileParam.getPurchasingAgent());
            }

            // 根据采购人编号 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getPurchaserNumber())) {
                queryWrapper.lambda().like(SupplierProfile::getPurchaserNumber, supplierProfileParam.getPurchaserNumber());
            }

        }
        return new PageResult<>(this.page(PageFactory.defaultPage(), queryWrapper));
    }

    @Override
    public List<SupplierProfile> list(SupplierProfileParam supplierProfileParam) {
        LambdaQueryWrapper<SupplierProfile> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotNull(supplierProfileParam)) {

            // 根据 查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSupplierId())) {
                queryWrapper.eq(SupplierProfile::getSupplierId, supplierProfileParam.getSupplierId());
            }

            // 根据供应商名称 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSupplierName())) {
                queryWrapper.like(SupplierProfile::getSupplierName, supplierProfileParam.getSupplierName());
            }

            // 根据地址 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getAddress())) {
                queryWrapper.like(SupplierProfile::getAddress, supplierProfileParam.getAddress());
            }

            // 根据I类产品 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getIProduct())) {
                queryWrapper.like(SupplierProfile::getIProduct, supplierProfileParam.getIProduct());
            }

            // 根据II类产品 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getIiProduct())) {
                queryWrapper.like(SupplierProfile::getIiProduct, supplierProfileParam.getIiProduct());
            }

            // 根据III类产品 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getIiiProduct())) {
                queryWrapper.like(SupplierProfile::getIiiProduct, supplierProfileParam.getIiiProduct());
            }

            // 根据供应商曾用名 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSupplierUserName())) {
                queryWrapper.like(SupplierProfile::getSupplierUserName, supplierProfileParam.getSupplierUserName());
            }

            // 根据开户银行 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getOpenBank())) {
                queryWrapper.like(SupplierProfile::getOpenBank, supplierProfileParam.getOpenBank());
            }

            // 根据银行账号 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getBankAccount())) {
                queryWrapper.like(SupplierProfile::getBankAccount, supplierProfileParam.getBankAccount());
            }

            // 根据优质级别 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getQualityLevel())) {
                queryWrapper.like(SupplierProfile::getQualityLevel, supplierProfileParam.getQualityLevel());
            }

            // 根据网址 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getUrl())) {
                queryWrapper.like(SupplierProfile::getUrl, supplierProfileParam.getUrl());
            }

            // 根据电话 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getPhone())) {
                queryWrapper.like(SupplierProfile::getPhone, supplierProfileParam.getPhone());
            }

            // 根据第一联系人 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstContact())) {
                queryWrapper.like(SupplierProfile::getFirstContact, supplierProfileParam.getFirstContact());
            }

            // 根据部门I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstDepartment())) {
                queryWrapper.like(SupplierProfile::getFirstDepartment, supplierProfileParam.getFirstDepartment());
            }

            // 根据职务I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstPosition())) {
                queryWrapper.like(SupplierProfile::getFirstPosition, supplierProfileParam.getFirstPosition());
            }

            // 根据办公电话I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstOfficePhone())) {
                queryWrapper.like(SupplierProfile::getFirstOfficePhone, supplierProfileParam.getFirstOfficePhone());
            }

            // 根据手机I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstMobilePhone())) {
                queryWrapper.like(SupplierProfile::getFirstMobilePhone, supplierProfileParam.getFirstMobilePhone());
            }

            // 根据家庭电话I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstHomePhone())) {
                queryWrapper.like(SupplierProfile::getFirstHomePhone, supplierProfileParam.getFirstHomePhone());
            }

            // 根据EMAIL 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstEmail())) {
                queryWrapper.like(SupplierProfile::getFirstEmail, supplierProfileParam.getFirstEmail());
            }

            // 根据性别I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getFirstSex())) {
                queryWrapper.like(SupplierProfile::getFirstSex, supplierProfileParam.getFirstSex());
            }

            // 根据第二联系人 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondContact())) {
                queryWrapper.like(SupplierProfile::getSecondContact, supplierProfileParam.getSecondContact());
            }

            // 根据部门II 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondDepartment())) {
                queryWrapper.like(SupplierProfile::getSecondDepartment, supplierProfileParam.getSecondDepartment());
            }

            // 根据职务II 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondPosition())) {
                queryWrapper.like(SupplierProfile::getSecondPosition, supplierProfileParam.getSecondPosition());
            }

            // 根据办公电话II 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondOfficePhone())) {
                queryWrapper.like(SupplierProfile::getSecondOfficePhone, supplierProfileParam.getSecondOfficePhone());
            }

            // 根据手机II 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondMobilePhone())) {
                queryWrapper.like(SupplierProfile::getSecondMobilePhone, supplierProfileParam.getSecondMobilePhone());
            }

            // 根据家庭电话II 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondHomePhone())) {
                queryWrapper.like(SupplierProfile::getSecondHomePhone, supplierProfileParam.getSecondHomePhone());
            }

            // 根据EMAIL 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondEmail())) {
                queryWrapper.like(SupplierProfile::getSecondEmail, supplierProfileParam.getSecondEmail());
            }

            // 根据性别I 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getSecondSex())) {
                queryWrapper.like(SupplierProfile::getSecondSex, supplierProfileParam.getSecondSex());
            }

            // 根据开票信息 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getBillingInformation())) {
                queryWrapper.like(SupplierProfile::getBillingInformation, supplierProfileParam.getBillingInformation());
            }

            // 根据可供应产品集合 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getCollectionProducts())) {
                queryWrapper.like(SupplierProfile::getCollectionProducts, supplierProfileParam.getCollectionProducts());
            }

            // 根据登记人 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getRegistrant())) {
                queryWrapper.like(SupplierProfile::getRegistrant, supplierProfileParam.getRegistrant());
            }

            // 根据登记时间 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getRegistrationTime())) {
                queryWrapper.like(SupplierProfile::getRegistrationTime, supplierProfileParam.getRegistrationTime());
            }

            // 根据采购人 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getPurchasingAgent())) {
                queryWrapper.like(SupplierProfile::getPurchasingAgent, supplierProfileParam.getPurchasingAgent());
            }

            // 根据采购人编号 模糊查询
            if (ObjectUtil.isNotEmpty(supplierProfileParam.getPurchaserNumber())) {
                queryWrapper.like(SupplierProfile::getPurchaserNumber, supplierProfileParam.getPurchaserNumber());
            }

        }
        return this.list(queryWrapper);
    }

    @Override
    public void add(SupplierProfileParam supplierProfileParam) {
        SupplierProfile supplierProfile = new SupplierProfile();
        BeanUtil.copyProperties(supplierProfileParam, supplierProfile);
        this.save(supplierProfile);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(SupplierProfileParam supplierProfileParam) {
            this.removeById(supplierProfileParam.getSupplierId());
                                                                                                                                            }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(SupplierProfileParam supplierProfileParam) {
        SupplierProfile supplierProfile = this.querySupplierProfile(supplierProfileParam);
        BeanUtil.copyProperties(supplierProfileParam, supplierProfile);
        this.updateById(supplierProfile);
    }

    @Override
    public SupplierProfile detail(SupplierProfileParam supplierProfileParam) {
        return this.querySupplierProfile(supplierProfileParam);
    }

    /**
     * 获取供应商档案登记

     *
     * @author 欧阳
     * @date 2021-01-09 11:25:40
     */
    private SupplierProfile querySupplierProfile(SupplierProfileParam supplierProfileParam) {
        SupplierProfile supplierProfile = this.getById(supplierProfileParam.getSupplierId());
        if (ObjectUtil.isNull(supplierProfile)) {
            throw new ServiceException(SupplierProfileExceptionEnum.NOT_EXIST);
        }
        return supplierProfile;
    }
}
