<template>
  <v-app>
    <el-container v-if="$route.meta.keepAlive">
      <core-filter/>

      <core-toolbar/>

      <core-drawer/>

      <core-view/>
    </el-container>
    <router-view v-else-if="!$route.meta.keepAlive"/>
  </v-app>
</template>

<style lang="scss">
    @import '@/styles/index.scss';

    /* Remove in 1.2 */
    .v-datatable thead th.column.sortable i {
        vertical-align: unset;
    }
</style>
