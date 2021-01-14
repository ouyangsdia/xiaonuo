<template>
 <a-card :bordered="false">
   <div>
     <a-divider orientation="left">主信息</a-divider>

     <a-form :form="form">
       <a-row :gutter="24">
         <a-col :md="12" :sm="24">
           <a-form-item
             label="供应商名称"
             :labelCol="labelCol"
             :wrapperCol="wrapperCol"
             has-feedback
           >
             <a-input
               placeholder="请输入供应商名称"
               v-decorator="['supplierName', {rules: [{required: true, message: '请输入供应商名称！'}]}]" />
           </a-form-item>
         </a-col>
         <a-col :md="12" :sm="24">
           <a-form-item
             label="供应商编号"
             :labelCol="labelCol"
             :wrapperCol="wrapperCol"
             has-feedback
           >
             <a-input
               placeholder="请输入供应商编号"
               v-decorator="['supplierNo', {rules: [{required: true, message: '请输入供应商编号！'}]}]" />
           </a-form-item>
         </a-col>
       </a-row>
       <a-row :gutter="24">
         <a-col :md="12" :sm="24">
           <a-form-item
             label="电话"
             :labelCol="labelCol"
             :wrapperCol="wrapperCol"
             has-feedback
           >
             <a-input placeholder="请输入电话" v-decorator="['phone', {rules: [{required: true, message: '请输入电话！'}]}]" />
           </a-form-item>
         </a-col>
         <a-col :md="12" :sm="24">
           <a-form-item
             label="拟供货时间"
             :labelCol="labelCol"
             :wrapperCol="wrapperCol"
             has-feedback
           >
             <a-input
               placeholder="请输入拟供货时间"
               v-decorator="['supplyTime', {rules: [{required: true, message: '请输入拟供货时间！'}]}]" />
           </a-form-item>
         </a-col>
       </a-row>
       <a-row :gutter="24">
         <a-col :md="12" :sm="24">
           <a-form-item
             label="登记人"
             :labelCol="labelCol"
             :wrapperCol="wrapperCol"
             has-feedback
           >
             <a-input
               placeholder="请输入登记人"
               v-decorator="['registrant', {rules: [{required: true, message: '请输入登记人！'}]}]" />
           </a-form-item>

         </a-col>
         <a-col :md="12" :sm="24">
           <a-form-item
             label="所在区域"
             :labelCol="labelCol"
             :wrapperCol="wrapperCol"
             has-feedback
           >
             <a-input placeholder="请输入所在区域" v-decorator="['area', {rules: [{required: true, message: '请输入所在区域！'}]}]" />
           </a-form-item>

         </a-col>
       </a-row>
       <a-row :gutter="24">
         <a-col :md="12" :sm="24">
           <a-form-item
             label="备注"
             :labelCol="labelCol"
             :wrapperCol="wrapperCol"
             has-feedback
           >
             <a-input placeholder="请输入备注" v-decorator="['remark', {rules: [{required: true, message: '请输入备注！'}]}]" />
           </a-form-item>
         </a-col>
         <a-col :md="12" :sm="24"></a-col>
       </a-row>

     </a-form>

   </div>
 </a-card>
</template>

<script>
export default {
  name: 'Add',
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
  }
}
</script>

<style lang="less">
.table-operator {
  margin-bottom: 18px;
}
button {
  margin-right: 8px;
}
</style>
