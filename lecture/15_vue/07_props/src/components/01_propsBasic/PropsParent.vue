<!-- 
    props와 slot의 차이점
    props는 부모가 자식에게 '데이터'를 전달할 때 사용
    slot은 부모자 자식에게 '태그'를 전달할 때 사용

    props는 기본적으로 readonly의 개념을 통해 자식 컴포넌트에서 수정해도 부모에 영향을 주지 말아햐 한다.
        - 안티 패턴 방지

    props는 전달할 때 한 계층씩만 내려간다. 
    깊은 계층에서만 사용하는 경우 사용하지 않는 층을 거쳐서 한층씩 전달하게되는 props drilling이라는 안티패턴이 발생할 수 있다.
    이를 피하기 위해 별도의 저장공간을 만들어 props를 저장(provide)하면 필요한 곳에서 가져다 쓰는(inject) 방법이 있다.
        - 허나 패턴이 복잡해질 수 있으며 남용하면 좋은 패턴이 아니다.
-->

<template>
    <div :class="{container:true, dark:darkState}">
        <!-- 원하는 이름으로 부모 컴포넌트의 데이터를 전달할 수 있다. 일반적으로는 같은 이름을 사용 -->
        <PropsChild :message="message"/>    <!-- message라는 변수 명으로 "message(ref()) 반응형 변수" 전달 -->

        <!-- props는 아니지만 직접 사용자 정의형 이벤트인 toggle을 전달 -->
        <!-- DarkMode에서는 부모의 상태를 직접 바꾸는 것이 아니라 toggle을 작동하면 부모에서 toggleDarkMode를 작동시켜 상태를 변화시킨다. -->
        <DarkMode @toggle="toggleDarkMode"/>

        <ReadProps :readValue="readValue"/>
    </div>
</template>

<script setup>
    import PropsChild from './PropsChild.vue';
    import DarkMode from './DarkMode.vue';
    import ReadProps from './ReadProps.vue';

    import {ref} from 'vue';

    const message = ref('집 가고 싶다');
    const darkState = ref(false);
    const readValue = ref('나는 소망한다 가기를 집에');

    function toggleDarkMode() {
        darkState.value = !darkState.value;
    }
</script>

<style scoped>
    .container{
        border: 1px solid;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .dark{
        background-color: black;
        color: white;
    }
</style>