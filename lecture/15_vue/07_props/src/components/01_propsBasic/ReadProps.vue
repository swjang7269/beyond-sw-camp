<!-- 
    vue는 기본적으로 자식 컴포넌트에서 부모 컴포넌트로부터 전달받은 props를 직접 수정해도
    부모 컴포넌트에 있는 데이터가 수정되지 않는다.(readOnly)
-->

<template>
    <h1>{{ props.readValue }}</h1>
    자식의 readValue: <input type="text" v-model="props.readvalue">
</template>

<script setup>
    import { defineProps } from 'vue';

    const props = defineProps({
        readValue: String
    });
</script>

<style scoped>

</style>