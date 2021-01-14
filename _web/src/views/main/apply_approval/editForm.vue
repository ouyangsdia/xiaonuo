<template>
  <a-modal
    title="编辑申请登记"
    :width="900"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleSubmit"
    @cancel="handleCancel"
  >
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">
        <a-form-item v-show="false">
          <a-input v-decorator="['id']" />
        </a-form-item>
        <a-form-item
          label="供应商名称"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入供应商名称" v-decorator="['supplierName', {rules: [{required: true, message: '请输入供应商名称！'}]}]" />
        </a-form-item>
        <a-form-item
          label="供应商编号"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入供应商编号" v-decorator="['supplierNo', {rules: [{required: true, message: '请输入供应商编号！'}]}]" />
        </a-form-item>
        <a-form-item
          label="电话"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入电话" v-decorator="['phone', {rules: [{required: true, message: '请输入电话！'}]}]" />
        </a-form-item>
        <a-form-item
          label="拟供货时间"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入拟供货时间" v-decorator="['supplyTime', {rules: [{required: true, message: '请输入拟供货时间！'}]}]" />
        </a-form-item>
        <a-form-item
          label="登记人"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入登记人" v-decorator="['registrant', {rules: [{required: true, message: '请输入登记人！'}]}]" />
        </a-form-item>
        <a-form-item
          label="所在区域"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入所在区域" v-decorator="['area', {rules: [{required: true, message: '请输入所在区域！'}]}]" />
        </a-form-item>
        <a-form-item
          label="备注"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入备注" v-decorator="['remark', {rules: [{required: true, message: '请输入备注！'}]}]" />
        </a-form-item>

      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
  import { applyApprovalEdit } from '@/api/modular/main/apply_approval/applyApprovalManage'
  export default {
    data () {
      return {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 }
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 15 }
        },
        visible: false,
        confirmLoading: false,
        form: this.$form.createForm(this)
      }
    },
    methods: {
      // 初始化方法
      edit (record) {
        this.visible = true
        setTimeout(() => {
          this.form.setFieldsValue(
            {
              id: record.id,
              supplierName: record.supplierName,
              supplierNo: record.supplierNo,
              phone: record.phone,
              supplyTime: record.supplyTime,
              registrant: record.registrant,
              area: record.area,
              remark: record.remark
            }
          )
        }, 100)
      },
      handleSubmit () {
        const { form: { validateFields } } = this
        this.confirmLoading = true
        validateFields((errors, values) => {
          if (!errors) {
              applyApprovalEdit(values).then((res) => {
              if (res.success) {
                this.$message.success('编辑成功')
                this.confirmLoading = false
                this.$emit('ok', values)
                this.handleCancel()
              } else {
                this.$message.error('编辑失败')//  + res.message
              }
            }).finally((res) => {
              this.confirmLoading = false
            })
          } else {
            this.confirmLoading = false
          }
        })
      },
      handleCancel () {
        this.form.resetFields()
        this.visible = false
      }
    }
  }
</script>
