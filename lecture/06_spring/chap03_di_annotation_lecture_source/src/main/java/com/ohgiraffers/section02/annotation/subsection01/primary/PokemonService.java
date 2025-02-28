package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {
    private Pokemon pokemon;

    // Pokemon 타입으로 주입될 수 있는 bean은 현재 3가지(Pikachu, Chamander, Squirtle)가 있다.
    // Pokemon 타입이 3가지가 있어 생성자 주입에서 에러가 뜸
    // 한놈만 매칭이 되도록 설정을 해줘야함 -> @Primary 어노테이션을 이용하여 우선도를 설정(해당 예제에선 @Primary가 붙은 Chamander가 주입됨)

    @Autowired  // 생성자 주입은 @Autowired 생략 가능
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    // 타입 은닉에 의해 pokemon에 무엇이 들어가는지 의존 주입 전까지 모르고 있으며
    // 주입하는 pokemon이 바뀌더라도 해당 코드는 수정할 필요가 없어진다. -> 유지보수성 향상
    public void pokemonAttack() {
        pokemon.attack();
    }
}
