<template>
    <div>
        <h1>parent: {{ count }}</h1>
        <DrillingChild/>
    </div>
</template>

<script setup>
    import DrillingChild from './DrillingChild.vue';
    import {ref, provide} from 'vue';
    
    const count = ref(1);
    provide('count', readonly(count));    // key, value 개념  해당 컴포넌트의 하위 컴포넌트들은 provide에 접근 가능하다. 공유 저장소 느낌
    // readOnly를 이용하여 자식 컴포넌트에서 조작이 불가하게 만들 수 있다.
</script>

<style scoped>

</style>