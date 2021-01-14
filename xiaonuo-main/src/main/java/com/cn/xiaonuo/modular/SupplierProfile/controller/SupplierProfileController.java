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
package com.cn.xiaonuo.modular.SupplierProfile.controller;

import com.cn.xiaonuo.core.annotion.BusinessLog;
import com.cn.xiaonuo.core.annotion.Permission;
import com.cn.xiaonuo.core.enums.LogAnnotionOpTypeEnum;
import com.cn.xiaonuo.core.pojo.response.ResponseData;
import com.cn.xiaonuo.core.pojo.response.SuccessResponseData;
import com.cn.xiaonuo.modular.SupplierProfile.param.SupplierProfileParam;
import com.cn.xiaonuo.modular.SupplierProfile.service.SupplierProfileService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;

/**
 * 供应商档案登记
控制器
 *
 * @author 欧阳
 * @date 2021-01-09 11:25:40
 */
@RestController
public class SupplierProfileController {

    @Resource
    private SupplierProfileService supplierProfileService;

    /**
     * 查询供应商档案登记

     *
     * @author 欧阳
     * @date 2021-01-09 11:25:40
     */
    @Permission
    @GetMapping("/supplierProfile/page")
    @BusinessLog(title = "供应商档案登记 _查询", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData page(SupplierProfileParam supplierProfileParam) {
        return new SuccessResponseData(supplierProfileService.page(supplierProfileParam));
    }

    /**
     * 添加供应商档案登记

     *
     * @author 欧阳
     * @date 2021-01-09 11:25:40
     */
    @Permission
    @PostMapping("/supplierProfile/add")
    @BusinessLog(title = "供应商档案登记 _增加", opType = LogAnnotionOpTypeEnum.ADD)
    public ResponseData add(@RequestBody @Validated(SupplierProfileParam.add.class) SupplierProfileParam supplierProfileParam) {
        supplierProfileService.add(supplierProfileParam);
        return new SuccessResponseData();
    }

    /**
     * 删除供应商档案登记

     *
     * @author 欧阳
     * @date 2021-01-09 11:25:40
     */
    @Permission
    @PostMapping("/supplierProfile/delete")
    @BusinessLog(title = "供应商档案登记 _删除", opType = LogAnnotionOpTypeEnum.DELETE)
    public ResponseData delete(@RequestBody @Validated(SupplierProfileParam.delete.class) SupplierProfileParam supplierProfileParam) {
        supplierProfileService.delete(supplierProfileParam);
        return new SuccessResponseData();
    }

    /**
     * 编辑供应商档案登记

     *
     * @author 欧阳
     * @date 2021-01-09 11:25:40
     */
    @Permission
    @PostMapping("/supplierProfile/edit")
    @BusinessLog(title = "供应商档案登记 _编辑", opType = LogAnnotionOpTypeEnum.EDIT)
    public ResponseData edit(@RequestBody @Validated(SupplierProfileParam.edit.class) SupplierProfileParam supplierProfileParam) {
        supplierProfileService.edit(supplierProfileParam);
        return new SuccessResponseData();
    }

    /**
     * 查看供应商档案登记

     *
     * @author 欧阳
     * @date 2021-01-09 11:25:40
     */
    @Permission
    @GetMapping("/supplierProfile/detail")
    @BusinessLog(title = "供应商档案登记 _查看", opType = LogAnnotionOpTypeEnum.DETAIL)
    public ResponseData detail(@Validated(SupplierProfileParam.detail.class) SupplierProfileParam supplierProfileParam) {
        return new SuccessResponseData(supplierProfileService.detail(supplierProfileParam));
    }

    /**
     * 供应商档案登记
列表
     *
     * @author 欧阳
     * @date 2021-01-09 11:25:40
     */
    @Permission
    @GetMapping("/supplierProfile/list")
    @BusinessLog(title = "供应商档案登记 _列表", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData list(SupplierProfileParam supplierProfileParam) {
        return new SuccessResponseData(supplierProfileService.list(supplierProfileParam));
    }

}
