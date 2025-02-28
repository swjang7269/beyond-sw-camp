package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceCollection")
public class PokemonService {
    // 3종류의 포켓몬을 모두 의존성 주입을 하겠다.
    /* 설명. 같은 타입의 bean이 2개 이상일 경우, List 또는 Map 형태의 컬렉션 형태로 주입 받을 수 있다. */

    /* 설명. 1. 같은 타입의 bean을 List 형태로 주입 */
    /*
    private final List<Pokemon> pokemonList;

    // 생성자 주입이 일어나며 bean이 주입되는 순서는 beanId의 알파벳 순서이다.
    @Autowired
    public PokemonService(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
    public void pokemonAttack() {
        pokemonList.forEach(pokemon -> pokemon.attack());
    }
    */

    /* 설명. 2. 같은 타입의 bean을 map 형태로도 주입 받을 수 있다. */
    private final Map<String, Pokemon> pokemonMap;

    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    /* 설명. key값은 bean의 이름이 넘어옴 */
    public void pokemonAttack() {
        pokemonMap.forEach((k, v) -> {
            System.out.println("key = " + k);
            System.out.println("value = " + v);
            v.attack();
        });
    }
}
