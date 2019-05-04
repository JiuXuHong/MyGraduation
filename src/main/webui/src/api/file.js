import request from './request'
export async function getFileList () {
  return new Promise((resolve, reject) => {
    request.get('/file/ls?path=/')
      .then(res => {
        resolve(res)
      })
      .catch(error => {
        reject(error)
      })
  })
}

export async function compare2File (data) {
  return new Promise((resolve, reject) => {
    request.post('/file/compare/two', data)
      .then(res => {
        resolve(res)
      })
      .catch(error => {
        reject(error)
      })
  })
}

export async function compareAllFile (path) {
  return new Promise((resolve, reject) => {
    request.get('/file/compare/all?path=' + path)
      .then(res => {
        resolve(res)
      })
      .catch(error => {
        reject(error)
      })
  })
}
