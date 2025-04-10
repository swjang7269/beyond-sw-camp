<template>
    <div>
        <h1>Home</h1>
        <button @click="changeRouter(10)">router 경로 변경</button>
    </div>
</template>

<script setup>
    import {useRouter} from 'vue-router'

    const router =useRouter();

    function changeRouter(id) {
        router.push(`/pathvariable/${id}`);
    }
</script>

<style scoped>

</style>