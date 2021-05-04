import Upload from '../components/Upload'
import HelloWorld from '../components/HelloWorld' 
import { createRouter, createWebHistory } from 'vue-router'

const routes =
    [
        {
            path: '/upload',
            component: Upload
        },
        {
            path: '/hello',
            component: HelloWorld,
            params: {
                msg: "Hello Vue"
            }
        },
        {
            path: '/',
            component: HelloWorld,
            params: {
                msg: "Hello Vue"
            }
        },
    ]

const router = createRouter({
    routes,
    history: createWebHistory(),
})

export default router;