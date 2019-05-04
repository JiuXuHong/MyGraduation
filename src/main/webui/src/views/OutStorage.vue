<template>
  <v-container>
    <core-filter/>

    <core-toolbar/>

    <core-drawer/>

    <template>
      <v-container
        class="container"
        fluid
        grid-list-xl>
        <v-layout
          justify-center
          wrap
        >
          <v-flex
            xs12
            md12
          >
            <material-card
              color="green"
              title="出库信息"
              text="除了描述，其他都为必填项"
            />
          </v-flex>
          <v-flex
            xs12
            md12
          />
        </v-layout>
      </v-container>
    </template>
  </v-container>

</template>

<script>

export default {
  name: 'OutStorage',
  data: () => ({
  }),
  methods: {
  }
}
</script>

<style scoped>
    .container {
        margin-right: 0px;
    }

</style>
