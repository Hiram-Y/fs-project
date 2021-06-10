import { layout } from '../config'

export const blanks = [{
  path: '/oa/form/model',
  meta: { title: '表单设计器' },
  component: () => import(/* webpackChunkName: 'oa' */ '@/views/oa/form/model')
}, {
  path: '/oa/workflow/model',
  meta: { title: '流程设计器' },
  component: () => import(/* webpackChunkName: 'oa' */ '@/views/oa/workflow/model')
}]

export const layouts = [{
  path: '/oa',
  meta: { title: '在线办公' },
  component: layout.route,
  children: [{
    path: '/oa/index/index',
    meta: { title: '工作面板' },
    component: layout.default
  }, {
    path: '/oa/form/frame',
    meta: { title: '表单模型' },
    component: () => import(/* webpackChunkName: 'oa' */ '@/views/oa/form/frame')
  }, {
    path: '/oa/form/data',
    meta: { title: '托管数据' },
    component: () => import(/* webpackChunkName: 'oa' */ '@/views/oa/form/data')
  }, {
    path: '/oa/form/list',
    meta: { title: '表单数据' },
    component: () => import(/* webpackChunkName: 'oa' */ '@/views/oa/form/list')
  }, {
    path: '/oa/form/regular',
    meta: { title: '校验规则' },
    component: () => import(/* webpackChunkName: 'oa' */ '@/views/oa/form/regular')
  }, {
    path: '/oa/workflow/list',
    meta: { title: '流程模型' },
    component: () => import(/* webpackChunkName: 'oa' */ '@/views/oa/workflow/list')
  }, {
    path: '/oa/workflow/deployment',
    meta: { title: '流程部署' },
    component: () => import(/* webpackChunkName: 'oa' */ '@/views/oa/workflow/deployment')
  }, {
    path: '/oa/approve/workflow',
    meta: { title: '流程单据' },
    component: () => import(/* webpackChunkName: 'oa' */ '@/views/oa/approve/workflow')
  }, {
    path: '/oa/approve/form',
    meta: { title: '单据填报' },
    component: () => import(/* webpackChunkName: 'oa' */ '@/views/oa/approve/form')
  }]
}]

export default { blanks, layouts }
