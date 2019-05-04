/**
 * Define all of your application routes here
 * for more information on routes, see the
 * official documentation https://router.vuejs.org/en/
 */
export default [
  {
    path: '/tch',
    view: 'SignIn'
  },
  {
    path: '/user-list',
    view: 'UserList'
  },
  {
    path: '/user-register',
    view: 'UserRegister'
  },
  {
    path: '/goods-list',
    view: 'GoodsList'
  },
  {
    path: '/goods-in',
    view: 'InStorage'
  },
  {
    path: '/goods-out',
    view: 'OutStorage'
  },
  {
    path: '/user-qrcode',
    view: 'UserQrcode'
  },
  {
    path: '/goods-qrcode',
    view: 'GoodsQrcode'
  }
]
