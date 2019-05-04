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
              title="入库信息"
              text="除了描述，其他都为必填项"
            >
              <v-form>
                <v-container py-0>
                  <v-layout wrap>
                    <v-flex
                      xs12
                      md12
                    >
                      <v-text-field
                        label="南农科技有限公司"
                        disabled/>
                    </v-flex>
                    <v-flex
                      xs12
                      md12
                    >
                      <v-text-field
                        v-model="name"
                        label="商品名称"
                        class="purple-input"/>
                    </v-flex>
                    <v-flex
                      xs12
                      md6
                    >
                      <v-text-field
                        v-model="nums"
                        label="商品数量(>0个）"
                        class="purple-input"/>
                    </v-flex>
                    <v-flex
                      xs12
                      md6>
                      <v-text-field
                        v-model="price"
                        label="价格(>0元）"
                        class="purple-input"/>
                    </v-flex>
                    <v-flex
                      xs12
                      md12>
                      <v-text-field
                        v-model="description"
                        label="商品描述"
                        class="purple-input"/>
                    </v-flex>
                    <v-flex
                      xs12
                      text-xs-right
                    >
                      <v-btn
                        class="mx-0 font-weight-light"
                        color="success"
                        @click="addGoods"
                      >
                        商品入库
                      </v-btn>
                    </v-flex>
                  </v-layout>
                  <v-snackbar
                    v-model="showLackStorageInfo"
                    :timeout="3000"
                    left
                    bottom
                    color="#c0392b"
                  >
                    <div style="display: flex;">
                      <v-icon dark>remove_circle_outline</v-icon>
                      <div style="margin-top: 2px; margin-left: 15px;">请按照要求填入入库信息</div>
                    </div>
                  </v-snackbar>
                  <v-snackbar
                    v-model="showRegisterSuccess"
                    :timeout="3000"
                    left
                    bottom
                    color="#4CAF50"
                  >
                    <div style="display: flex;">
                      <v-icon dark>remove_circle_outline</v-icon>
                      <div style="margin-top: 2px; margin-left: 15px;">入库成功</div>
                    </div>
                  </v-snackbar>
                  <v-snackbar
                    v-model="showRegisterFailed"
                    :timeout="3000"
                    left
                    bottom
                    color="#c0392b"
                  >
                    <div style="display: flex;">
                      <v-icon dark>remove_circle_outline</v-icon>
                      <div style="margin-top: 2px; margin-left: 15px;">入库失败</div>
                    </div>
                  </v-snackbar>
                </v-container>
              </v-form>
            </material-card>
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
import { AddGoodsToStorage } from '../api/good'

export default {
  name: 'UserProfile',
  data: () => ({
    name: '',
    nums: 0,
    price: 0,
    description: '',
    showLackStorageInfo: false,
    showRegisterSuccess: false,
    showRegisterFailed: false
  }),
  methods: {
    addGoods () {
      this.nums = parseInt(this.nums)
      this.price = parseInt(this.price)
      if (this.name.trim() === '' || this.price === 0 || this.nums === 0) {
        this.showLackStorageInfo = true
        return
      }
      let jsonObjArr = [{
        'name': this.name,
        'nums': this.nums,
        'price': this.price,
        'description': this.description
      }]

      AddGoodsToStorage(jsonObjArr).then(
        res => {
          this.name = ''
          this.description = ''
          this.nums = 0
          this.price = 0
          if (res.data.code === 0) {
            this.showRegisterSuccess = true
            return
          }
          this.showRegisterFailed = true
        }
      ).catch(error => {
        console.log(error)
      })
    }
  }
}
</script>

<style scoped>
    .container {
        margin-right: 0px;
    }

    .user-footer {
        margin-right: 0px;
        margin-bottom: 0px;
    }
</style>
