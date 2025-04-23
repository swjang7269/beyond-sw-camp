<template>
  <div class="plus">
      <h1>덧셈 기능 만들기</h1>
      <label>num: 1</label><input type="text" v-model="num1">&nbsp;
      <label>num: 2</label><input type="text" v-model="num2">&nbsp;
      <button @click="sendPlus">더하기</button>
      <hr>
      <p>{{ num1 }} + {{ num2 }} = {{ sum }}</p>
  </div>
</template>

<script setup>
  import {ref} from 'vue';

  const num1 = ref(0);
  const num2 = ref(0);
  const sum = ref(0);

  const sendPlus = async() => {
    // 1. 백엔드에서 CORS, 프론트에서 X
    // 백엔드에서 해당 origin에서 오는 요청은 허용하겠다는 설정
    // const response = await fetch(`http://localhost:7777/plus?num1=${num1.value}&num2=${num2.value}`)

    // 2. 백엔드에서 X, 프론트에서 CORS
    // api로 시작하는 요청을 가로채서 node.js 서버에서 프록시 설정을 통해 대신 요청을 전송하겠다.
    // const response = await fetch(`http://localhost:5173/api/plus?num1=${num1.value}&num2=${num2.value}`);

    // - post 요청 & request body 활용(백엔드도 수정)
    // const response = await fetch(`http://localhost:5173/api/plus`, {
    //   method: 'POST',
    //   headers: {
    //     'Content-Type': 'application/json;charset=UTF-8'
    //   },
    //   body: JSON.stringify({num1: num1.value, num2: num2.value})
    // })

    // 3. 백엔드에서 cors, 프론트에서 X (둘 다 docker container로 올린 상태)
    // const response = await fetch(`http://localhost:8055/plus`, {
    //   method: 'POST',
    //   headers: {
    //     'Content-Type': 'application/json;charset=UTF-8'
    //   },
    //   body: JSON.stringify({num1: num1.value, num2: num2.value})
    // })

    // 4. 백엔드에서 x, 프론트에서 cors(docer-compose를 활용해 네트워크로 통신, 둘 다 컨테이너)

    // 5. 백엔드에서 cors, 프론트에서 x(kubernetes의 백엔드 워커 노드로 요청)
    // const response = await fetch(`http://localhost:30001/plus`, { // 백엔드 워커노드의 포트 번호
    //   method: 'POST',
    //   headers: {
    //     'Content-Type': 'application/json;charset=UTF-8'
    //   },
    //   body: JSON.stringify({num1: num1.value, num2: num2.value})
    // })

    // 6. kubernetes에 nginx + ingress를 추가(프론트에서 X, 백엔드에서 X)
    const response = await fetch(`/boot/plus`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=UTF-8'
      },
      body: JSON.stringify({num1: num1.value, num2: num2.value})
    })

    const data = await response.json();
    console.log('data:', data);
    sum.value = data.sum;
  }


</script>

<style scoped>
  .plus {
      text-align: center;
  }
</style>