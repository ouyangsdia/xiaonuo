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
package com.cn.xiaonuo.modular.apply_approval.controller;

import com.cn.xiaonuo.core.annotion.BusinessLog;
import com.cn.xiaonuo.core.annotion.Permission;
import com.cn.xiaonuo.core.enums.LogAnnotionOpTypeEnum;
import com.cn.xiaonuo.core.pojo.response.ResponseData;
import com.cn.xiaonuo.core.pojo.response.SuccessResponseData;
import com.cn.xiaonuo.modular.apply_approval.param.ApplyApprovalParam;
import com.cn.xiaonuo.modular.apply_approval.service.ApplyApprovalService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;

/**
 * 申请登记控制器
 *
 * @author 欧阳
 * @date 2021-01-10 15:06:47
 */
@RestController
public class ApplyApprovalController {

    @Resource
    private ApplyApprovalService applyApprovalService;

    /**
     * 查询申请登记
     *
     * @author 欧阳
     * @date 2021-01-10 15:06:47
     */
    @Permission
    @GetMapping("/applyApproval/page")
    @BusinessLog(title = "申请登记_查询", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData page(ApplyApprovalParam applyApprovalParam) {
        return new SuccessResponseData(applyApprovalService.page(applyApprovalParam));
    }

    /**
     * 添加申请登记
     *
     * @author 欧阳
     * @date 2021-01-10 15:06:47
     */
    @Permission
    @PostMapping("/applyApproval/add")
    @BusinessLog(title = "申请登记_增加", opType = LogAnnotionOpTypeEnum.ADD)
    public ResponseData add(@RequestBody @Validated(ApplyApprovalParam.add.class) ApplyApprovalParam applyApprovalParam) {
        System.out.println(applyApprovalParam.getArea());
        applyApprovalService.add(applyApprovalParam);

        return new SuccessResponseData();
    }

    /**
     * 删除申请登记
     *
     * @author 欧阳
     * @date 2021-01-10 15:06:47
     */
    @Permission
    @PostMapping("/applyApproval/delete")
    @BusinessLog(title = "申请登记_删除", opType = LogAnnotionOpTypeEnum.DELETE)
    public ResponseData delete(@RequestBody @Validated(ApplyApprovalParam.delete.class) ApplyApprovalParam applyApprovalParam) {
        applyApprovalService.delete(applyApprovalParam);
        return new SuccessResponseData();
    }

    /**
     * 编辑申请登记
     *
     * @author 欧阳
     * @date 2021-01-10 15:06:47
     */
    @Permission
    @PostMapping("/applyApproval/edit")
    @BusinessLog(title = "申请登记_编辑", opType = LogAnnotionOpTypeEnum.EDIT)
    public ResponseData edit(@RequestBody @Validated(ApplyApprovalParam.edit.class) ApplyApprovalParam applyApprovalParam) {
        applyApprovalService.edit(applyApprovalParam);
        return new SuccessResponseData();
    }

    /**
     * 查看申请登记
     *
     * @author 欧阳
     * @date 2021-01-10 15:06:47
     */
    @Permission
    @GetMapping("/applyApproval/detail")
    @BusinessLog(title = "申请登记_查看", opType = LogAnnotionOpTypeEnum.DETAIL)
    public ResponseData detail(@Validated(ApplyApprovalParam.detail.class) ApplyApprovalParam applyApprovalParam) {
        return new SuccessResponseData(applyApprovalService.detail(applyApprovalParam));
    }

    /**
     * 申请登记列表
     *
     * @author 欧阳
     * @date 2021-01-10 15:06:47
     */
    @Permission
    @GetMapping("/applyApproval/list")
    @BusinessLog(title = "申请登记_列表", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData list(ApplyApprovalParam applyApprovalParam) {
        return new SuccessResponseData(applyApprovalService.list(applyApprovalParam));
    }

}
