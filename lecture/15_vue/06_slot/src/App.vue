<!-- Vue Official / Vue vscode Snippet 플러그인 설치 -->
<!-- vbase-3-setup으로 틀을 잡고 scss 관련 부분 삭제 -->

<!-- 
    template
    vue는 사용자의 화면에 보여질 부분을 template 영역에 html 요소들로 작성한다.
        template 태그는 DOM tree로 구성되지 않고 렌더링 될 때 해석되지 않는다.
-->
<template>
    <div class="redColor">
        <p>ㅎㅇ?</p>
        <MyComponent/>
    </div>
</template>

<!-- 
    script setup
    해당 컴포넌트에 적용할 setup 안에 작성했던 내용(반응형 변수 / 반응형 변수를 활용하는 함수 / 라이프사이클 훅)이 작성되는 영역
-->

<script setup>
    import MyComponent from './components/01_component/MyComponent.vue';
</script>

<!-- 
    style scoped 
    현재 컴포넌트에서만 적용되는 스타일을 작성한다.(범위 css)
    - 해당 컴포넌트가 또 다른 컴포넌트를 들고 있으면 하위 컴포넌트에도 적용되는 css
-->

<style scoped>
    .redColor {
        color: red;
    }
</style>