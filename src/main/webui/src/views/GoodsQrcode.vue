<template>
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
          wrap
        >
          <v-flex
            xs12
            md8
          >
            <material-card
              color="green"
              title="用户信息"
              text="用户个人信息以及二维码"
            >
              <v-form>
                <v-container py-0>
                  <v-layout wrap>
                    <v-flex
                      xs12
                      md12
                    >
                      <v-text-field
                        v-model = "name"
                        class="purple-input"
                        label="商品名称"
                        disabled
                      />
                    </v-flex>
                    <v-flex
                      xs12
                      md12
                    >
                      <v-text-field
                        v-model="nums"
                        label="商品数量"
                        class="purple-input"
                        disabled
                      />
                    </v-flex>
                    <v-flex
                      xs12
                      md12
                    >
                      <v-text-field
                        v-model="price"
                        label="商品价格"
                        class="purple-input"
                        disabled
                      />
                    </v-flex>
                    <v-flex
                      xs12
                      md12
                    >
                      <v-text-field
                        v-model="time"
                        label="商品最新信息变动时间"
                        class="purple-input"
                        disabled
                      />
                    </v-flex>
                    <v-flex
                      xs12
                      md12
                    >
                      <v-text-field
                        v-model="desc"
                        label="商品描述"
                        class="purple-input"
                        disabled
                      />
                    </v-flex>
                  </v-layout>
                </v-container>
              </v-form>
            </material-card>
          </v-flex>
          <v-flex
            xs12
            md4
          >
            <div
              id="qrcode"
              class="qrcode">用户二维码</div>
          </v-flex>
        </v-layout>
      </v-container>
    </template>

  </v-container>
</template>

<script>
import QRCode from 'qrcodejs2'

export default {
  data: () => ({
    text: '',
    name: '',
    nums: 0,
    price: 0,
    time: '',
    desc: ''
  }),
  mounted () {
    this.name = this.$route.query.name
    this.nums = this.$route.query.nums
    this.price = this.$route.query.price
    this.desc = this.$route.query.desc
    this.time = '格式错误'
    this.text = `商品名称: ${this.$route.query.name}
    商品数量(个): ${this.$route.query.nums}
    商品价格(元): ${this.$route.query.price}
    商品信息变动时间: ${this.$route.query.time}
    商品描述: ${this.$route.query.desc}
    `
    this.qrcode()
  },
  methods: {
    qrcode () {
      let q = new QRCode('qrcode', {
        width: 200,
        height: 200,
        text: this.text,
        render: 'canvas',
        background: '#f0f',
        foreground: '#ff0'
      })
      console.log(q)
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

    .qrcode {
        margin-top: 50px;
        margin-left: 40px;
    }
</style>
