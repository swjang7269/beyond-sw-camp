<template>
    <div>
        <h3>GrandChild: {{ injectedCount }}</h3>
        <!-- GrandChild에서 조작한 값이 Parent에도 반영된다. -->
        <button @click="injectedCount++">GrandChild에서 값 증가</button>
    </div>
</template>

<script setup>
    import { inject } from 'vue';
    const injectedCount = inject('count');
</script>

<style scoped>

</style>