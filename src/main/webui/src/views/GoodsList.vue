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
                  <td>{{ item.name }}</td>
                  <td>{{ item.nums }}</td>
                  <td>{{ item.price }}</td>
                  <td>{{ getCurrentTime(item.time/1000) }}</td>
                  <td>
                    <v-btn
                      flat
                      small
                      color="primary"
                      @click="viewGoodsQrcode(item.name,item.nums,item.price,item.time,item.description)">
                      查看商品详情
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
import { GetGoodsList } from '../api/good'

export default {

  data: () => ({
    headers: [
      {
        sortable: false,
        text: '商品名称',
        width: 300,
        value: 'name'
      },
      {
        text: '商品数量(个)',
        value: 'nums'
      },
      {
        text: '商品价格(元)',
        value: 'price'
      },
      {
        sortable: false,
        text: '商品最新变动时间',
        value: 'time'
      },
      {
        text: '查看商品详情',
        sortable: false
      }
    ],
    items: []
  }),
  created () {
    GetGoodsList()
      .then(res => {
        this.items = res.data.data
        console.log(this.items)
      }).catch(error => {
        console.log(error)
      })
  },
  methods: {
    viewGoodsQrcode (data1, data2, data3, data4, data5) {
      this.$router.push({
        path: '/goods-qrcode',
        query: {
          name: data1,
          nums: data2,
          price: data3,
          time: data4,
          desc: data5
        }
      })
    },
    getCurrentTime (time) {
      let date = new Date(time)
      let ds = date.getFullYear() + '-' + (date.getMonth() < 10 ? '0' + (date.getMonth() + 1) : (date.getMonth() + 1)) + '-' + (date.getDate() < 10 ? '0' + date.getDate() : date.getDate())
      return ds
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
