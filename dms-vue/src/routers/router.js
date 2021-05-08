import Upload from '../components/Upload'
import SearchResult from '../components/SearchResult'
import HelloWorld from '../components/HelloWorld'
import { createRouter, createWebHistory } from 'vue-router'

const routes =
    [
        {
            name: "Upload",
            path: '/upload',
            component: Upload
        },
        {
            name: "HelloWorld",
            path: '/hello/',
            component: HelloWorld,
        },
        {
            path: '/',
            component: HelloWorld,
        },
        {
            name: "SearchResult",
            path: '/search/',
            component: SearchResult,
        },
    ]

const router = createRouter({
    routes,
    history: createWebHistory(),
})

export default router;