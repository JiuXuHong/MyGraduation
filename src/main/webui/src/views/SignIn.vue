<template>
  <v-app>
    <v-toolbar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>TrueCowHeart</span>
      </v-toolbar-title>
      <v-spacer/>
      <span
        class="font-weight-light"
        style="font-size: 20px">
        PaperChecking
      </span>
    </v-toolbar>

    <template>
      <v-parallax
        :height="fullHeight"
        dark
        src="https://cdn.vuetifyjs.com/images/backgrounds/vbanner.jpg">
        <v-layout
          align-center
          column
          justify-center>
          <h1
            class="display-2 font-weight-thin mb-3"
            @click="dialog = true">CHECKING FILE</h1>
          <h4
            class="subheading"
            @click="dialog = true ">Sign in to TCH</h4>
          <v-dialog
            v-model="dialog"
            persistent
            max-width="600px">
            <v-card>
              <v-card-title>
                <span class="headline">Sign in to TCH</span>
              </v-card-title>
              <v-card-text>
                <v-container grid-list-md>
                  <v-layout wrap>
                    <v-flex xs12>
                      <v-text-field
                        v-model="username"
                        label="用户账号*"
                        required/>
                    </v-flex>
                    <v-flex xs12>
                      <v-text-field
                        v-model="password"
                        label="用户密码*"
                        required/>
                    </v-flex>
                  </v-layout>
                </v-container>
                <small>*indicates required field</small>
              </v-card-text>
              <v-card-actions>
                <v-spacer/>
                <v-btn
                  color="blue darken-1"
                  flat
                  @click="dialog = false">Close</v-btn>
                <v-btn
                  color="blue darken-1"
                  flat
                  @click="getLoginInfo">
                  Login
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
          <v-snackbar
            v-model="showLackUsername"
            :timeout="3000"
            left
            bottom
            color="#c0392b"
          >
            <div style="display: flex;">
              <v-icon dark>remove_circle_outline</v-icon>
              <div style="margin-top: 2px; margin-left: 15px;">用户名不能为空</div>
            </div>
          </v-snackbar>
          <v-snackbar
            v-model="showLackUserPassword"
            :timeout="3000"
            left
            bottom
            color="#c0392b"
          >
            <div style="display: flex;">
              <v-icon dark>remove_circle_outline</v-icon>
              <div style="margin-top: 2px; margin-left: 15px;">密码不能为空</div>
            </div>
          </v-snackbar>
          <v-snackbar
            v-model="showLoginFail"
            :timeout="3000"
            left
            bottom
            color="#c0392b"
          >
            <div style="display: flex;">
              <v-icon dark>remove_circle_outline</v-icon>
              <div style="margin-top: 2px; margin-left: 15px;">登陆失败</div>
            </div>
          </v-snackbar>
        </v-layout>
      </v-parallax>
    </template>
    <v-footer
      class="pa-3"
      postion="relative">
      <div class="footer">&copy; {{ new Date().getFullYear() }} 版权归属牛心正</div>
    </v-footer>
  </v-app>
</template>

<script>

export default {

  data () {
    return {
      fullHeight: window.innerHeight,
      dialog: false,
      username: 'TestCase',
      password: 'TestCase',
      showLackUsername: false,
      showLackUserPassword: false,
      showLoginFail: false
    }
  },
  methods: {
    getLoginInfo () {
      if (this.username.trim() === '') {
        this.showLackUsername = true
        return
      }
      if (this.password.trim() === '') {
        this.showLackUserPassword = true
        return
      }
      this.$router.push('/user-register')
    }
  }
}
</script>

<style scoped>
    .footer {
        margin-left: auto;
        margin-right: auto;
    }
</style>
