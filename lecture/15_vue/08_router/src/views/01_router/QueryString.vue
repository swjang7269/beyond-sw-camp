<template>
    <div>
        <h1>QueryString</h1>
        <h2>넘어온 query string값 = {{ currentRoute.query }}</h2>
        <h2>name: {{ name }}</h2>
        <h2>age: {{ currentRoute.query.age }}</h2>
    </div>
</template>

<script setup>
    import {useRoute} from 'vue-router';
    const currentRoute = useRoute();
    const name = currentRoute.query.name;
</script>

<style scoped>

</style>