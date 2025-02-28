package com.ohgiraffers.section02.annotation.subsection04.resource;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceResource")
public class PokemonService {
    /* 설명. @Primary보다 더 높은 우선순위를 가지며 bean의 id(이름)으로 하나의 빈을 선정 */
    /*
    @Resource(name = "pikachu")     // @Primary보다 더 높은 우선도
    private Pokemon pokemon;

    public void pokemonAttack() {
        pokemon.attack();
    }
    */

    @Resource   // 생성자 주입은 안된다.
    private List<Pokemon> pokemonList;

    public void pokemonAttack() {
        pokemonList.forEach(Pokemon::attack);
    }
}
