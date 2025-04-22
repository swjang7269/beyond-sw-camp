import {createRouter, createWebHistory} from 'vue-router';

// 리소스 낭비를 피하기 위해 컴포넌트가 필요할 떄 임포트 하도록 바꿀 수 있다.
import HomeView from '@/views/01_router/HomeView.vue';
import RootRouter from '@/views/02_nestedRouter/RootRouter.vue';
// import NestedHome from '@/views/02_nestedRouter/NestedHome.vue';
import NestedView from '@/views/02_nestedRouter/NestedView.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: HomeView
        },
        {
            path: '/nested',        // /nested + home/view -> /nested/home or /nested/view
            component: RootRouter,
            // 중첩 라우팅에서 하위 컴포넌트를 위한 라우팅에서는 path에 '/'를 쓰지 않아야 한다.
            children: [
                {
                    path: 'home',
                    // lazy loaded: 코드를 분할(청크)해서 필요한 시점에 가져옴으로 메모리 낭비를 줄이고, 속도 및 성능 향상을 도모할 수 있다.(코드 스플리팅)
                    component: () => import('@/views/02_nestedRouter/NestedView.vue')
                },
                {
                    path: 'view',
                    component: NestedView
                }
            ]
        }
    ]
})

export default router;