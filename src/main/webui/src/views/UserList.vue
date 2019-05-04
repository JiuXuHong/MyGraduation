<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-container>
    <core-filter class="core-filter"/>

    <core-toolbar class="core-toolbar"/>

    <core-drawer/>

    <template>
      <v-container
        class="container"
        fluid
        grid-list-xl>
        <v-layout
          justify-center
          wrap>
          <v-flex md12>
            <material-card
              color="green"
              title="用户清单"
              text="当前表格展示所有用户，其中用户的密码都经过md5加密处理">
              <v-data-table
                :headers="headers"
                :items="items"
                hide-actions>
                <template
                  slot="headerCell"
                  slot-scope="{ header }">
                  <span
                    class="subheading font-weight-light text-success text--darken-3"
                    v-text="header.text"
                  />
                </template>
                <template
                  slot="items"
                  slot-scope="{ item }"
                >
                  <td>{{ item.username }}</td>
                  <td>{{ item.password }}</td>
                  <td>
                    <v-btn
                      flat
                      color="primary"
                      @click="viewQrcode(item.username,item.password)">
                      点击查看二维码
                    </v-btn>
                  </td>
                </template>
              </v-data-table>
            </material-card>
          </v-flex>

        </v-layout>
      </v-container>
    </template>
  </v-container>
</template>

<script>
import { GetUserList } from '../api/user'

export default {

  data: () => ({
    headers: [
      {
        sortable: false,
        text: '用户名',
        width: 300,
        value: 'username'
      },
      {
        sortable: false,
        text: '密码',
        value: 'password'
      }, {
        sortable: false,
        text: '   二维码'
      }
    ],
    items: []
  }),
  created () {
    GetUserList()
      .then(res => {
        this.items = res.data.data
      }).catch(error => {
        console.log(error)
      })
  },
  methods: {
    viewQrcode (data1, data2) {
      console.log(data1)
      console.log(data2)
      this.$router.push({
        path: '/user-qrcode',
        query: {
          username: data1,
          password: data2
        }
      })
    }
  }
}
</script>

<style>
    .container {
        margin-right: 0px;
    }

    .core-toolbar {
        margin-top: 20px;
        margin-right: 40px;
    }
</style>
