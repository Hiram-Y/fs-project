<template>
  <section>
    <div class="fs-property-title">基础信息</div>
    <a-form-model-item label="节点">{{ value.id }}</a-form-model-item>
    <a-form-model-item label="类型">{{ value.type }}</a-form-model-item>
    <a-form-model-item label="名称"><a-input v-model="value.name" :placeholder="value.id" /></a-form-model-item>
    <a-form-model-item label="标题"><a-input v-model="value.title" /></a-form-model-item>
    <a-form-model-item label="备注"><a-textarea v-model="value.description" /></a-form-model-item>
    <div class="fs-property-title">流程配置</div>
    <a-form-model-item label="跳过执行"><a-switch v-model="value.skiped" /></a-form-model-item>
    <a-form-model-item label="触发条件"><a-textarea v-model="value.condition" /></a-form-model-item>
  </section>
</template>

<script>
export default {
  name: 'SliceBasic',
  props: {
    value: { type: Object, required: true },
    config: { type: Object, required: true },
    activeItem: { type: Object, required: true }
  },
  data () {
    return {}
  },
  computed: {
    hasAlias () {
      return ['Source', 'Transform'].some(suffix => this.value.type.endsWith(suffix))
    },
    hasPrefix () {
      return ['Source', 'Transform', 'Sink'].some(suffix => this.value.type.endsWith(suffix))
    }
  },
  watch: {
    'activeItem.id': {
      handler () {
        this.$emit('input', this.formatted(this.value))
      },
      immediate: true
    }
  },
  methods: {
    formatted (obj) {
      const data = {
        name: obj.name || '',
        title: obj.title || '',
        description: obj.description || '',
        skiped: !!obj.skiped,
        condition: obj.condition || ''
      }
      const result = Object.assign({}, obj, data)
      return result
    }
  }
}
</script>

<style lang="less" scoped>

</style>
