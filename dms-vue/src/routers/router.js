import Upload from '../components/Upload'
import SearchResult from '../components/SearchResult'
import Home from '../components/Home'
import ListFile from '../components/ListFile'
import FileInfoUpdate from '../components/FileInfoUpdate'
import { createRouter, createWebHistory } from 'vue-router'

const routes =
    [
        {
            name: "Upload",
            path: '/upload',
            component: Upload
        },
        {
            name: "Home",
            path: '/home/',
            component: Home,
        },
        {
            name: "ListFile",
            path: '/listfile/',
            component: ListFile,
        },
        {
            path: '/',
            component: Home,
        },
        {
            name: "SearchResult",
            path: '/search/',
            component: SearchResult,
        },
        {
            name: "FileInfoUpdate",
            path: '/fileinfoupdate/',
            component: FileInfoUpdate,
        }
    ]

const router = createRouter({
    routes,
    history: createWebHistory(),
})

export default router;