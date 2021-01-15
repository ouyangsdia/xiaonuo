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
package com.cn.xiaonuo.modular.apply_approval.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.xiaonuo.core.consts.CommonConstant;
import com.cn.xiaonuo.core.enums.CommonStatusEnum;
import com.cn.xiaonuo.core.exception.ServiceException;
import com.cn.xiaonuo.core.factory.PageFactory;
import com.cn.xiaonuo.core.pojo.page.PageResult;
import com.cn.xiaonuo.modular.apply_approval.entity.ApplyApproval;
import com.cn.xiaonuo.modular.apply_approval.enums.ApplyApprovalExceptionEnum;
import com.cn.xiaonuo.modular.apply_approval.mapper.ApplyApprovalMapper;
import com.cn.xiaonuo.modular.apply_approval.param.ApplyApprovalParam;
import com.cn.xiaonuo.modular.apply_approval.service.ApplyApprovalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * 申请登记service接口实现类
 *
 * @author 欧阳
 * @date 2021-01-15 09:34:30
 */
@Service
public class ApplyApprovalServiceImpl extends ServiceImpl<ApplyApprovalMapper, ApplyApproval> implements ApplyApprovalService {

    @Override
    public PageResult<ApplyApproval> page(ApplyApprovalParam applyApprovalParam) {
        QueryWrapper<ApplyApproval> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotNull(applyApprovalParam)) {

            // 根据 查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getId())) {
                queryWrapper.lambda().eq(ApplyApproval::getId, applyApprovalParam.getId());
            }

            // 根据供应商名称 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getSupplierName())) {
                queryWrapper.lambda().like(ApplyApproval::getSupplierName, applyApprovalParam.getSupplierName());
            }

            // 根据供应商编号 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getSupplierNo())) {
                queryWrapper.lambda().like(ApplyApproval::getSupplierNo, applyApprovalParam.getSupplierNo());
            }

            // 根据电话 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getPhone())) {
                queryWrapper.lambda().like(ApplyApproval::getPhone, applyApprovalParam.getPhone());
            }

            // 根据拟供货时间 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getSupplyTime())) {
                queryWrapper.lambda().like(ApplyApproval::getSupplyTime, applyApprovalParam.getSupplyTime());
            }

            // 根据登记人 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getRegistrant())) {
                queryWrapper.lambda().like(ApplyApproval::getRegistrant, applyApprovalParam.getRegistrant());
            }

            // 根据所在区域 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getArea())) {
                queryWrapper.lambda().like(ApplyApproval::getArea, applyApprovalParam.getArea());
            }

            // 根据备注 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getRemark())) {
                queryWrapper.lambda().like(ApplyApproval::getRemark, applyApprovalParam.getRemark());
            }

        }
        return new PageResult<>(this.page(PageFactory.defaultPage(), queryWrapper));
    }

    @Override
    public List<ApplyApproval> list(ApplyApprovalParam applyApprovalParam) {
        LambdaQueryWrapper<ApplyApproval> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotNull(applyApprovalParam)) {

            // 根据 查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getId())) {
                queryWrapper.eq(ApplyApproval::getId, applyApprovalParam.getId());
            }

            // 根据供应商名称 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getSupplierName())) {
                queryWrapper.like(ApplyApproval::getSupplierName, applyApprovalParam.getSupplierName());
            }

            // 根据供应商编号 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getSupplierNo())) {
                queryWrapper.like(ApplyApproval::getSupplierNo, applyApprovalParam.getSupplierNo());
            }

            // 根据电话 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getPhone())) {
                queryWrapper.like(ApplyApproval::getPhone, applyApprovalParam.getPhone());
            }

            // 根据拟供货时间 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getSupplyTime())) {
                queryWrapper.like(ApplyApproval::getSupplyTime, applyApprovalParam.getSupplyTime());
            }

            // 根据登记人 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getRegistrant())) {
                queryWrapper.like(ApplyApproval::getRegistrant, applyApprovalParam.getRegistrant());
            }

            // 根据所在区域 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getArea())) {
                queryWrapper.like(ApplyApproval::getArea, applyApprovalParam.getArea());
            }

            // 根据备注 模糊查询
            if (ObjectUtil.isNotEmpty(applyApprovalParam.getRemark())) {
                queryWrapper.like(ApplyApproval::getRemark, applyApprovalParam.getRemark());
            }

        }
        return this.list(queryWrapper);
    }

    @Override
    public void add(ApplyApprovalParam applyApprovalParam) {
        ApplyApproval applyApproval = new ApplyApproval();
        BeanUtil.copyProperties(applyApprovalParam, applyApproval);
        this.save(applyApproval);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(ApplyApprovalParam applyApprovalParam) {
            this.removeById(applyApprovalParam.getId());
                                    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(ApplyApprovalParam applyApprovalParam) {
        ApplyApproval applyApproval = this.queryApplyApproval(applyApprovalParam);
        BeanUtil.copyProperties(applyApprovalParam, applyApproval);
        this.updateById(applyApproval);
    }

    @Override
    public ApplyApproval detail(ApplyApprovalParam applyApprovalParam) {
        return this.queryApplyApproval(applyApprovalParam);
    }

    /**
     * 获取申请登记
     *
     * @author 欧阳
     * @date 2021-01-15 09:34:30
     */
    private ApplyApproval queryApplyApproval(ApplyApprovalParam applyApprovalParam) {
        ApplyApproval applyApproval = this.getById(applyApprovalParam.getId());
        if (ObjectUtil.isNull(applyApproval)) {
            throw new ServiceException(ApplyApprovalExceptionEnum.NOT_EXIST);
        }
        return applyApproval;
    }
}
