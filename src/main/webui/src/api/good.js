import request from './request'

export async function AddGoodsToStorage (data) {
  return new Promise((resolve, reject) => {
    request.post('/goods/add', data)
      .then(res => {
        resolve(res)
      })
      .catch(error => {
        reject(error)
      })
  })
}

export async function GetGoodsList () {
  return new Promise((resolve, reject) => {
    request.get('/goods/list')
      .then(res => {
        resolve(res)
      })
      .catch(error => {
        reject(error)
      })
  })
}
