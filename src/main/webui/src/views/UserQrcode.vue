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
                        v-model = "username"
                        class="purple-input"
                        label="User Name"
                        disabled
                      />
                    </v-flex>
                    <v-flex
                      xs12
                      md12
                    >
                      <v-text-field
                        v-model="password"
                        label="password"
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
    username: '',
    password: ''
  }),
  mounted () {
    this.username = this.$route.query.username
    this.password = this.$route.query.password
    this.text = `用户名: ${this.$route.query.username}
    密码: ${this.$route.query.password}`
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
