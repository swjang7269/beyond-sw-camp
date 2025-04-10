<template>
    <div>
        <h1>parent: {{ count }}</h1>
        <DrillingChild/>
    </div>
</template>

<!-- 
    Props Drilling
    상위 컴포넌트에서 하위 컴포넌트로 데이터를 전달하는 과정에서 중간에 너무 많은 여러 컴포넌트를 거쳐가는 경우가 생길 수 있다.
    이렇게 여러 컴포넌트를 거쳐 props를 전달하다 보면 코드를 복잡하게 만들고 유지보수를 힘들게 한다.
    vue에서는 필요한 상위 컴포넌트를 원하는 하위 컴포넌트 중에 필요 시 inject하여 어디서든 꺼내 쓸 수 있는 방법을 제공한다.
    단, readonly를 고려하는 편이 유지보수 측면에서 도움이 될 가능성이 높다.

    단점
    1. 어떤 자식 컴포넌트가 inject해 갔는지 알기가 쉽지 않다.
    2. readonly를 고려해야 한다.
    3. 중간에 여러 컴포넌트가 있으면 구조를 더 복잡하게 할 수 있다.

    장점
    1. props drilling을 피해 유지보수가 쉬워질 수 있다.
-->

<script setup>
    import DrillingChild from './DrillingChild.vue';
    import {ref, provide} from 'vue';
    
    const count = ref(1);
    provide('count', readonly(count));    // key, value 개념  해당 컴포넌트의 하위 컴포넌트들은 provide에 접근 가능하다. 공유 저장소 느낌
    // readOnly를 이용하여 자식 컴포넌트에서 조작이 불가하게 만들 수 있다.
</script>

<style scoped>

</style>