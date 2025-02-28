package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {
    /* 설명. bean에 @Primary가 설정되어 있더라도 주입을 받는 시점에 원하는 bean을 고를 수 있다. */
    // @Qualifier는 @Primay보다 강력
//    @Autowired
//    @Qualifier("squirtle")  // 주입할 bean을 id를 이용해 설정 가능
    private Pokemon pokemon;

    // Pokemon 타입으로 주입될 수 있는 bean은 현재 3가지(Pikachu, Chamander, Squirtle)가 있다.
    // Pokemon 타입이 3가지가 있어 생성자 주입에서 에러가 뜸
    // 한놈만 매칭이 되도록 설정을 해줘야함

    // subsection02에선 @Primary말고 다른 방법으로 주입될 Pokemon 타입을 설정해 보겠다.
    // 생성자 주입시 @Qualifier를 앞에 추가하여 주입할 bean을 고를 수 있다.
    @Autowired  // 생성자 주입은 @Autowired 생략 가능
    public PokemonService(@Qualifier("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    // 타입 은닉에 의해 pokemon에 무엇이 들어가는지 의존 주입 전까지 모르고 있으며
    // 주입하는 pokemon이 바뀌더라도 해당 코드는 수정할 필요가 없어진다. -> 유지보수성 향상
    public void pokemonAttack() {
        pokemon.attack();
    }
}
