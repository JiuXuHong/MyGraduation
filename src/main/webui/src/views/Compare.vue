<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-container>
    <core-filter class="core-filter"/>

    <core-toolbar class="core-toolbar"/>

    <core-drawer/>

    <template>
      <v-container class="container">
        <v-flex xs12>
          <h3
            ref="radio"
            class="headline">Choose the type of comparison</h3>
          <v-radio-group
            v-model="type"
            row>
            <v-radio
              label="TwoFile"
              value="two"/>
            <v-radio
              label="AllFile"
              value="all"/>
          </v-radio-group>
          <v-text-field
            v-model="sourceFile"
            :rules="fileRules"
            label="Source File"
            required/>
          <v-text-field
            v-if="type === 'two'"
            :rules="fileRules"
            v-model="targetFile"
            label="Target File"/>
        </v-flex>

        <div>
          <v-dialog
            v-model="dialog"
            width="700"
          >
            <template v-slot:activator="{ on }">
              <v-flex>
                <v-btn
                  ref="button"
                  color="primary"
                  block
                  v-on="on"
                  @click="compareFile">Compare</v-btn>
              </v-flex>
            </template>
            <v-card>
              <v-card-title
                class="headline grey lighten-2"
                primary-title
              >
                Compare Result
              </v-card-title>

              <template>
                <v-data-table
                  :headers="headers"
                  :items="results"
                  class="elevation-1"
                  width="600"
                >
                  <template v-slot:items="props">
                    <td>{{ props.item.a_file }}</td>
                    <td>{{ props.item.b_file }}</td>
                    <td>{{ props.item.similarity }}</td>
                  </template>
                </v-data-table>
              </template>

              <v-divider/>

              <v-card-actions>
                <v-spacer/>
                <v-btn
                  color="primary"
                  flat
                  @click="cleanUp"
                >
                  I accept
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </div>
        <v-snackbar
          v-model="showLackPath"
          :timeout="3000"
          left
          bottom
          color="#c0392b"
        >
          <div style="display: flex;">
            <v-icon dark>remove_circle_outline</v-icon>
            <div style="margin-top: 2px; margin-left: 15px;">{{ errInfo }}</div>
          </div>
        </v-snackbar>
      </v-container>
    </template>
  </v-container>
</template>
<script>
import { compare2File, compareAllFile } from '../api/file'

export default {
  name: 'Compare',

  data () {
    return {
      showLackPath: false,
      errInfo: '',
      type: 'two',
      sourceFile: '',
      targetFile: '',
      fileRules: [
        v => !!v || 'Path is required'
      ],
      dialog: false,
      headers: [
        {
          text: 'SourceFile',
          align: 'left',
          sortable: false,
          value: 'a_file'
        },
        {
          text: 'TargetFile',
          value: 'b_file'
        },
        {
          text: 'Similarity',
          value: 'similarity'
        }
      ],
      results: []
    }
  },
  methods: {
    cleanUp () {
      this.dialog = false
      this.sourceFile = ''
      this.targetFile = ''
      this.results = []
    },
    compareFile () {
      if (this.type === 'two') {
        if (this.sourceFile.trim() === '' || this.targetFile.trim() === '') {
          this.errInfo = '路径名不为空'
          this.showLackPath = true
          return
        }
        let compareBody = {
          'a_path': this.sourceFile,
          'b_path': this.targetFile
        }

        compare2File(compareBody)
          .then(res => {
            if (res.data.code === 0) {
              this.results = res.data.data
              console.log(this.results)
            } else {
              this.errInfo = res.data.message
              this.showLackPath = true
            }
          })
          .catch(error => {
            this.errInfo = error
            this.showLackPath = true
          })
      } else {
        if (this.sourceFile.trim() === '') {
          this.errInfo = '路径名不为空'
          this.showLackPath = true
          return
        }
        compareAllFile(this.sourceFile)
          .then(res => {
            if (res.data.code === 0) {
              this.results = res.data.data
              console.log(this.results)
            } else {
              this.errInfo = res.data.message
              this.showLackPath = true
            }
          })
          .catch(error => {
            this.errInfo = error
            this.showLackPath = true
          })
      }
    }
  }
}
</script>

<style scoped>
    .container {
        margin-right: 0px;
    }
    .elevation-1 {
      width: 650px;
      margin: 10px auto;
    }
</style>
