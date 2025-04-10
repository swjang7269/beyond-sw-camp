<template>
    <div class="parentContainer">
        <SlotChild>
            {{ slotData }}
        </SlotChild>
    </div>
</template>

<!-- 다른 vue 파일을 import 할 때는 내가 원하는 이름으로 쓸 수 있다.(feat. export default이기 때문) -->
<script setup>
    import SlotChild from './SlotChild.vue';
    import {ref} from 'vue';

    const slotData = ref('집 가고 싶다');   // slot은 일반적으로 태그 형태로 전달된다. (상태값이나 데이터는 뒤에 배울 props를 활용하는 편)
</script>

<style scoped>
    .parentContainer{
        display: flex;
        align-items: center;
        flex-direction: column;
        border: 1px solid black;
    }
</style>