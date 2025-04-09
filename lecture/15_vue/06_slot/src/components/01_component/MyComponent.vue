<!-- 모든 컴포넌트를 App.vue에 붙이면 App.vue가 index.html에 부착된다. -->
<template>
    <div>
        <h1 id="test">MyComponent</h1>
    </div>
</template>

<script setup>

</script>

<style scoped>
    #test {
        color: blue;
    }
</style>