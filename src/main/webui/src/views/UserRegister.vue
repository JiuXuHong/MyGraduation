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
            md8
          >
            <material-card
              color="green"
              title="用户注册"
              text="其中账户和密码属于必填信息"
            >
              <v-form>
                <v-container py-0>
                  <v-layout wrap>
                    <v-flex
                      xs12
                      md4
                    >
                      <v-text-field
                        label="Company (disabled)"
                        disabled/>
                    </v-flex>
                    <v-flex
                      xs12
                      md4
                    >
                      <v-text-field
                        v-model = "username"
                        class="purple-input"
                        label="User Name"
                      />
                    </v-flex>
                    <v-flex
                      xs12
                      md4
                    >
                      <v-text-field
                        label="Email Address"
                        class="purple-input"/>
                    </v-flex>
                    <v-flex
                      xs12
                      md12
                    >
                      <v-text-field
                        v-model="password"
                        label="password"
                        class="purple-input"/>
                    </v-flex>
                    <v-flex
                      xs12
                      md12
                    >
                      <v-text-field
                        label="Adress"
                        class="purple-input"/>
                    </v-flex>
                    <v-flex
                      xs12
                      md4>
                      <v-text-field
                        label="City"
                        class="purple-input"/>
                    </v-flex>
                    <v-flex
                      xs12
                      md4>
                      <v-text-field
                        label="Country"
                        class="purple-input"/>
                    </v-flex>
                    <v-flex
                      xs12
                      md4>
                      <v-text-field
                        class="purple-input"
                        label="Postal Code"
                        type="number"/>
                    </v-flex>
                    <v-flex
                      xs12
                      text-xs-right
                    >
                      <v-btn
                        class="mx-0 font-weight-light"
                        color="success"
                        @click="userRegister"
                      >
                        User Register
                      </v-btn>
                    </v-flex>
                  </v-layout>
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
                    v-model="showLackPassword"
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
                    v-model="showRegisterSuccess"
                    :timeout="3000"
                    left
                    bottom
                    color="#4CAF50"
                  >
                    <div style="display: flex;">
                      <v-icon dark>remove_circle_outline</v-icon>
                      <div style="margin-top: 2px; margin-left: 15px;">注册成功</div>
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
                      <div style="margin-top: 2px; margin-left: 15px;">注册失败</div>
                    </div>
                  </v-snackbar>
                </v-container>
              </v-form>
            </material-card>
          </v-flex>
          <v-flex
            xs12
            md4
          >
            <material-card class="v-card-profile">
              <v-avatar
                slot="offset"
                class="mx-auto d-block"
                size="130"
              >
                <img
                  src="../../public/favicon.png"
                >
              </v-avatar>
              <v-card-text class="text-xs-center">
                <h6 class="category text-gray font-weight-thin mb-3">CEO / TCH-FOUNDER</h6>
                <h4 class="card-title font-weight-light">Hong JiuXu</h4>
                <p class="card-description font-weight-light">Don't be scared of the truth because we need
                to restart the human foundation in truth And I love you like Kanye loves Kanye I love
                Rick Owens’ bed design but the back is...</p>
                <v-btn
                  color="success"
                  round
                  class="font-weight-light"
                  @click="goToMyGit"
                >follow
                </v-btn>
              </v-card-text>
            </material-card>
          </v-flex>
        </v-layout>
      </v-container>
    </template>
  </v-container>

</template>

<script>
import { UserRegister } from '../api/user'

export default {
  name: 'UserProfile',
  data: () => ({
    username: '',
    password: '',
    showLackUsername: false,
    showLackPassword: false,
    showRegisterSuccess: false,
    showRegisterFailed: false
  }),
  methods: {
    goToMyGit () {
      window.location.href = 'https://github.com/JiuXuHong/MyGraduation'
    },
    userRegister () {
      if (this.username.trim() === '') {
        this.showLackUsername = true
        return
      }
      if (this.password === '') {
        this.showLackPassword = true
        return
      }
      let jsonObj = {
        'username': this.username,
        'password': this.password
      }

      UserRegister(jsonObj).then(
        res => {
          this.username = ''
          this.password = ''
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
