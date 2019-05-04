import request from './request'

export async function UserRegister (data) {
  return new Promise((resolve, reject) => {
    request.post('/user/register', data)
      .then(res => {
        resolve(res)
      })
      .catch(error => {
        reject(error)
      })
  })
}

export async function GetUserList () {
  return new Promise((resolve, reject) => {
    request.get('/user/list')
      .then(res => {
        resolve(res)
      })
      .catch(error => {
        reject(error)
      })
  })
}
