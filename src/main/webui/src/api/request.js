import axios from 'axios'
import { Message } from 'element-ui'

const service = axios.create({
  baseURL: 'http://localhost:7654/v0',
  timeout: 10000 // request timeout
})

service.interceptors.request.use(config => {
  return config
}, error => {
  console.log(error) // for debug
  Promise.reject(error)
})

service.interceptors.response.use(
  response => response,
  error => {
    console.log('err' + error)// for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
