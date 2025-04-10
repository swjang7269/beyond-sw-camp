<template>
    <h3>전달받은 props: {{ props.message }}</h3>
</template>

<script setup>
    import { defineProps } from 'vue';
    const props = defineProps({
        message: String // 부모로부터 넘겨받은 props의 변수명과 타입을 적어준다.
    })
</script>

<style scoped>

</style>