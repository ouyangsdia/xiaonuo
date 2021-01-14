import { axios } from '@/utils/request'

/**
 * 查询申请登记
 *
 * @author 欧阳
 * @date 2021-01-14 16:09:44
 */
export function applyApprovalPage (parameter) {
  return axios({
    url: '/applyApproval/page',
    method: 'get',
    params: parameter
  })
}

/**
 * 申请登记列表
 *
 * @author 欧阳
 * @date 2021-01-14 16:09:44
 */
export function applyApprovalList (parameter) {
  return axios({
    url: '/applyApproval/list',
    method: 'get',
    params: parameter
  })
}

/**
 * 添加申请登记
 *
 * @author 欧阳
 * @date 2021-01-14 16:09:44
 */
export function applyApprovalAdd (parameter) {
  return axios({
    url: '/applyApproval/add',
    method: 'post',
    data: parameter
  })
}

/**
 * 编辑申请登记
 *
 * @author 欧阳
 * @date 2021-01-14 16:09:44
 */
export function applyApprovalEdit (parameter) {
  return axios({
    url: '/applyApproval/edit',
    method: 'post',
    data: parameter
  })
}

/**
 * 删除申请登记
 *
 * @author 欧阳
 * @date 2021-01-14 16:09:44
 */
export function applyApprovalDelete (parameter) {
  return axios({
    url: '/applyApproval/delete',
    method: 'post',
    data: parameter
  })
}
