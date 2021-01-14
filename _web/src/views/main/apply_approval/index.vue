<template>
  <a-card :bordered="false">
    <el-button type="primary">主要按钮</el-button>
    <div class="table-page-search-wrapper" v-if="hasPerm('applyApproval:page')">
      <a-form layout="inline">
        <a-row :gutter="48">
          <a-col :md="8" :sm="24">
            <a-form-item label="" >
              <a-input v-model="queryParam.id" allow-clear placeholder="请输入"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="供应商名称" >
              <a-input v-model="queryParam.supplierName" allow-clear placeholder="请输入供应商名称"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="供应商编号" >
              <a-input v-model="queryParam.supplierNo" allow-clear placeholder="请输入供应商编号"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="电话" >
              <a-input v-model="queryParam.phone" allow-clear placeholder="请输入电话"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="拟供货时间" >
              <a-input v-model="queryParam.supplyTime" allow-clear placeholder="请输入拟供货时间"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="登记人" >
              <a-input v-model="queryParam.registrant" allow-clear placeholder="请输入登记人"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="所在区域" >
              <a-input v-model="queryParam.area" allow-clear placeholder="请输入所在区域"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="备注" >
              <a-input v-model="queryParam.remark" allow-clear placeholder="请输入备注"/>
            </a-form-item>
          </a-col>
          <a-col :md="!advanced && 8 || 24" :sm="24">
            <span class="table-page-search-submitButtons" :style="advanced && { float: 'right', overflow: 'hidden' } || {} ">
              <a-button type="primary" @click="$refs.table.refresh(true)">查询</a-button>
              <a-button style="margin-left: 8px" @click="() => queryParam = {}">重置</a-button>
            </span>
          </a-col>
        </a-row>
      </a-form>
    </div>
    <div class="table-operator" v-if="hasPerm('applyApproval:add')" >
      <a-button type="primary" v-if="hasPerm('applyApproval:add')" icon="plus" @click="$refs.addForm.add()">新增申请登记</a-button>
    </div>
    <s-table
      ref="table"
      size="default"
      :columns="columns"
      :data="loadData"
      :alert="true"
      :rowKey="(record) => record.id"
      :rowSelection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
    >
      <span slot="action" slot-scope="text, record">
        <a v-if="hasPerm('applyApproval:edit')" @click="$refs.editForm.edit(record)">编辑</a>
        <a-divider type="vertical" v-if="hasPerm('applyApproval:edit') & hasPerm('applyApproval:delete')"/>
        <a-popconfirm v-if="hasPerm('applyApproval:delete')" placement="topRight" title="确认删除？" @confirm="() => applyApprovalDelete(record)">
          <a>删除</a>
        </a-popconfirm>
      </span>
    </s-table>
    <add-form ref="addForm" @ok="handleOk" />
    <edit-form ref="editForm" @ok="handleOk" />
  </a-card>
</template>
<script>
  import { STable } from '@/components'
  import { applyApprovalPage, applyApprovalDelete } from '@/api/modular/main/apply_approval/applyApprovalManage'
  import addForm from './addForm.vue'
  import editForm from './editForm.vue'
  export default {
    components: {
      STable,
      addForm,
      editForm
    },
    data () {
      return {
        // 高级搜索 展开/关闭
        advanced: false,
        // 查询参数
        queryParam: {},
        // 表头
        columns: [
            {
              title: '供应商名称',
              dataIndex: 'supplierName'
            },
            {
              title: '供应商编号',
              dataIndex: 'supplierNo'
            },
            {
              title: '电话',
              dataIndex: 'phone'
            },
            {
              title: '拟供货时间',
              dataIndex: 'supplyTime'
            },
            {
              title: '登记人',
              dataIndex: 'registrant'
            },
            {
              title: '所在区域',
              dataIndex: 'area'
            },
            {
              title: '备注',
              dataIndex: 'remark'
            }
        ],
        // 加载数据方法 必须为 Promise 对象
        loadData: parameter => {
          return applyApprovalPage(Object.assign(parameter, this.queryParam)).then((res) => {
            return res.data
          })
        },
        selectedRowKeys: [],
        selectedRows: []
    }
    },
    created () {
      if (this.hasPerm('applyApproval:edit') || this.hasPerm('applyApproval:delete')) {
        this.columns.push({
          title: '操作',
          width: '150px',
          dataIndex: 'action',
          scopedSlots: { customRender: 'action' }
        })
      }
    },
    methods: {
        applyApprovalDelete (record) {
          applyApprovalDelete(record).then((res) => {
          if (res.success) {
            this.$message.success('删除成功')
            this.$refs.table.refresh()
          } else {
            this.$message.error('删除失败') // + res.message
          }
        })
      },
      toggleAdvanced () {
        this.advanced = !this.advanced
      },
      handleOk () {
        this.$refs.table.refresh()
      },
      onSelectChange (selectedRowKeys, selectedRows) {
        this.selectedRowKeys = selectedRowKeys
        this.selectedRows = selectedRows
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
